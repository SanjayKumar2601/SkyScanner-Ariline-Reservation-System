//package com.virtusa.SkyScanner.validation;
//
//import com.virtusa.SkyScanner.exceptins.MyExceptions;
//
//public class validations{
//	
//	public boolean emailValidation(String email)throws MyExceptions {
//
//		if(email.matches("[a-zA-Z0-9_'*+.-]+@[a-zA-Z0-9.-]+."))
//			return true;
//		else {
//			//System.out.println("email invalid");
//			throw new MyExceptions("Enter a valid email id");
//		}
//		
//	}
//
//	public boolean validatephones(String phone) throws MyExceptions{
//		
//		if(phone.matches("[6-9]{1}+[0-9]{9}"))
//			return true;
//		else
//			//System.out.println("phone invalid");
//			throw new MyExceptions("Enter a valid phone number");
//		
//	}
//	}