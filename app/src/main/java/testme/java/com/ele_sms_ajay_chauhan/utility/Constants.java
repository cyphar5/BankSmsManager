package testme.java.com.ele_sms_ajay_chauhan.utility;

/**
 * Created by achau on 03-03-2018.
 */

public class Constants {

    public static String regex_amount = "(?i)(?:(?:RS|INR|MRP)\\.?\\s?)(\\d+(:?\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)" ;
    public static String regex_merachant = "(?i)(?:\\sat\\s|in\\*)([A-Za-z0-9]*\\s?-?\\s?[A-Za-z0-9]*\\s?-?\\.?)" ;
    public static String regex_card = "(?i)(?:\\smade on|ur|made a\\s|in\\*)([A-Za-z]*\\s?-?\\s[A-Za-z]*\\s?-?\\s[A-Za-z]*\\s?-?)" ;
}
