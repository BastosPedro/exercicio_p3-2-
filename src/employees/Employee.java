package employees;
import payment.Frequency;
import payment.GetsPaid;

public class Employee {
	private double basePayment, finalPayment, baseTax, debt, comission;
	private boolean isSyndicate;
	private int id, syndicateId;
	private String name, address;
	private Frequency frequency;
	private GetsPaid payType;
	private EmploymentType employeeType;
	
	public Employee(String inputName, String inputAddress, double basePay, boolean synd, double tax, int option, int option2, double inputCom){
		setName(inputName);
		setAddress(inputAddress);
		setBasePayment(basePay);
		setComission(inputCom);
		setSyndicate(synd);
		setTax(tax);
		setDebt(0);
		setFinalPayment(0);
		switch(option){
		case 1:
			setEmployeeType(EmploymentType.HOURLY);
			setFrequency(Frequency.WEEKLY);
			break;
		case 2:
			setEmployeeType(EmploymentType.SALARIED);
			setFrequency(Frequency.MONTHLY);
			break;
		case 3:
			setEmployeeType(EmploymentType.COMISSIONED);
			setFrequency(Frequency.TWICEAMONTH);
			break;
		}
		switch(option2){
		case 1:
			setPayType(GetsPaid.MAIL);
			break;
		case 2:
			setPayType(GetsPaid.CHECK);
			break;
		case 3:
			setPayType(GetsPaid.DEPOSIT);
			break;
		}
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
	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public int getSyndicateId() {
		return syndicateId;
	}

	public void setSyndicateId(int syndicateId) {
		this.syndicateId = syndicateId;
	}

	public GetsPaid getPayType() {
		return payType;
	}

	public void setPayType(GetsPaid payType) {
		this.payType = payType;
	}

	public EmploymentType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmploymentType employeeType) {
		this.employeeType = employeeType;
	}
	public double getComission(){
		return comission;
	}
	public void setComission(double comission){
		this.comission = comission;
	}

	public void calculate(double input){
		switch(this.getEmployeeType()){
		case HOURLY:
			double temp;
			if(input <= 8){
				temp = (this.getBasePayment())*input;
			}
			else{
				temp = (this.getBasePayment())*8;
				temp += 1.5*((this.getBasePayment())*(input - 8));
			}
			this.setFinalPayment(this.getFinalPayment() + temp);
			break;
		case COMISSIONED:
			this.setFinalPayment(getFinalPayment() + (input*this.getComission()));
			break;
		case SALARIED:
			this.setFinalPayment(this.getBasePayment());
			break;
		}
		System.out.println(this.getName() + " now has " + this.getFinalPayment() + " on his paycheck" );
	}
}
