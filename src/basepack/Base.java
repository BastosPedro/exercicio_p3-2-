package basepack;
import employees.*;
import basepack.MainMenu;
import basepack.Auxiliary;
import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;


public class Base {	
	public static void main(String[] args){
		boolean isRunning = true;
		int cursor = 0;
		int counter = 0;
		HashMap<String, Employee> employeeHash = new HashMap<String, Employee>();
		while(isRunning == true){
			try{
			Scanner dWriter = new Scanner(System.in);
			Scanner iWriter = new Scanner(System.in);
			Scanner sWriter = new Scanner(System.in);
			switch (cursor){
				case 0:
					MainMenu.printOptions();
					cursor = iWriter.nextInt();
					while(cursor == 0 || cursor >=12){
						cursor = Auxiliary.writeInt(iWriter);
					}
					break;
				case 1:
					Employee aux = MainMenu.employ(sWriter, dWriter, iWriter, counter);
					if(aux != null) {
						employeeHash.put(aux.getName(), aux);
						counter++;
					}
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
					MainMenu.applyTax(sWriter, dWriter, employeeHash);
					cursor = 0;
					break;
				case 6:
					MainMenu.changeEmployee(sWriter, dWriter, iWriter, employeeHash);
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
					dWriter.close();
					iWriter.close();
					sWriter.close();
					System.out.println("Goodbye");
					isRunning = false;
				}
			}finally{
				//whatever
			}
	}
}
}
