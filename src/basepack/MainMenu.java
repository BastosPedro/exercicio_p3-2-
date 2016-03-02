package basepack;

import java.util.HashMap;
import java.util.Scanner;

import employees.Comissioned;
import employees.Employee;
import employees.Hourly;
import employees.Salaried;

public class MainMenu {
	public static void printOptions(){
		System.out.println("Welcome, please choose an option\n" +
						    "1) Add employee\n" + "2) Remove employee\n" +
							"3) Send payment card\n" + "4) Send sales result\n" + 
						    "5) Send tax\n" + "6) Change employee details\n" +
							"7) Send today's payment\n" + "8) Undo/Redo\n" +
						    "9) Payment schedule\n" + "10) Create schedule\n" +
							"11) Exit");
	}
	public static Employee employ(Scanner inter, Scanner stringer, Scanner doubler, int hashSize){
		System.out.println("Please enter the new employee's name");
		String auxName = stringer.nextLine();
		System.out.println("Okay, enter his/her adress");
		String auxAddress = stringer.nextLine();
		int auxChoose = 4;
		while(auxChoose >= 4 || auxChoose == 0){
			System.out.println("What kind of employee is him/her?\n 1)Hourly 2) Salaried 3)Commissioned");
			auxChoose = inter.nextInt();
		}
		System.out.println("Great, now please enter his or her base payment");
		double auxPayment = doubler.nextDouble();
		if(auxChoose == 1){
			System.out.println(auxName + "Employed! Huzzah!");
			return new Hourly(auxName, auxAddress, auxPayment, hashSize);
		}
		else if(auxChoose == 2){
			System.out.println(auxName + "got employed! Huzzah!");
			return new Salaried(auxName, auxAddress, auxPayment, hashSize);
		}
		else{
			System.out.println("Wait, there's more. Please enter the employee's comission\n"
								+ "(just write the percentage)");
			double auxPercentage = doubler.nextDouble();
			System.out.println(auxName + "Employed! Huzzah!");
			return new Comissioned(auxName, auxAddress, auxPayment, auxPercentage, hashSize);
		}
	}	
	public static void crise(Scanner writer, HashMap<String, Employee> hash){
		System.out.println("Oh, that's quite sad...please write the employee's name");
		String aux = writer.nextLine();
	    if(hash.containsKey(aux) == true){
	    	hash.remove(aux);
	    	System.out.println("The employee " + aux + " has been removed :(");
	    }
	    else{
	    	System.out.println("No one with this name works here.");
	    }
	}
	public static void sendCard(Scanner stringer, Scanner inter, HashMap<String, Employee> hash){
		System.out.println("Please insert the employee's name");
		String aux = stringer.nextLine();
		if(hash.containsKey(aux) == true){
			if(hash.get(aux) instanceof Hourly){
			System.out.print("Please insert how many hours" + hash.get(aux).getName() + "worked?");
			int hours = inter.nextInt();
			hash.get(aux).calculate(hours*(hash.get(aux).getPayment()));
				if(hours > 8){
					hash.get(aux).calculate((hours - 8)*(hash.get(aux).getPayment()*1.5));
					System.out.println("Employee" + hash.get(aux).getName() + "got" 
										+ hash.get(aux).getFinalPayment() + "reais on his paycheck");
				}
			}
			else{
				System.out.println("This employee is not an hourly one");
			}
		}
		else{
			System.out.println("No one called like that works here");
		}
			
	}
	public static void sendResults(Scanner stringer, Scanner doubler, HashMap<String, Employee> hash){
		System.out.println("Please insert the employee's name");
		String aux = stringer.nextLine();
		if(hash.containsKey(aux) == true){
			if(hash.get(aux) instanceof Comissioned){
				System.out.print("Please, what price did" + hash.get(aux).getName() + "get for the sale?");
				double sale = doubler.nextDouble();
				hash.get(aux).calculate(sale*(((Comissioned) hash.get(aux)).getPercentage()));
			}
		}
	}

}
