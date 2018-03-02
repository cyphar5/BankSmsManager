package testme.java.com.ele_sms_ajay_chauhan.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import testme.java.com.ele_sms_ajay_chauhan.SmsActivity;

/**
 * Created by achau on 02-03-2018.
 */

@Module
public class SmsModule {
    public Context context;

    public SmsModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context getContext() {
        return context;
    }
}
