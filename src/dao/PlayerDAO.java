package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import models.Player;

@Repository
public class PlayerDAO {
	

		@PersistenceContext
		private EntityManager em;
		

		public PlayerDAO(EntityManager em) {
			this.em = em;
		}


		public PlayerDAO() {

		}

		public List<Player> selectAllMembers() {

			String sql = "SELECT * FROM user";
			List<Player> userList = (List<Player>) this.em.createNativeQuery(sql, Player.class).getResultList();
			return userList;
		}

		public boolean userLogin(Player player) {

			String sql = "SELECT user FROM User user WHERE user.username=:username";
			Query query = this.em.createQuery(sql, Player.class);
//			query.setParameter("username", [player.getUsername());
			List<Player> userList = (List<Player>) query.getResultList();
		

			return false;
		}

		public List<Player> selectMembers(String searchWord) {

			String sql = "SELECT user FROM User user WHERE user.username LIKE :username";
			Query query = this.em.createQuery(sql, Player.class).setParameter("username", "%" + searchWord + "%");
			List<Player> userList = (List<Player>) query.getResultList();
			return userList;
		}


		@Transactional
		public void deleteMembers(String username) {
//	        em.getTransaction().begin();
//	        em.merge(member);
			Player userToDelete = em.find(Player.class, username);
			em.remove(userToDelete);
//	        em.flush();
//	        em.getTransaction().commit();
		}
		
		@Transactional
		public Player findMember(String username) {
//	        em.getTransaction().begin();
//	        em.merge(member);
			Player member = em.find(Player.class, username);
//	        em.flush();
//	        em.getTransaction().commit();
			return member;
		}

		@Transactional
		public void insert(Player member) {
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


