package testme.java.com.ele_sms_ajay_chauhan.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 03-03-2018.
 */

public class SmsBodyParser {

    public static boolean isMatchFind(String body) {
        Pattern pattern = Pattern.compile(Constants.transaction);
        Matcher matcher = pattern.matcher(body);
        return matcher.find();
    }

    public static String getAmount(String body) {
        Pattern pattern = Pattern.compile(Constants.regex_amount);
        Matcher matcher = pattern.matcher(body);
        String amount = "";
        if (matcher.find()) {
            int index = matcher.end();
            index++;
            while (body.charAt(index) != ' ') {
                amount = amount + body.charAt(index);
                index++;
            }
            return amount;
        } else {
            return amount;
        }
    }

    public static String getCard(String body) {
        Pattern pattern = Pattern.compile(Constants.card_num);
        Matcher matcher = pattern.matcher(body);
        String card = "";
        if (matcher.find()) {
            int index = matcher.start();
            while (body.charAt(index) != ' ') {
                card = card + body.charAt(index);
                index++;
            }
            return card;
        } else
            return card;
    }

//    public static SmsModel parseSmsBody(String body) {
//
//    }
}
