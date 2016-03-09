package employees;

public class Hourly extends Employee{
	public Hourly(String inputN, String inputA, double pay, int size, boolean synd, double tax){
		super(inputN, inputA, pay, size, synd, tax);
		setFinalPayment(0);
	}
	
	public void calculate(int hours){
		double temp;
		if(hours <= 8){
			temp = (this.getBasePayment())*hours;
		}
		else{
			temp = (this.getBasePayment())*8;
			temp = (this.getBasePayment())*(hours - 8);
		}
		this.setFinalPayment(this.getFinalPayment() + temp);
	}
}
