package com.estsoft.ticketsystem;

import java.util.Scanner;

public class TicketingSystem {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		menu();
	}

	// main menu
	public static void menu() {
		while (true) {
			System.out.println("== Ticketing System ==");
			System.out.println("1. Reserve");
			System.out.println("2. Cancel");
			System.out.println("3. Count");
			System.out.println("4. Exit");

			//Scanner sc = new Scanner(System.in);
			System.out.print("> ");
			String num = sc.next();
			switch (num) {
			case "1":
				Reserve();
				break;
			case "2":
				Cancel();
				break;
			case "3":
				Count();
				break;
			case "4":
				sc.close();
				return ;
				
			default:
				System.out.println("ERROR. 1~4중에 고르시오");
			}
		}
	}

	public static void Reserve() {

		System.out.println("==Reservation==");
		System.out.println("1. The Lord of the Rings");
		System.out.println("2. The Matrix");
		System.out.println("3. Pride & Prejudice");
		//Scanner sc = new Scanner(System.in);
		System.out.print("> ");
		Long reservenum = sc.nextLong();
		System.out.println("Your name:");
		System.out.print("> ");
		String reservename = sc.next();
		
		
		CustomerDB cdb = new CustomerDB();
		Customer c = new Customer();
		c.setMovieno(reservenum);
		c.setCustomername(reservename);
		cdb.insert(c);
		
		
	}

	// 예약 취소
public static void Cancel(){
	
	System.out.println("Your name: ");
	//// Scanner sc = new Scanner(System.in);
	System.out.print("> ");
	String name = sc.next();
	
	CustomerDB cdb = new CustomerDB();
	Customer c = new Customer();
	c.setCustomername(name);
	
	//디비에있으면
	
	
	if(cdb.isAccount(c)?true:false)
	{
		cdb.delete(c);
		System.out.println("Cancelled");		
	}
	else{
		System.out.println("그런사람 없다!");
	}
	
}

	// 예약정보메뉴
	public static void Count() {
		System.out.println("== Count ==");
		System.out.println("1. The Lord of the Rings");
		System.out.println("2. The Matrix");
		System.out.println("3. Pride & Prejudice");
		// Scanner sc = new Scanner(System.in);
		System.out.print("> ");
		Long movienum = sc.nextLong();
		System.out.print("Reserved count: ");

		// db에서 count값을 받자아아아아!!!!!
		MovieDB mdb = new MovieDB();
		Movie m = new Movie();
		m.setNo(movienum);;
		
		System.out.println(mdb.Count(movienum));
		
	}

}
