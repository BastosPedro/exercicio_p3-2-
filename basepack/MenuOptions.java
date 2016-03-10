package basepack;

import java.util.HashMap;
import java.util.Scanner;

import basepack.Auxiliary;
import payment.*;
import employees.Employee;
import employees.EmploymentType;

public class MenuOptions {
	MenuOptions(){}
	public Employee employ(Scanner stringer, Scanner doubler, Scanner inter, int hashSize){
		boolean running = true, auxSyndicate = false;
		double auxPayment = 0, auxComission = 0, auxTax = 0;
		int auxChoose = 3, auxChoose2 = 0;
		String auxName, auxAddress;
		while(running == true){
			System.out.println("Please enter our newest employee's name, " + 
							   "or you can just type 'cancel' to abort:");
			auxName = Auxiliary.writeString(stringer);
			if(auxName.equals("cancel")){
				System.out.println("Aborting...");
				return null;
			}
			System.out.println("Okay, enter his/her address:");
			auxAddress = Auxiliary.writeString(stringer);
			System.out.println("Is he/her with the syndicate?\n1)Yes 2)No");
			while(auxChoose >= 3 || auxChoose == 0) {
				auxChoose = Auxiliary.writeInt(inter);
			}
			if(auxChoose == 1) auxSyndicate = true;
			auxChoose = 4;
			System.out.println("What kind of employee is he/her?\n 1)Hourly 2)Salaried 3)Comissioned");
			while(auxChoose >= 4 || auxChoose == 0) {
				auxChoose = Auxiliary.writeInt(inter);
			}
			System.out.println("Great, now please insert his or her base sallary:");
			while(auxPayment == 0){
				auxPayment = Auxiliary.writeDouble(doubler);
			}
			if(auxChoose == 3){
				System.out.println("Wait, there's more. Please enter the employee's comission\n"
						+ "(just write the percentage)");
				while(auxComission == 0){
					auxComission = Auxiliary.writeDouble(doubler);
				}
			}
			if(auxSyndicate){
				System.out.println("Hold on, please insert the syndicate's tax (percentage)");
				while(auxTax == 0){
					auxTax = Auxiliary.writeDouble(doubler);
				}
			}
			while(auxChoose2 >=4 || auxChoose2 == 0){
				System.out.println("Last but not least, how is our new employee going to receive his money?\n" + 
								   "1)Mail 2) Check 3) Deposit");
				auxChoose2 = Auxiliary.writeInt(inter);
			}
			System.out.println(auxName + " got employed! Huzzah!");
			return new Employee(auxName, auxAddress, auxPayment, auxSyndicate, auxTax, auxChoose, auxChoose2, auxComission);
			}
		return null;
	}
	public void crisis(Scanner stringer, HashMap<String, Employee> hash){
		boolean running = Auxiliary.CheckHash(hash);
		while(running){
			System.out.println("Please write the employee's name,"
								+ "or you can just type 'cancel' to abort");
			String aux = Auxiliary.writeString(stringer);
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
	public void sendHours(Scanner stringer, Scanner doubler,HashMap<String, Employee> hash){
		boolean running = Auxiliary.CheckHash(hash);
		while(running){
			System.out.println("Please insert the employee's name, or you can just write 'cancel' to abort");
			String aux = Auxiliary.writeString(stringer);
			if(aux.equals("cancel")){
				System.out.println("Aborting...");
				running = false;
			}
			else if(hash.containsKey(aux) == false){
				System.out.print("No one called like that works here. ");
			}
			else{
				switch(hash.get(aux).getEmployeeType()){
					case HOURLY:
						System.out.println("Please insert how many hours " + hash.get(aux).getName() + " worked");
						hash.get(aux).calculate(Auxiliary.writeDouble(doubler));
						running = false;
						break;
					default:
						System.out.println("This employee is not an hourly one");
						break;				
				}
			}
		}
	}
	public void sendSale(Scanner stringer, Scanner doubler, HashMap<String, Employee> hash){
		boolean running = Auxiliary.CheckHash(hash);
		while(running){
			System.out.println("Please insert the employee's name, or just write 'cancel' to abort");
			String aux = Auxiliary.writeString(stringer);
			if(aux.equals("cancel")){
				System.out.println("Aborting...");
				running = false;
			}
			else if(hash.containsKey(aux) == false){
				System.out.println("No one called like that works here");
			}
			else{
				switch(hash.get(aux).getEmployeeType()){
					case COMISSIONED:
						System.out.println("What price did " + hash.get(aux).getName() + " get for the sale?");
						hash.get(aux).calculate(Auxiliary.writeDouble(doubler));
						running = false;
						break;
					default:
						System.out.println("This employee is not a comissioned one");
						break;
				}
			}
		}
	}
	public void applyTax(Scanner stringer, Scanner doubler, HashMap<String, Employee> hash){
		boolean running = Auxiliary.CheckHash(hash);
		while(running){
			System.out.println("Please write the employee's name below, or just write 'cancel' to abort");
			String auxName = Auxiliary.writeString(stringer);
			if(auxName.equals("cancel")){
				System.out.println("Aborting...");
				running = false;
			}
			else if(hash.containsKey(auxName) == false){
				System.out.println("No one called like that works here");
			}
			else if(hash.get(auxName).isSyndicate() == false){
				System.out.println("This employee is not a member of the syndicate");
			}
			else{
				System.out.println("Please insert the additional tax (percentile, just write the number)");
				hash.get(auxName).setDebt(hash.get(auxName).getDebt() + Auxiliary.writeDouble(doubler));
				System.out.println("Total additional taxes for " + hash.get(auxName).getName() + ": " + hash.get(auxName).getDebt() + "%");
			}
		}
	}
	public void changeEmployee(Scanner stringer, Scanner doubler, Scanner inter, HashMap<String, Employee> hash){
		boolean running = Auxiliary.CheckHash(hash);
		String auxName = null;
		int auxChoose = 0;
		while(running){
			System.out.println("Please enter the employee's name, or just type 'cancel' to abort");
			auxName = Auxiliary.writeString(stringer);
			if(auxName.equals("cancel")){
				System.out.println("Aborting...");
				running = false;
			}
			else if(hash.containsKey(auxName) == false){
				System.out.println("No one called like that works here");
			}else break;
		}
		while(running){
				switch(auxChoose){
					case 0:
						System.out.println("What do you want to change?\n" +
									   	   "1) Name\n2) Address\n3) Sallary type\n" +
									       "4) Payment type\n5) Syndicate membership\n6) Syndicate ID\n" +
									       "7) Syndicate tax\n8) Return to main menu\n");
						while(auxChoose == 0 || auxChoose >= 9){
							auxChoose = Auxiliary.writeInt(inter);
						}
						break;
					case 1:
						System.out.println("Please choose a new name");
						String newName = Auxiliary.writeString(stringer);
						hash.get(auxName).setName(newName);
						hash.put(newName, hash.get(auxName));
						hash.remove(auxName);
						auxName = newName;
						auxChoose = 0;
						System.out.println("Name changed");
						auxChoose = 0;
						break;
					case 2:
						System.out.println("Please choose a new address");
						String newAddress = Auxiliary.writeString(stringer);
						hash.get(auxName).setAddress(newAddress);
						System.out.println("Address changed");
						auxChoose = 0;
						break;
					case 3:
						System.out.println("Please type the new type as 'hourly', 'salaried' or 'comissioned'");
						String newType = Auxiliary.writeString(stringer);
						if(newType.equals("hourly")){
							switch(hash.get(auxName).getEmployeeType()){
							case HOURLY:
								System.out.println("Employee is an hourly one already");
								break;
							default:
								System.out.println("Please enter his/her new base sallary");
								hash.get(auxName).setBasePayment(Auxiliary.writeDouble(doubler));
								hash.get(auxName).setEmployeeType(EmploymentType.HOURLY);
								hash.get(auxName).setFrequency(Frequency.WEEKLY);
								System.out.println("Updated, changed payment frequency to default(weekly)");
								break;
							}
							auxChoose = 0;
							break;
						}
						else if(newType.equals("salaried")){
							switch(hash.get(auxName).getEmployeeType()){
							case SALARIED:
								System.out.println("This employee is a salaried one already");
								break;
							case HOURLY:
								System.out.println("Please write his/her new base sallary");
								hash.get(auxName).setBasePayment(Auxiliary.writeDouble(doubler));
							default:
								hash.get(auxName).setEmployeeType(EmploymentType.SALARIED);
								hash.get(auxName).setFrequency(Frequency.MONTHLY);
								System.out.println("Updated, changed payment frequency to default(monthly)");
								break;
							}
							auxChoose = 0;
							break;
						}
						else if(newType.equals("Comissioned")){
							switch(hash.get(auxName).getEmployeeType()){
							case COMISSIONED:
								System.out.println("This employee is a comissioned one already");
								break;
							case HOURLY:
								System.out.println("Please write his/her new base sallary");
								hash.get(auxName).setBasePayment(Auxiliary.writeDouble(doubler));
							default:
								System.out.println("Please write his/her comission");
								hash.get(auxName).setComission(Auxiliary.writeDouble(doubler));
								hash.get(auxName).setEmployeeType(EmploymentType.SALARIED);
								hash.get(auxName).setFrequency(Frequency.MONTHLY);
								System.out.println("Updated, changed payment frequency to default(twice a month)");
								break;
							}
							auxChoose = 0;
							break;
						}
						else{
							System.out.println("Wrong input");
							auxChoose = 0;
							break;					
						}
					
					case 4:
						System.out.println("Please write a new payment type:"
											+ " 'mail', 'check', 'deposit");
						String temp = Auxiliary.writeString(stringer);
						switch(temp){
							case "mail":
								hash.get(auxName).setPayType(GetsPaid.MAIL);
								break;
							case "check":
								hash.get(auxName).setPayType(GetsPaid.CHECK);
								break;
							case "deposit":
								hash.get(auxName).setPayType(GetsPaid.DEPOSIT);
								break;
						}
						System.out.println("Updated");
						auxChoose = 0;
						break;
					case 5:
						if(hash.get(auxName).isSyndicate()){
							System.out.println("Is he or she still with the syndicate?");
						} else System.out.println("Will he or she join the syndicate?");
						
						while(auxChoose >= 3 || auxChoose == 0){
							System.out.println("1)Yes 2)No");
							auxChoose = Auxiliary.writeInt(inter);
						}
						if(auxChoose == 1){
							if(hash.get(auxName).isSyndicate() == false){
								System.out.println("Please insert the base syndical tax"
												 + "(percentage, just write the number)");
								hash.get(auxName).setTax(Auxiliary.writeDouble(doubler));
							}
							hash.get(auxName).setSyndicate(true);
							System.out.println("Updated");
							auxChoose = 0;
							break;
						}
						else {
							hash.get(auxName).setSyndicate(false);
							auxChoose = 0;
							break;
						}
					case 6:
						if(hash.get(auxName).isSyndicate() == false){
							System.out.println("This employee is not a member of the syndicate");
						}else{
							boolean repeatedNum = true;
							while(repeatedNum){
								System.out.println("Please write his/her new syndicate id(just an integer)");
								int aux = Auxiliary.writeInt(inter);
								if(hash.containsValue(hash.get(auxName).getSyndicateId())){
									System.out.println("There's someone with that id already");
								}else{
									System.out.println("Updated");
									hash.get(auxName).setSyndicateId(aux);
									repeatedNum = false;
								}
							}
						}
						auxChoose = 0;
						break;
					case 7:
						if(hash.get(auxName).isSyndicate()){
							System.out.println("Please enter the new base tax");
							hash.get(auxName).setTax(Auxiliary.writeDouble(doubler));
							System.out.println("Updated");
							auxChoose = 0;
							break;
						}else{
							System.out.println("The employee is not in the syndicate");
							auxChoose = 0;
							break;
						}
					case 8:
						System.out.println("Returning to main menu");
						running = false;
						break;
					}
				}
				
			}
	public void payRoll(HashMap<String, Employee> hash){
		if(Auxiliary.CheckHash(hash)){
			Payment today = new Payment();
			System.out.println("Name | Value to get paid | Payday | How to pay\n");
			for(HashMap.Entry<String, Employee> entry : hash.entrySet()){
				System.out.println(today.printMan(entry.getValue()));
			}
		}
	}
	public void changePayType(Scanner stringer,HashMap<String, Employee> hash){
		boolean running = Auxiliary.CheckHash(hash);
		while(running){
			System.out.println("Please the employee's name");
			String auxName = Auxiliary.writeString(stringer);
			if(hash.containsKey(auxName) == false){
				System.out.println("No one called like that works here");
			}
			else{
				System.out.println("Please write what kind of schedule you want to change to: \n"
									+ "'weekly', 'monthly', 'twice a month'");
				switch(Auxiliary.writeString(stringer)){
					case "weekly":
						System.out.println("Updated");
						hash.get(auxName).setFrequency(Frequency.WEEKLY);
						running = false;
						break;
					case "monthly":
						System.out.println("Updated");
						hash.get(auxName).setFrequency(Frequency.MONTHLY);
						running = false;
						break;
					case "twice a month":
						System.out.println("Updated");
						hash.get(auxName).setFrequency(Frequency.TWICEAMONTH);
						running = false;
						break;
					default:
						System.out.println("Wrong awnser, bro");
						break;
				}
			}
		}
	}
	
}
	

