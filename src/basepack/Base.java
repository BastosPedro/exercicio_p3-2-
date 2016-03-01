package basepack;
import employees.*;
import java.util.Scanner;
import java.util.HashMap;

public class Base {
	private static boolean isRunning = true;
	private static int cursor;
	
	public static void main(String[] args){
		HashMap<String, Employee> employeeHash = new HashMap<String, Employee>();
		Scanner sWriter = new Scanner(System.in);
		Scanner iWriter = new Scanner(System.in);
		cursor = 0;
		while(isRunning == true){
			switch (cursor){
				case 0:
					Base.printOptions();
					cursor = iWriter.nextInt();
				case 1:
					Employee aux = Base.employ(sWriter, iWriter, employeeHash.size());
					employeeHash.put(aux.getName(), aux);
					cursor = 0;
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					sWriter.close();
					iWriter.close();
					System.out.println("Goodbye");
					isRunning = false;
			}
				
		}
	}
	public static void printOptions(){
		System.out.println("Welcome, please choose an option\n" +
						    "1) Add employee\n" + "2) Remove employee\n" +
							"3) Send payment card\n" + "4) Send sales result\n" + 
						    "5) Send tax\n" + "6) Change employee details\n" +
							"7) Send today's payment\n" + "8) Undo/Redo\n" +
						    "9) Payment schedule\n" + "10) Create schedule\n" +
							"11) Exit");
	}

	public static Employee employ(Scanner stringer, Scanner inter, int hashSize){
		System.out.println("Please enter the employee's name");
		String auxName = stringer.nextLine();
		System.out.println("Okay, enter his/her adress");
		String auxAddress = stringer.nextLine();
		int auxChoose = 4;
		while(auxChoose >= 4 || auxChoose == 0){
			System.out.println("What kind of employee is him/her?\n 1)Hourly 2) Salaried 3)Commissioned");
			auxChoose = inter.nextInt();
		}
		System.out.println("Great, now please enter his or her base payment");
		int auxPayment = inter.nextInt();
		System.out.println("Employed! Huzzah!");
		if(auxChoose == 1){
			return new Hourly(auxName, auxAddress, auxPayment, hashSize);
		}
		else if(auxChoose == 2){
			return new Salaried(auxName, auxAddress, auxPayment, hashSize);
		}
		else{
			return new Comissioned(auxName, auxAddress, auxPayment, hashSize);
		}
	}
}
