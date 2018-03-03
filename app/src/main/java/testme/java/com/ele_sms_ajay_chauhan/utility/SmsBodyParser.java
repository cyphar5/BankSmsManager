package testme.java.com.ele_sms_ajay_chauhan.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 03-03-2018.
 */

public class SmsBodyParser {

    public static boolean isMatchFind(String body) {
        Pattern pattern = Pattern.compile(Constants.regex_merachant);
        Matcher matcher = pattern.matcher(body);
        return matcher.find();
    }

//    public static SmsModel parseSmsBody(String body) {
//
//    }
}
