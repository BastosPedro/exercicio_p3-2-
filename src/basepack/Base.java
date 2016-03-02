package basepack;
import employees.*;
import basepack.MainMenu;
import java.util.Scanner;
import java.util.HashMap;

public class Base {
	private static boolean isRunning = true;
	private static int cursor;
	
	public static void main(String[] args){
		HashMap<String, Employee> employeeHash = new HashMap<String, Employee>();
		Scanner sWriter = new Scanner(System.in);
		Scanner iWriter = new Scanner(System.in);
		Scanner dWriter = new Scanner(System.in);
		cursor = 0;
		while(isRunning == true){
			switch (cursor){
				case 0:
					MainMenu.printOptions();
					cursor = iWriter.nextInt();
					break;
				case 1:
					Employee aux = MainMenu.employ(iWriter, sWriter, dWriter, employeeHash.size());
					employeeHash.put(aux.getName(), aux);
					cursor = 0;
					break;
				case 2:
					MainMenu.crise(sWriter, employeeHash);
					cursor = 0;
					break;
				case 3:
					MainMenu.sendCard(sWriter, iWriter, employeeHash);
					cursor = 0;
					break;
				case 4:
					MainMenu.sendResults(sWriter, dWriter, employeeHash);
					cursor = 0;
					break;
				case 5:
					cursor = 0;
					break;
				case 6:
					cursor = 0;
					break;
				case 7:
					cursor = 0;
					break;
				case 8:
					cursor = 0;
					break;
				case 9:
					cursor = 0;
					break;
				case 10:
					cursor = 0;
					break;
				case 11:
					sWriter.close();
					iWriter.close();
					dWriter.close();
					System.out.println("Goodbye");
					isRunning = false;
			}
				
		}
	}
}
