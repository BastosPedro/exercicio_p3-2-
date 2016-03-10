package basepack;

import employees.Employee;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Auxiliary {
	
	public static void printOptions(){
		System.out.println("Welcome, please choose an option\n" +
						    "1) Add employee\n" + "2) Remove employee\n" +
							"3) Send hours worked\n" + "4) Send sales result\n" + 
						    "5) Send syndicate tax\n" + "6) Change employee details\n" +
							"7) Send today's payment\n" + "8) Undo/Redo\n" +
						    "9) Change Payment schedule\n" + "10) Create schedule\n" +
							"11) Exit");
	}
	
	@SuppressWarnings("resource")
	public static String writeString(Scanner stringer){
		boolean running = true;
		while(running){
			try{
				stringer = new Scanner(System.in);
				String temp = stringer.nextLine();
				if(temp.chars().anyMatch(x-> Character.isDigit(x))){
					throw new Exception();
				} else return temp;
			}catch(Exception e){
				System.out.println("Wrong input, please try again");
			}
		}return null;
	}
	@SuppressWarnings("resource")
	public static int writeInt(Scanner inter){
		boolean running = true;
		while(running){
			try{
				inter = new Scanner(System.in);
				int temp = inter.nextInt();
				return temp;
			}catch(InputMismatchException e){
				System.out.println("Wrong input, please try again");
			}
		}return 0;
	}
	@SuppressWarnings("resource")
	public static double writeDouble(Scanner doubler){
		boolean running = true;
		while(running){
			try{
				doubler = new Scanner(System.in);
				double temp = doubler.nextDouble();
				return temp;
			}catch(InputMismatchException e){
				System.out.println("Wrong input, please try again");
			}
		}return 0;
	}
	
	public static boolean CheckHash(HashMap<String, Employee> hash){
		if(hash.isEmpty()){
			System.out.println("Employee hash is empty");
			return false;
		}else return true;
		
	}
}