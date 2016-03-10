package basepack;
import employees.*;
import basepack.MenuOptions;
import basepack.Auxiliary;
import java.util.Scanner;
import java.util.HashMap;


public class Main {	
	public static void main(String[] args){
		boolean isRunning = true;
		int cursor = 0,  systemCounter = 0, syndicateCounter = 0;
		HashMap<String, Employee> employeeHash = new HashMap<String, Employee>();
		MenuOptions MainMenu = new MenuOptions();
		
		while(isRunning == true){
			try{
			Scanner dWriter = new Scanner(System.in);
			Scanner iWriter = new Scanner(System.in);
			Scanner sWriter = new Scanner(System.in);
			switch (cursor){
				case 0:
					Auxiliary.printOptions();
					cursor = iWriter.nextInt();
					while(cursor == 0 || cursor >=12){
						cursor = Auxiliary.writeInt(iWriter);
					}
					break;
				case 1:
					Employee aux = MainMenu.employ(sWriter, dWriter, iWriter, systemCounter);
					if(aux != null) {
						systemCounter++;
						aux.setId(systemCounter);
						if(aux.isSyndicate()){
							syndicateCounter++;
							aux.setSyndicateId(syndicateCounter);
						}
						employeeHash.put(aux.getName(), aux);
					}
					cursor = 0;
					break;
				case 2:
					MainMenu.crisis(sWriter, employeeHash);
					cursor = 0;
					break;
				case 3:
					MainMenu.sendHours(sWriter, iWriter, employeeHash);
					cursor = 0;
					break;
				case 4:
					MainMenu.sendSale(sWriter, dWriter, employeeHash);
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
					MainMenu.payRoll(employeeHash);
					cursor = 0;
					break;
				case 8:
					System.out.println("Under development");
					cursor = 0;
					break;
				case 9:
					MainMenu.changePayType(sWriter, employeeHash);
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
				//whatever it just asked me
			}
	}
}
}
