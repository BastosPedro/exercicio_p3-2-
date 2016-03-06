package basepack;

import java.util.HashMap;
import java.util.InputMismatchException;
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
						    "5) Send syndicate tax\n" + "6) Change employee details\n" +
							"7) Send today's payment\n" + "8) Undo/Redo\n" +
						    "9) Payment schedule\n" + "10) Create schedule\n" +
							"11) Exit");
	}
	public static Employee employ(Scanner stringer, Scanner doubler, Scanner inter, int hashSize){
		boolean running = true;
		boolean auxSyndicate = false;
		double auxPayment;
		double auxComission = 0;
		double auxTax = 0;
		int auxChoose = 3;
		String auxName;
		String auxAddress;
		while(running == true){
			try{
				System.out.println("Please enter the employee's name, " + 
								   "\nor you can just type 'cancel' to abort:");
				auxName = stringer.nextLine();
				if(auxName.equals("cancel")){
					System.out.println("Aborting...");
					return null;
				}
				System.out.println("Okay, enter his/her address:");
				auxAddress = stringer.nextLine();
				System.out.println("Is he/her with the syndicate?\n1)Yes 2)No");
				while(auxChoose >= 3 || auxChoose == 0) auxChoose = inter.nextInt();
				if(auxChoose == 1) auxSyndicate = true;
				auxChoose = 4;
				System.out.println("What kind of employee is he/her?\n 1)Hourly 2)Salaried 3)Comissioned");
				while(auxChoose >= 4 || auxChoose == 0) auxChoose = inter.nextInt();
				System.out.println("Great, now please insert his or her base sallary:");
				auxPayment = doubler.nextDouble();
				//running = false;
				if(auxChoose == 3){
					System.out.println("Wait, there's more. Please enter the employee's comission\n"
							+ "(just write the percentage)");
					auxComission = doubler.nextDouble();
				}
				if(auxSyndicate){
					System.out.println("Last, but no least, please insert the syndicate's tax");
					auxTax = doubler.nextDouble();
				}
				if (auxChoose == 1){
					System.out.println(auxName + " got employed! Huzzah!");
					return new Hourly(auxName, auxAddress, auxPayment, hashSize, auxSyndicate, auxTax);
				}
				else if(auxChoose == 2){
					System.out.println(auxName + " got employed! Huzzah!");
					return new Salaried(auxName, auxAddress, auxPayment, hashSize, auxSyndicate, auxTax);
				}
				else{
					System.out.println(auxName + "got employed! Huzzah!");
					return new Comissioned(auxName, auxAddress, auxPayment, auxComission, hashSize, auxSyndicate, auxTax);
				}
			}catch(InputMismatchException e){
				System.out.println("Wrong input, resetting process...");
			}
		}
		return null;
	}
	public static void crise(Scanner stringer, HashMap<String, Employee> hash){
		boolean running = true;
		if(hash.isEmpty()==true){
			System.out.println("Empty employee list");
			running = false;
		}
		while(running){
			System.out.println("Please write the employee's name,"
								+ "or you can just type 'cancel' to abort");
			String aux = stringer.nextLine();
			if(aux.equals("cancel")){
				System.out.println("Aborting...");
				running = false;
			}
			if(hash.containsKey(aux)){
				hash.remove(aux);
				System.out.println(aux + " doesn't work with us anymore :(");
				running = false;
			} else System.out.println("No one called like that works here");
		}
	}
	public static void sendCard(Scanner stringer, Scanner inter,HashMap<String, Employee> hash){
		boolean running = true;
		if(hash.isEmpty() == true){
			System.out.println("Employee list is empty");
			running = false;
		}
		while(running){
			try{
				System.out.println("Please insert the employee's name, or you can just write 'cancel' to abort");
				String aux = stringer.nextLine();
				if(aux.equals("cancel")){
					System.out.println("Aborting...");
					running = false;
				}
				else if(hash.containsKey(aux) == false){
					System.out.print("No one called like that works here. ");
				}
				else if(hash.get(aux) instanceof Hourly){
					System.out.println("Please insert how many hours " + hash.get(aux).getName() + " worked");
					int hours = inter.nextInt();
					if (hours <=8){
						hash.get(aux).calculate(hours*(hash.get(aux).getBasePayment()));
					}
					else{
						hash.get(aux).calculate((hash.get(aux).getBasePayment()) * 8);
						hash.get(aux).calculate((hash.get(aux).getBasePayment()*1.5)*(hours - 8));
					}
					System.out.println(hash.get(aux).getName() + " got " + hash.get(aux).getFinalPayment() +
									   " reais on his paycheck now");
					running = false;
				} else System.out.println("This employee is not an hourly one");
			}catch(InputMismatchException e){
				System.out.println("Wrong input, resetting method...");
			}
		}
	}
	public static void sendResults(Scanner stringer, Scanner doubler, HashMap<String, Employee> hash){
		boolean running = true;
		if(hash.isEmpty() == true){
			System.out.println("Employee list is empty");
			running = false;
		}
		while(running){
			try{
				System.out.println("Please insert the employee's name, or just write 'cancel' to abort");
				String aux = stringer.nextLine();
				if(aux.equals("cancel")){
					System.out.println("Aborting...");
					running = false;
				}
				else if(hash.containsKey(aux) == true){
					if(hash.get(aux) instanceof Comissioned){
						System.out.println("Please, what price did " + hash.get(aux).getName() + " get for the sale?");
						double sale = doubler.nextDouble();
						hash.get(aux).calculate(sale*(((Comissioned) hash.get(aux)).getPercentage()));
						running = false;
					} else System.out.println("This is not a comissioned employee");
				} else System.out.println("No one called like that works here");
			}catch(InputMismatchException e){
				System.out.println("Wrong input, resetting process...");
			}
		}
	}
	public static void applyTax(Scanner stringer, Scanner doubler, HashMap<String, Employee> hash){
		boolean running = true;
		if(hash.isEmpty() == true){
			System.out.println("Empty employee list");
			running = false;
		}
		while(running){
			try{
				System.out.println("Please write the employee's name below, or just write 'cancel' to abort");
				String auxName = stringer.nextLine();
				if(auxName.equals("cancel")){
					System.out.println("Aborting...");
					running = false;
				}
				else if(hash.containsKey(auxName)){
					if(hash.get(auxName).isSyndicate() == true){
						System.out.println("Please insert how much money he/she is going to lose.");
						double auxTax = doubler.nextDouble();
						hash.get(auxName).setDebt(hash.get(auxName).getDebt() + auxTax);
						System.out.println("Now he/she owes " + hash.get(auxName).getDebt() + " %");
					}else System.out.println("This employee is not associated with the syndicate.");		
				}else System.out.println("No one called like that works here.");	
			}catch(InputMismatchException e){
				System.out.println("Wrong input, resetting process...");
			}
		}
	}
}
