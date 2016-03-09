package basepack;

import java.util.HashMap;
import java.util.Scanner;

import basepack.Auxiliary;
import employees.Comissioned;
import employees.Employee;
import employees.Hourly;
import employees.Salaried;

public class MenuOptions {
	MenuOptions(){}
	public void printOptions(){
		System.out.println("Welcome, please choose an option\n" +
						    "1) Add employee\n" + "2) Remove employee\n" +
							"3) Send payment card\n" + "4) Send sales result\n" + 
						    "5) Send syndicate tax\n" + "6) Change employee details\n" +
							"7) Send today's payment\n" + "8) Undo/Redo\n" +
						    "9) Payment schedule\n" + "10) Create schedule\n" +
							"11) Exit");
	}
	public Employee employ(Scanner stringer, Scanner doubler, Scanner inter, int hashSize){
		boolean running = true, auxSyndicate = false;
		double auxPayment = 0, auxComission = 0, auxTax = 0;
		int auxChoose = 3;
		String auxName;
		String auxAddress;
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
				System.out.println("Last, but no least, please insert the syndicate's tax");
				while(auxTax == 0){
					auxTax = Auxiliary.writeDouble(doubler);
				}
			}
			System.out.println(auxName + " got employed! Huzzah!");
			if (auxChoose == 1){
				return new Hourly(auxName, auxAddress, auxPayment, hashSize, auxSyndicate, auxTax);
			}
			else if(auxChoose == 2){
				return new Salaried(auxName, auxAddress, auxPayment, hashSize, auxSyndicate, auxTax);
			}
			else{
				return new Comissioned(auxName, auxAddress, auxPayment, auxComission, hashSize, auxSyndicate, auxTax);
			}
		}
		return null;
	}
	public void crisis(Scanner stringer, HashMap<String, Employee> hash){
		boolean running = true;
		if(hash.isEmpty()==true){
			System.out.println("Empty employee list");
			running = false;
		}
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
	public void sendCard(Scanner stringer, Scanner inter,HashMap<String, Employee> hash){
		boolean running = true;
		if(hash.isEmpty() == true){
			System.out.println("Employee list is empty");
			running = false;
		}
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
			else if(hash.get(aux) instanceof Hourly){
				System.out.println("Please insert how many hours " + hash.get(aux).getName() + " worked");
				int hours = 0;
				while (hours == 0){
					hours = Auxiliary.writeInt(inter);
				}
				hash.get(aux).calculate(hours);
				System.out.println(hash.get(aux).getName() + " got " + hash.get(aux).getFinalPayment() +
									   " reais on his paycheck now");
				running = false;
			} else System.out.println("This employee is not an hourly one");
		}
	}
	public void sendResults(Scanner stringer, Scanner doubler, HashMap<String, Employee> hash){
		boolean running = true;
		double sale = 0;
		if(hash.isEmpty() == true){
			System.out.println("Employee list is empty");
			running = false;
		}
		while(running){
			System.out.println("Please insert the employee's name, or just write 'cancel' to abort");
			String aux = Auxiliary.writeString(stringer);
			if(aux.equals("cancel")){
				System.out.println("Aborting...");
				running = false;
			}
			else if(hash.containsKey(aux) == true){
				if(hash.get(aux) instanceof Comissioned){
					System.out.println("Please, what price did " + hash.get(aux).getName() + " get for the sale?");
					while(sale == 0){
						sale = Auxiliary.writeDouble(doubler);
					}
					hash.get(aux).calculate(sale);
					running = false;
				} else System.out.println("This is not a comissioned employee");
			} else System.out.println("No one called like that works here");
		}
	}
	public void applyTax(Scanner stringer, Scanner doubler, HashMap<String, Employee> hash){
		boolean running = true;
		double auxTax = 0;
		if(hash.isEmpty() == true){
			System.out.println("Empty employee list");
			running = false;
		}
		while(running){
			System.out.println("Please write the employee's name below, or just write 'cancel' to abort");
			String auxName = Auxiliary.writeString(stringer);
			if(auxName.equals("cancel")){
				System.out.println("Aborting...");
				running = false;
			}
			else if(hash.containsKey(auxName)){
				if(hash.get(auxName).isSyndicate() == true){					
					System.out.println("Please insert how much money he/she is going to lose.");
					while(auxTax == 0){
						auxTax = Auxiliary.writeDouble(doubler);
					}
					hash.get(auxName).setDebt(hash.get(auxName).getDebt() + auxTax);
					System.out.println("Now he/she owes " + hash.get(auxName).getDebt() + " %");
				}else System.out.println("This employee is not associated with the syndicate.");		
			}else System.out.println("No one called like that works here.");	
		}
	}
	public void changeEmployee(Scanner stringer, Scanner doubler, Scanner inter, HashMap<String, Employee> hash){
		boolean running = true;
		int auxChoose = 0;
		if(hash.isEmpty() == true){
			System.out.println("Employee list is empty");
			running = false;
		}
		while(running){
			System.out.println("Please enter the employee's name, or just type 'cancel' to abort");
			String auxName = Auxiliary.writeString(stringer);
			if(auxName.equals("cancel")){
				System.out.println("Aborting...");
				running = false;
			}
			else if(hash.containsKey(auxName) == false){
				System.out.println("No one called like that works here");
			}
			if(hash.containsKey(auxName)){
				switch(auxChoose){
					case 0:
						System.out.println("What do you want to change?\n" +
									   	   "1) Name 2) Address 3) Sallary type\n" +
									       "4) Payment type 5) Syndicate membership 6) Syndicate ID\n" +
									       "7) Syndicate tax 8) Return to main menu");
						while(auxChoose == 0 || auxChoose >= 12){
							auxChoose = Auxiliary.writeInt(inter);
						}
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
							if(hash.get(auxName) instanceof Hourly){
								System.out.println("Employee is already an hourly one");
								auxChoose = 0;
								break;
							}
							if(hash.get(auxName)instanceof Comissioned){
								Comissioned temp = (Comissioned)hash.get(auxName);
								temp.setPercentage(0);
								hash.replace(auxName, temp);
							}
							System.out.println("Please enter how much will she or he be getting per hour:");
							double newBasePay = 0;
							while(newBasePay == 0){
								newBasePay = Auxiliary.writeDouble(doubler);
							}
							hash.get(auxName).setBasePayment(newBasePay);
							hash.replace(auxName, (Hourly)hash.get(auxName));
							auxChoose = 0;
							break;
							
						}
						else if(newType.equals("comissioned")){
							if(hash.get(auxName) instanceof Comissioned){
								System.out.println("Employee is already a comissioned one");
								auxChoose = 0;
								break;
							}
							else{
								System.out.println("Please enter how much he or she will get Monttlhy");
								double newBasePay = Auxiliary.writeDouble(doubler);
								hash.get(auxName).setBasePayment(newBasePay);
								System.out.println("Now please enter his or her comission(just write the percentage");
								double newComission = Auxiliary.writeDouble(doubler);
								Comissioned temp = (Comissioned)hash.get(auxName);
								temp.setPercentage(newComission);
								hash.replace(auxName, temp);
								System.out.println("Conversion complete");
								auxChoose = 0;
								break;
							}
						}
						else if(newType.equals("salaried")){
							if(hash.get(auxName) instanceof Salaried){
								System.out.println("Employee is already a salaried one");
								auxChoose = 0;
								break;
							}
							if(hash.get(auxName) instanceof Comissioned){
								Comissioned temp = (Comissioned)hash.get(auxName);
								temp.setPercentage(0);
								hash.replace(auxName, temp);
							}
							hash.replace(auxName, (Salaried)hash.get(auxName));
							auxChoose = 0;
							break;
						}
						else{
							System.out.println("Wrong input, please try again");
							auxChoose = 0;
							break;
						}
					case 4:
						//not yet
						auxChoose = 0;
						break;
					case 5:
						if(hash.get(auxName).isSyndicate()){
							System.out.println("Is he or she still with the syndicate?");
						} else System.out.println("Will he or she join the syndicate?");
						
						while(auxChoose != 1 || auxChoose != 2){
							System.out.println("1)Yes 2)No");
							auxChoose = Auxiliary.writeInt(inter);
						}
						if(auxChoose == 1){
							hash.get(auxName).setSyndicate(true);
							auxChoose = 0;
							break;
						}
						else {
							hash.get(auxName).setSyndicate(false);
							auxChoose = 0;
							break;
						}
					case 6:
						//not yet
						auxChoose = 0;
						break;
					case 7:
						if(hash.get(auxName).isSyndicate()){
							System.out.println("Please enter the new base tax");
							double temp = Auxiliary.writeDouble(doubler);
							hash.get(auxName).setTax(temp);
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
		}
	}

