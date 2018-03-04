package testme.java.com.ele_sms_ajay_chauhan.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by achau on 02-03-2018.
 */

public class Util {

    public static String timeStampToDateTime(long l) {
        Timestamp timestamp = new Timestamp(l);
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy' ,'HH:mm:ss");

        return simpleDateFormat.format(date);
    }
}
