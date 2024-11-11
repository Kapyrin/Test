package kapyrin.test.dateapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateApp {

    public String returnCurrentDayAndTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }



}
