package employees;

public class Salaried extends Employee{
	
	public Salaried(String inputN, String inputA, double pay, int size){
		super(inputN, inputA, pay, size);
		setFinalPayment(this.getPayment());
	}
}
