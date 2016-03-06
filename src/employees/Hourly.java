package employees;

public class Hourly extends Employee{
	public Hourly(String inputN, String inputA, double pay, int size, boolean synd, double tax){
		super(inputN, inputA, pay, size, synd, tax);
		setFinalPayment(0);
	}
}
