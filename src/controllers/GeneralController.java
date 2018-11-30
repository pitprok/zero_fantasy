package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.LocationDAO;
import dao.UserDAO;
import models.*;

@Controller
public class GeneralController {

	@Autowired
//	@Qualifier("hsdl")
	UserDAO userDAO;

	@Autowired
//	@Qualifier("hsdl")
	LocationDAO locationDAO;

	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("username", "tester");
		session.setAttribute("currentLocation", "A");
		System.out.println("ok");
		return "forward:/game";
	}

	@RequestMapping("/game")
	public ModelAndView test(ModelAndView modelAndView, HttpSession session) {

		List<Location> locationList = locationDAO.selectLocation((String) session.getAttribute("currentLocation"));
		List<User> userList = userDAO.selectUser((String) session.getAttribute("username"));
		session.setAttribute("location", locationList.get(0));
		session.setAttribute("player", userList.get(0));
		modelAndView.setViewName("test");
		return modelAndView;
	}

	@RequestMapping("/advance")
	public ModelAndView advance(ModelAndView modelAndView, HttpSession session, String choice) {
		String currentLocation = (String) session.getAttribute("currentLocation");
		String nextLocation = currentLocation + choice;
		if (choice.equals("A")) {
			session.setAttribute("previousChoice",
					((Location) session.getAttribute("location")).getFirstConsequenceText());
		} else if (choice.equals("B")) {
			session.setAttribute("previousChoice",
					((Location) session.getAttribute("location")).getSecondConsequenceText());
		}
		User user = (User) session.getAttribute("player");
		// Edit user according to consequence
		System.out.println(nextLocation	);
		List<Location> locationList = locationDAO.selectLocation(nextLocation);
		List<User> userList = userDAO.selectUser((String) session.getAttribute("username"));

		session.setAttribute("location", locationList.get(0));
		session.setAttribute("player", userList.get(0));
		session.setAttribute("currentLocation", nextLocation);
		modelAndView.setViewName("test");
		return modelAndView;
	}

	@RequestMapping("/alignment")
	public String alignment() {
		return "alignment";
	}

	@RequestMapping(value = "/fastadvance", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody String ajaxAdvance(String locationcode, HttpSession session) throws JsonProcessingException {
		session.setAttribute("currentLocation", locationcode);
		List<Location> locationList = locationDAO.selectLocation((String) session.getAttribute("currentLocation"));
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(locationList.get(0)));
		return mapper.writeValueAsString(locationList.get(0));
	}

	@RequestMapping(value = "/insert")
	public ModelAndView insertUser(User player, ModelAndView modelAndView, HttpServletRequest request,
			String password2) {
//      (To be fixed)modelAndView.setView(new RedirectView(request.getContextPath()+"/jsp-name"));

//		playerDAO.insert(player);

		return modelAndView;
	}

	@RequestMapping(value = "/loginform")
	public ModelAndView userLogin(ModelAndView modelAndView) {
//      (To be fixed)modelAndView.setViewName("jsp-name");
		User player = new User();
		modelAndView.addObject("user", player);

		return modelAndView;
	}

	@RequestMapping(value = "/registrationform")
	public ModelAndView insertUserForm(ModelAndView modelAndView) {
		User player = new User();
//      (To be fixed)modelAndView.setViewName("registration-jsp-name");
		modelAndView.addObject("user", player);

		return modelAndView;
	}

}
