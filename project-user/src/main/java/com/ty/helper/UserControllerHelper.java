package com.ty.helper;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.user.dao.UserDao;
import com.ty.user.dto.MyConfig;

public class UserControllerHelper {
	
	private static ConfigurableApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfig.class);
	private static Scanner sc=(Scanner) applicationContext.getBean("scanner");
	public static int getChoices() {
		System.out.println("Enter 1 for save User");
		System.out.println("Enter 2 for Update User");
		System.out.println("Enter 3 for Find User");
		System.out.println("Enter 4 for Delete User");
		System.out.println("Enter 5 for Exit ");
		System.out.println("Enter the choices to be Performed");
		int choices=sc.nextInt();
		return choices;
	}
	
	public static void findUser() {
		System.out.println("Welcome to the Find Operation :");
		UserHelper.findUser();
	}
	
	public static UserDao getUserDao() {
		UserDao userdao=applicationContext.getBean(UserDao.class);
		return userdao;
	}
	public static void removeUser() {
		UserHelper.removeUser();
	}
	public static void updateUser() {
		UserHelper.upadateUserDetails();
	}
	public static void saveUser() {
		getUserDao().saveUser(UserHelper.getUser());
	}
}
