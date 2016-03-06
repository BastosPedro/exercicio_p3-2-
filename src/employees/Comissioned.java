package employees;

public class Comissioned extends Salaried{
	
	private double percentage;
	
	public Comissioned(String inputN, String inputA, double pay, double comission, int size, boolean synd, double tax){
		super(inputN, inputA, pay, size, synd, tax);
		setPercentage(comission);
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage/100;
	}

}
