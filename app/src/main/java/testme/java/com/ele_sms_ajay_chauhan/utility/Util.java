package testme.java.com.ele_sms_ajay_chauhan.utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 02-03-2018.
 */

public class Util {

    private static ProgressDialog progress = null;
    private static Cursor cursor = null;

    public static String timeStampToDateTime(long l) {
        Timestamp timestamp = new Timestamp(l);
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy' ,'HH:mm:ss");

        return simpleDateFormat.format(date);
    }

    public static List<SmsModel> movieFetcher(Context context) {

        List<SmsModel> smsList = new LinkedList<>();
        if (cursor == null)
            cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            cursor.getColumnCount();
            do {
                String body = "";
                body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                boolean isMatchFound = SmsBodyParser.isMatchFind(body);
                if (isMatchFound) {
                    SmsModel sms = new SmsModel();
                    sms.setId(cursor.getString(cursor.getColumnIndexOrThrow("address")));
                    sms.setReceivedTime(cursor.getString(cursor.getColumnIndexOrThrow("date")));
                    sms.setAmount(SmsBodyParser.getAmount(body));
                    sms.setCard_number(SmsBodyParser.getCard(body));
                    sms.setTransactionTime(SmsBodyParser.getTransactionTime(body));
                    smsList.add(sms);
                }
            } while (cursor.moveToNext());
        } else {
            Log.e(context.getClass().toString(), "Cursor Loading Failed");
        }
        return smsList;
    }

    public static void showLoadingProgress(boolean isShow, Context context) {
        // for showing progrees dialog
        if (isShow) {
            progress = new ProgressDialog(context);
            progress.setTitle("Loading");
            progress.setMessage("Fetching Transactions...");
            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
            progress.show();
        }
        // to dismiss the dialog
        else {
            if (progress != null) progress.dismiss();
        }

    }


}
