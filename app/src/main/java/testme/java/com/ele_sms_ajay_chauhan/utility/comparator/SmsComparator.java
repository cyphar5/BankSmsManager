package testme.java.com.ele_sms_ajay_chauhan.utility.comparator;

import android.support.annotation.NonNull;

import java.util.Comparator;

import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 04-03-2018.
 */

public class SmsComparator implements Comparator<SmsModel> {
    @Override
    public int compare(SmsModel sms1, SmsModel sms2) {
        if (Long.parseLong(sms1.getReceivedTime()) > Long.parseLong(sms2.getReceivedTime())) {
            return 1;
        } else if (Long.parseLong(sms1.getReceivedTime()) < Long.parseLong(sms2.getReceivedTime())) {
            return -1;
        } else
            return 0;

    }
}
