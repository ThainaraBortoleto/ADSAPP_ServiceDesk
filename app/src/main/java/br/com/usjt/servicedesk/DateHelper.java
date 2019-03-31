package br.com.usjt.servicedesk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public static String format (Date date){
        return sdf.format(date);
    }
}
