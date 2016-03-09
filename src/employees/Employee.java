package employees;

public class Employee {
	private String name, address;
	private double basePayment, finalPayment, baseTax, debt;
	private int id;
	private boolean isSyndicate;
	
	public Employee(String inputName, String inputAddress, double basePay, int inputId, boolean synd, double tax){
		setName(inputName);
		setAddress(inputAddress);
		setBasePayment(basePay);
		setId(inputId);
		setSyndicate(synd);
		setTax(tax);
		setDebt(0);
		setFinalPayment(0);
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
	public double getBasePayment() {
		return basePayment;
	}
	public void setBasePayment(double payment) {
		this.basePayment = payment;
	}
	public double getDebt(){
		return this.debt;
	}
	public void setDebt(double debt){
		this.debt = debt;
	}
	public double getFinalPayment(){
		return finalPayment;
	}
	public void setFinalPayment(double payment){
		this.finalPayment = payment;
	}
	public boolean isSyndicate() {
		return isSyndicate;
	}
	public void setSyndicate(boolean isSyndicate) {
		this.isSyndicate = isSyndicate;
	}
	public void setTax(double tax){
		this.baseTax = tax;
	}
	public double getTax(){
		return this.baseTax;
	}
	public void calculate(double input){
		this.finalPayment = finalPayment + input;
	}
}
