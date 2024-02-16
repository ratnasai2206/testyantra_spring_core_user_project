package com.ty.helper;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.user.dto.MyConfig;
import com.ty.user.dto.Users;

public class UserHelper {

	private static ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			MyConfig.class);
	private static Scanner sc = (Scanner) applicationContext.getBean("scanner");

	public static Users getUser() {
		System.out.println("Welcome to the save Operation :");

		System.out.println("enter the User name : ");
		String name = sc.next();
		System.out.println("enter the User email : ");
		String email = sc.next();
		System.out.println("enter the User Password : ");
		String password = sc.next();
		System.out.println("enter the User Designation : ");
		String designation = sc.next();
		System.out.println("enter the User Salary : ");
		double salary = sc.nextDouble();
		Users user = applicationContext.getBean(Users.class);
		user.setUser_Email(email);
		user.setUser_Name(name);
		user.setUser_Password(password);
		user.setUser_Salary(salary);
		user.setUser_Designation(designation);
		return user;
	}

	public static void findUser() {

		while (true) {
			System.out.println("Enter 1 for by ID");
			System.out.println("Enter 2 for by Email");
			System.out.println("Enter 3 for Exit the Search Operation ");
			System.out.println("Enter the choice to be performed :");
			int key = sc.nextInt();
			switch (key) {
			case 1: {
				System.out.println("Enter the User ID to be Search :");
				int user_Id = sc.nextInt();
				Users users = UserControllerHelper.getUserDao().searchUserById(user_Id);
				displayUser(users);
				break;
			}
			case 2: {
				System.out.println("Enter the User Email to be Search :");
				String user_Email = sc.next();
				Users users = UserControllerHelper.getUserDao().findUserByEmail(user_Email);
				displayUser(users);
				break;
			}
			case 3: {
				break;
			}
			default: {
				System.out.println("Enter the correct input choices");
				break;
			}
			}
			if (key == 3) {
				break;
			}

		}
	}

	private static void displayUser(Users users) {
		System.out.println("-----------------------Users Details-----------------------------");
		System.out.println("User Id is: " + users.getUser_Id());
		System.out.println("User Name is: " + users.getUser_Name());
		System.out.println("User Email is: " + users.getUser_Email());
		System.out.println("User Password  is: " + users.getUser_Password());
		System.out.println("User Salary is: " + users.getUser_Salary());
		System.out.println("-----------------------------------------------------------------");

	}

	public static void removeUser() {
		System.out.println("Welcome to the Delete Operation :");
		while (true) {
			System.out.println("Enter 1 for Delete by ID");
			System.out.println("Enter 2 for Delete by Email");
			System.out.println("Enter 3 for Exit the Delete Operation ");
			System.out.println("Enter the choice to be performed :");
			int key = sc.nextInt();
			switch (key) {
			case 1: {
				System.out.println("Enter the User ID to be Removed the record :");
				int user_Id = sc.nextInt();
				if (UserControllerHelper.getUserDao().deleteUserByUserId(user_Id)) {
					System.out.println("Record removed Successfully");
				} else {
					System.out.println("Record not removed from the database");
				}

				break;
			}
			case 2: {
				System.out.println("Enter the User Email to be Removed the record :");
				String user_Email = sc.next();
				if (UserControllerHelper.getUserDao().deleteUserByUserEmail(user_Email)) {
					System.out.println("Record removed Successfully");
				} else {
					System.out.println("Record not removed from the database");
				}
				break;
			}
			case 3: {
				break;
			}

			default: {
				System.out.println("Enter the correct input choices");
				break;
			}
			}
			if (key == 3) {
				break;
			}
		}

	}

	public static void upadateUserDetails() {
		System.out.println("Welcome to the Update Operation :");
		while (true) {
			System.out.println("Enter 1 for Update by ID");
			System.out.println("Enter 2 for Update by Email");
			System.out.println("Enter 3 for Exit the Update Operation ");
			System.out.println("Enter the choice to be performed :");
			int key = sc.nextInt();
			switch (key) {
			case 1: {
				System.out.println("Enter the User ID to be Update the record :");
				int user_Id = sc.nextInt();
				Users users = UserControllerHelper.getUserDao().searchUserById(user_Id);
				if (users != null) {
					updateDetails(users);
				}
				break;
			}
			case 2: {
				System.out.println("Enter the User Email to be Update the record :");
				String user_Email = sc.next();
				Users users = UserControllerHelper.getUserDao().findUserByEmail(user_Email);
				if (users != null) {
					updateDetails(users);
				}
				break;
			}
			case 3: {
				break;
			}
			default: {
				System.out.println("Enter the correct input choices");
				break;
			}
			}
			if (key == 3) {
				break;
			}
		}
	}
	
	private static void updateDetails(Users users){
		while(true) {
			System.out.println("Enter 1 for Update the Name");
			System.out.println("Enter 2 for Update the Email");
			System.out.println("Enter 3 for Update the Password");
			System.out.println("Enter 4 for Update the Designation");
			System.out.println("Enter 5 for Update the Salary");
			System.out.println("Enter 6 for Exit the Update Operation ");
			System.out.println("Enter the choices to performed to update the field");
			int key=sc.nextInt();
			switch (key) {
			case 1:{
				System.out.println("Enter the name to update :");
				String str=sc.next();
				users.setUser_Name(str);
				break;
			}
			case 2:{
				System.out.println("Enter the Email to update :");
				String str=sc.next();
				users.setUser_Email(str);
				break;
			}
			case 3:{
				System.out.println("Enter the Password to update :");
				String str=sc.next();
				users.setUser_Password(str);
				break;
				
			}
			case 4:{
				System.out.println("Enter the  to designation update :");
				String str=sc.next();
				users.setUser_Password(str);
				break;
			}
			case 5:{
				System.out.println("Enter the  to salary update :");
				double str=sc.nextDouble();
				users.setUser_Salary(key);
				break;
			}
			case 6:{
				break;
			}	
				
			default: {
				System.out.println("Enter the correct input choices");
				break;
			}
			}
			if (key == 6) {
				break;
			}
			displayUser(UserControllerHelper.getUserDao().updateDetails(users));
			
		}
	}
}
