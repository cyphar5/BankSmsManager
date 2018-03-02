package testme.java.com.ele_sms_ajay_chauhan;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import testme.java.com.ele_sms_ajay_chauhan.component.SmsComponent;

public class SmsActivity extends AppCompatActivity implements SmsMvpView {

    @BindView(R.id.text)
    TextView textView;

    private Cursor cursor;
    private SmsComponent smsComponent;

    @Inject
    SmsPresenter smsPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);

        BaseApplication.application.getSmsComponent().inject(SmsActivity.this);

        smsPresenter.setView(this);
        requestPermissions();

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
                    readMessages();

                } else {
                    textView.setText(getString(R.string.permission_denied));
                    Toast.makeText(this, getString(R.string.permission_denied), Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    private void readMessages() {

        cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            cursor.getColumnCount();
            do {
                String msgData = "";
                for (int id = 0; id < cursor.getColumnCount(); id++) {
                    msgData += " " + cursor.getColumnName(id) + ":" + cursor.getString(id);
                    textView.append(msgData);
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
}
