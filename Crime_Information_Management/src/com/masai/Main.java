package com.masai;

import com.masai.*;
import java.util.*;
import com.masai.entities.Crime;
import com.masai.utility.*;
import com.masai.exceptions.InvalidInputSelectionException;
import com.masai.exceptions.InvalidLoginCrediantials;

public class Main {
	private static void adminLogin(Scanner sc) {
		try {
			System.out.println("Enter username ");
			String username = sc.next();
			System.out.println("Enter your password");
			String password = sc.next();
			if (username.equals(Admin.username) && password.equals(Admin.password)) {
				System.out.println("Welocome Admin How can I help you ?");
				adminServices(sc);
			} else {
				throw new InvalidLoginCrediantials("Invalid Credentials");
			}
		} catch (InvalidLoginCrediantials e) {
			System.out.println(e.getMessage());
		}

	}

	public static void adminServices(Scanner sc) {
		try {
			System.out.println("1. Add a new crime");
			System.out.print("");
			System.out.println("2. Update crime ");
			System.out.print("");
			System.out.println("3. Update criminal details");
			System.out.print("");
			System.out.println("4. Assign criminal to a crime");
			System.out.print("");			
			int num = sc.nextInt();
			switch(num) {
			case 1:
				addNewCrime();
				break;
			case 2:
				updateCrime();
				break;
			case 3:
				updateCriminalDetais();
				break;
			case 4:
				assignCriminalToCrime();
				break;
			default:
				throw new InvalidInputSelectionException("Invalid selection " + num);
			}
		}catch(InvalidInputSelectionException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void updateCrime() {
		// TODO Auto-generated method stub
		
	}

	private static void assignCriminalToCrime() {
		// TODO Auto-generated method stub
		
	}

	private static void updateCriminalDetais() {
		// TODO Auto-generated method stub
		
	}

	private static void addNewCrime() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) throws InvalidInputSelectionException {
		Scanner sc = new Scanner(System.in);
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("Welcome to crime Management System .. !");
				System.out.println("Choose one of them");
				System.out.println("1." + " " + "Admin Login");
				System.out.println("2." + " " + "Public services");
				System.out.println("3." + " " + "Exit app");
				int n = sc.nextInt();
				switch (n) {
				case 1:
					adminLogin(sc);
					break;
				case 2:
					break;
				case 3:
					flag = false;
					break;
				default:
					throw new InvalidInputSelectionException("Invalid Input");
				}
			}
		} catch (InvalidInputSelectionException e) {
			System.out.println(e.getMessage());
		}

	}
}
