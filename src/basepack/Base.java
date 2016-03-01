package basepack;
import java.util.Scanner;

public class Base {
	private static boolean isRunning = true;
	private static int cursor;
	
	public static void main(String[] args){
		Scanner sWriter = new Scanner(System.in);
		Scanner iWriter = new Scanner(System.in);
		while(isRunning == true){
			cursor = 0;
			switch (cursor){
				case 0:
					Base.printOptions();
					cursor = iWriter.nextInt();
				case 1:
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
					System.out.println("Goodbye"); 
					isRunning = false;
			}
				
		}
	}
	public static void printOptions(){
		System.out.println("Welcome, please choose an option\n" +
						    "1) Add employee\n" + "2) Remove Employee\n" +
							"3) Send payment card\n" + "4) Send sales result\n" + 
						    "5) Send tax\n" + "6)Change employee details\n" +
							"7) Send today's payment\n" + "8) Undo/Redo\n" +
						    "9) Payment schedule\n" + "10) Create schedule\n" +
							"11) Exit");
	}
}
