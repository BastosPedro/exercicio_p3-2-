package employees;

public class Salaried extends Employee{
	
	public Salaried(String inputN, String inputA, double pay, int size, boolean sind){
		super(inputN, inputA, pay, size, sind);
		setFinalPayment(this.getPayment());
	}
}
