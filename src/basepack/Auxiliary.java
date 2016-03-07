package basepack;
import java.util.Scanner;
import basepack.NameContainsNumException;

public class Auxiliary {
	public static String getString(Scanner stringer){
		boolean running = true;
		while(running){
			try{
				stringer = new Scanner(System.in);
				String temp = stringer.nextLine();
				boolean allLetters = temp.chars().allMatch(x-> Character.isLetter(x));
				if(allLetters == false){
					throw new NameContainsNumException();
				}
				else{
					return temp;
				}
			}catch(NameContainsNumException e){
				System.out.println("Wrong input, please try again");
			}
		}return null;
	}
}