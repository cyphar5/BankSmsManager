package testme.java.com.ele_sms_ajay_chauhan;

import android.app.Application;

import dagger.internal.DaggerCollections;
import testme.java.com.ele_sms_ajay_chauhan.component.DaggerSmsComponent;
import testme.java.com.ele_sms_ajay_chauhan.component.SmsComponent;
import testme.java.com.ele_sms_ajay_chauhan.module.SmsModule;

/**
 * Created by achau on 02-03-2018.
 */

public class BaseApplication extends Application {

    private SmsComponent smsComponent ;
    public static BaseApplication application ;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this ;

        smsComponent = DaggerSmsComponent.builder()
                .smsModule(new SmsModule(getApplicationContext())).build();


    }

    public SmsComponent getSmsComponent() {
        return smsComponent ;
    }
}
