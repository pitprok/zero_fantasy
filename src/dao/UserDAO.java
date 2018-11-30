package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import models.User;

@Repository
public class UserDAO {
	

		@PersistenceContext
		private EntityManager em;
		

		public UserDAO(EntityManager em) {
			this.em = em;
		}


		public UserDAO() {

		}

		public List<User> selectAllMembers() {

			String sql = "SELECT * FROM user";
			List<User> userList = (List<User>) this.em.createNativeQuery(sql, User.class).getResultList();
			return userList;
		}

		public boolean userLogin(User player) {

			String sql = "SELECT user FROM User user WHERE user.username=:username";
			Query query = this.em.createQuery(sql, User.class);
//			query.setParameter("username", [user.getUsername());
			List<User> userList = (List<User>) query.getResultList();
		

			return false;
		}

		public List<User> selectUser(String searchWord) {

			String sql = "SELECT user FROM User user WHERE user.username LIKE :username";
			Query query = this.em.createQuery(sql, User.class).setParameter("username", "%" + searchWord + "%");
			List<User> userList = (List<User>) query.getResultList();
			return userList;
		}


		@Transactional
		public void deleteMembers(String username) {
//	        em.getTransaction().begin();
//	        em.merge(member);
			User userToDelete = em.find(User.class, username);
			em.remove(userToDelete);
//	        em.flush();
//	        em.getTransaction().commit();
		}
		
		@Transactional
		public User findMember(String username) {
//	        em.getTransaction().begin();
//	        em.merge(member);
			User user = em.find(User.class, username);
//	        em.flush();
//	        em.getTransaction().commit();
			return user;
		}

		@Transactional
		public void insert(User member) {
			EntityManager em=getEntityManager();
//	        em.getTransaction().begin();
			em.persist(member);
//	        em.flush();
//	        em.getTransaction().commit();
		}
		
		public EntityManager getEntityManager() {
			return em;
		}
	}


