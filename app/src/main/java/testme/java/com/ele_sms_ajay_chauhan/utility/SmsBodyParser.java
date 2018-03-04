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
            int index;
            if (body.contains("INR") || body.contains("inr"))
                index = matcher.end() + 4;
            else
                index = matcher.end() + 3;
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
            if (body.contains("ending") || body.contains("Ending")) {
                int index = matcher.start() + 6;
                index++;
                card = "XX";
                while (body.charAt(index) != ' ') {
                    card = card + body.charAt(index);
                    index++;
                }
                return card;
            } else {
                int index = matcher.start();
                while (body.charAt(index) != ' ') {
                    card = card + body.charAt(index);
                    index++;
                }
                return card;
            }
        } else
            return card;
    }

    public static String getTransactionTime(String body) {
        Pattern pattern = Pattern.compile(Constants.transaction_date);
        Matcher matcher = pattern.matcher(body);
        String date = "";
        if (matcher.find()) {
            int index = matcher.end() + 3;
            if (body.contains("SBI") || body.contains("Sbi") || body.contains("sbi")) {
                boolean flag = true;

                int spaceCount = 0;
                while (flag) {
                    if (body.charAt(index) == ' ') {
                        spaceCount++;
                        if(spaceCount>2)
                            break;
                        date = date + "-";
                    } else {
                        date = date + body.charAt(index);
                    }
                    index++;

                    if (spaceCount > 2)
                        flag = false;

                }

                return date;
            } else {
                while (body.charAt(index) != ' ') {
                    date = date + body.charAt(index);
                    index++;
                }

                return date;

            }
        }

        return date;
    }

//    public static SmsModel parseSmsBody(String body) {
//
//    }
}
