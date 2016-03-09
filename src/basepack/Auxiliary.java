package basepack;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Auxiliary {
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
}