package employees;

public class Salaried extends Employee{
	
	public Salaried(String inputN, String inputA, double pay, int size, boolean sind, double tax){
		super(inputN, inputA, pay, size, sind, tax);
		setFinalPayment(this.getBasePayment());
	}
}
