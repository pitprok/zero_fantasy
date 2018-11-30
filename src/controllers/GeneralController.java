package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String index() {
		System.out.println("ok");
		return "index";
	}
	
	@RequestMapping("/alignment")
	public String alignment() {
		return "alignment";
	}
	
	@RequestMapping("/test")
	public ModelAndView test(ModelAndView modelAndView) {
		Location location=new Location();
		List <Location> locationList=locationDAO.selectLocation("A");
		modelAndView.addObject("location",locationList.get(0));
		modelAndView.setViewName("test");

		return modelAndView;
	}



	@RequestMapping(value = "/ajaxsearch", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody String getAllGuestsByRest(@RequestParam(value = "form-input-name") String id)
			throws JsonProcessingException {


		ObjectMapper mapper = new ObjectMapper();
//		System.out.println(mapper.writeValueAsString(userList));
		return mapper.writeValueAsString("gsadgadsg");
	}

	@RequestMapping(value = "/insert")
	public ModelAndView insertUser(User player, ModelAndView modelAndView, HttpServletRequest request, String password2) {
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
