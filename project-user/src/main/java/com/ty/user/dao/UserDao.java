package com.ty.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ty.user.dto.Users;

@Component
public class UserDao {
	@Autowired
	@Qualifier(value = "entityManager")
	EntityManager entityManager;
	@Autowired
	@Qualifier(value = "entityTranscation")
	EntityTransaction entityTransaction;

	//save User Object in the database
	public Users saveUser(Users user) {
		if (user != null && searchUserByEmail(user.getUser_Email())) {
			  entityTransaction.begin(); 
			  entityManager.persist(user);
			  entityTransaction.commit();	 
		} else {
			user = null;
		}
		return user;
	}

	//search user object by Email
	public boolean searchUserByEmail(String user_Email) {
		List<Users> users = null;
		if (user_Email != null) {
			Query query =entityManager .createQuery("Select u from Users u where u.user_Email=?1");
			query.setParameter(1, user_Email);
			users = query.getResultList();
		}
		return users.size() == 0;
	}
	//search user object by Email
		public Users findUserByEmail(String user_Email) {
			List<Users> users = null;
			if (user_Email != null) {
				Query query =entityManager .createQuery("Select u from Users u where u.user_Email=?1");
				query.setParameter(1, user_Email);
				users = query.getResultList();
			}
			return users.get(0);
		}
	
	//search User object by Id
	public Users searchUserById(int user_Id) {
		return entityManager.find(Users.class, user_Id);
		
	}
	
	//Update User object
	public  Users updateDetails( Users users) {
		if(users!=null) {
			
			entityTransaction.begin();
			entityManager.merge(users);
			entityTransaction.commit();
		}
		
		return users;
	}
	
	//delete User Object by userId from Table
	public boolean deleteUserByUserId(int user_Id) {
		if(user_Id>0) {
			Users users=searchUserById(user_Id);
			if(users!=null) {
				entityTransaction.begin();
				entityManager.remove(users);
				entityTransaction.commit();
				return true;
			}
		}
		return false;
	}
	
	//delete User Object by userEmail from Table
	public boolean deleteUserByUserEmail(String user_Email) {
		if(user_Email!=null) {
			Users users=findUserByEmail(user_Email);
			if(users!=null) {
				entityTransaction.begin();
				entityManager.remove(users);
				entityTransaction.commit();
				return true;
			}
		}
		return false;
	}
}
