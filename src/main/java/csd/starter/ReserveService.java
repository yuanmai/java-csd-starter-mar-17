package csd.starter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/6.
 */
public class ReserveService {
    public static boolean reserve(String startTime, String endTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        if (startDate.after(endDate)) {
            return false;
        }
        return true;
    }
}
