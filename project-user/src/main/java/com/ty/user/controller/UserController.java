package com.ty.user.controller;

import com.ty.helper.UserControllerHelper;


public class UserController {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the DataBase....Users");
		while(true) {
			switch (UserControllerHelper.getChoices()) {
			case 1:{
				UserControllerHelper.saveUser();
				break;
			}
			case 2:{
				UserControllerHelper.updateUser();
				break;
			}	
			case 3:{
				UserControllerHelper.findUser();
				break;
			}	
			case 4:{
				UserControllerHelper.removeUser();
				break;
			}
			case 5:{
				System.out.println("Thank You ....... Visit Again...!!");
				return;
			}
			default:{
				System.out.println("Enter the correct input choices");
				break;
			}
			}
			
		}
	}

}
