package payment;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import employees.*;

public class Payment {
	public String printMan(Employee anyEmployee){
		return anyEmployee.getName() + " | " + paycheck(anyEmployee) + " | " + date(anyEmployee) + " | " +
			   receivingMoney(anyEmployee.getPayType());
	}
	public String date(Employee anyEmployee){
		SimpleDateFormat auxFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar auxDate = Calendar.getInstance();
		switch(anyEmployee.getFrequency()){
		case WEEKLY:
			auxDate.set(Calendar.DAY_OF_WEEK, 6);
		case MONTHLY:
			auxDate.set(Calendar.DAY_OF_MONTH, 30);
		case TWICEAMONTH:
			if(auxDate.get(Calendar.DAY_OF_MONTH) > 15){
				auxDate.set(Calendar.DAY_OF_MONTH, 30);
			}else{
				auxDate.set(Calendar.DAY_OF_MONTH, 15);
			}
		case OTHER:
			//TODO
		}
		return auxFormat.format(auxDate.getTime());
	}
	public String receivingMoney(GetsPaid PayType){
		switch(PayType){
		case MAIL:
			return "sent to mail";
		case CHECK:
			return "received in hands";
		case DEPOSIT:
			return "received";
		}
		return "";
	}
	public double paycheck(Employee anyEmployee){
		if(anyEmployee.isDisconted()){
			return anyEmployee.getFinalPayment();
		}else{
			double taxes;
			anyEmployee.setDisconted(true);
			taxes = (anyEmployee.getTax() + anyEmployee.getDebt())/100;
			return anyEmployee.getFinalPayment() - taxes*anyEmployee.getFinalPayment();
		}
	}
	
}
