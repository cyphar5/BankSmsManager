package testme.java.com.ele_sms_ajay_chauhan.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import testme.java.com.ele_sms_ajay_chauhan.SmsActivity;
import testme.java.com.ele_sms_ajay_chauhan.module.SmsModule;

/**
 * Created by achau on 02-03-2018.
 */

@Singleton
@Component (modules = SmsModule.class)
public interface SmsComponent {
    void inject(SmsActivity smsActivity) ;
}
