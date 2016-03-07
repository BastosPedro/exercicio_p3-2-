package basepack;
import java.util.InputMismatchException;
import java.util.Scanner;
import basepack.NameContainsNumException;

public class Auxiliary {
	public static String writeString(Scanner stringer){
		boolean running = true;
		while(running){
			try{
				stringer = new Scanner(System.in);
				String temp = stringer.nextLine();
				boolean containsNum = temp.chars().anyMatch(x-> Character.isDigit(x));
				if(containsNum){
					throw new NameContainsNumException();
				} else return temp;
			}catch(NameContainsNumException e){
				System.out.println("Wrong input, please try again");
			}
		}return null;
	}
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