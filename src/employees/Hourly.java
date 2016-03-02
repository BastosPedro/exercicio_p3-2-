package employees;

public class Hourly extends Employee{
	public Hourly(String inputN, String inputA, double pay, int size, boolean sind){
		super(inputN, inputA, pay, size, sind);
		setFinalPayment(0);
	}
}
