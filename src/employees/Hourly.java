package employees;

public class Hourly extends Employee{
	public Hourly(String inputN, String inputA, double pay, int size){
		super(inputN, inputA, pay, size);
		setFinalPayment(0);
	}
}
