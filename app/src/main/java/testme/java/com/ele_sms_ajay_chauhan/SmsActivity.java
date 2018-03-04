package testme.java.com.ele_sms_ajay_chauhan;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import testme.java.com.ele_sms_ajay_chauhan.adapter.SmsAdapter;
import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;
import testme.java.com.ele_sms_ajay_chauhan.utility.SmsBodyParser;

public class SmsActivity extends AppCompatActivity implements SmsMvpView {

    @BindView(R.id.sms_recycler)
    RecyclerView smsRecycler;
    @BindView(R.id.text_permission)
    TextView textPermission;

    private Cursor cursor;
    private List<SmsModel> smsList = new LinkedList<>();
    private SmsPresenter smsPresenter = new SmsPresenter();
    private SmsAdapter smsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);


        smsAdapter = new SmsAdapter(this);
        smsRecycler.setLayoutManager(new LinearLayoutManager(this));


        smsPresenter.setView(this);
        if (checkReadSmsPermission())
            readMessage();
        else
            requestPermissions();
        smsAdapter.setItems(smsList);
        smsRecycler.setAdapter(smsAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (cursor != null)
            cursor.close();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //   readMessages();

                } else {
                    Toast.makeText(this, getString(R.string.permission_denied), Toast.LENGTH_SHORT).show();
                    textPermission.setVisibility(View.VISIBLE);
                    textPermission.setText(getString(R.string.permission_denied));
                }
            }

        }
    }

    public void readMessages(View v) {

        textPermission.setVisibility(View.GONE);
        cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

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
            Log.e(getClass().toString(), "Cursor Loading Failed");
        }
    }

    public void readMessage() {

        cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

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
            Log.e(getClass().toString(), "Cursor Loading Failed");
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(SmsActivity.this,
                new String[]{Manifest.permission.READ_SMS},
                1);
    }


    @Override
    public void displayMessages() {

    }

    private boolean checkReadSmsPermission() {
        String permission = Manifest.permission.READ_SMS;
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
}
