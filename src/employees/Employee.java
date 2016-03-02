package employees;

public class Employee {
	private String name;
	private String address;
	private int id;
	private double payment;
	private double finalPayment;
	private boolean isSindicate;
	
	public Employee(String inputName, String inputAddress, double basePay, int hashSize, boolean sind){
		setName(inputName);
		setAddress(inputAddress);
		setPayment(basePay);
		setId(hashSize);
		setSindicate(sind);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getFinalPayment(){
		return finalPayment;
	}
	public void setFinalPayment(double payment){
		this.finalPayment = payment;
	}
	public void calculate(double input){
		this.finalPayment = finalPayment + input;
	}

	public boolean isSindicate() {
		return isSindicate;
	}

	public void setSindicate(boolean isSindicate) {
		this.isSindicate = isSindicate;
	}
}
