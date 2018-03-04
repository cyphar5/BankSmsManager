package testme.java.com.ele_sms_ajay_chauhan;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import testme.java.com.ele_sms_ajay_chauhan.adapter.SmsAdapter;
import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;
import testme.java.com.ele_sms_ajay_chauhan.utility.Util;

public class SmsActivity extends AppCompatActivity implements SmsMvpView {

    @BindView(R.id.sms_recycler)
    RecyclerView smsRecycler;
    @BindView(R.id.text_permission)
    TextView textPermission;

    //private Cursor cursor;
    private SmsPresenter smsPresenter;
    private SmsAdapter smsAdapter;

    public SmsActivity() {
        smsPresenter = new SmsPresenter(SmsActivity.this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Util.showLoadingProgress(true,this);

        ButterKnife.bind(this);


        smsAdapter = new SmsAdapter(this);
        smsRecycler.setLayoutManager(new LinearLayoutManager(this));

        if (checkReadSmsPermission())
            smsPresenter.setView(this);
        else
            requestPermissions();

        smsRecycler.setAdapter(smsAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    smsPresenter.setView(SmsActivity.this);

                } else {
                    Toast.makeText(this, getString(R.string.permission_denied), Toast.LENGTH_SHORT).show();
                    textPermission.setVisibility(View.VISIBLE);
                    textPermission.setText(getString(R.string.permission_denied));
                }
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add("Refresh Messages");
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Util.showLoadingProgress(true,SmsActivity.this);
                smsPresenter.setView(SmsActivity.this);
                return true;
            }
        });
        return true;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(SmsActivity.this,
                new String[]{Manifest.permission.READ_SMS},
                1);
    }


    @Override
    public void displayMessages(List<SmsModel> smsModelList) {
        textPermission.setVisibility(View.VISIBLE);
        smsAdapter.setItems(smsModelList);
        this.smsAdapter.notifyDataSetChanged();

    }

    @Override
    public void loadingMessages() {
      //  Util.showLoadingProgress(true, this);
    }

    @Override
    public void cancelLoading() {
        Util.showLoadingProgress(false, this);
    }

    private boolean checkReadSmsPermission() {
        String permission = Manifest.permission.READ_SMS;
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
}
