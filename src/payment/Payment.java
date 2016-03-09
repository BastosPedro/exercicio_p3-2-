package payment;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import employees.*;

public class Payment {
	public String date(Employee anyEmployee){
		SimpleDateFormat auxFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar auxDate = Calendar.getInstance();
		switch(anyEmployee.getFrequency()){
		case WEEKLY:
			auxDate.set(Calendar.DAY_OF_WEEK, 6);
		case MONTHLY:
			auxDate.set(Calendar.DAY_OF_WEEK, 6);
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
}
