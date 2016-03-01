package employees;

public class Employee {
	private String name;
	private String address;
	private int id;
	private int payment;
	private int finalPayment;
	
	public Employee(String inputName, String inputAddress, int basePay, int hashSize){
		setName(inputName);
		setAddress(inputAddress);
		setPayment(basePay);
		setId(hashSize);
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
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getFinalPayment(){
		return finalPayment;
	}
	public void calculate(int variable){
		this.finalPayment = finalPayment + variable;
	}
}
