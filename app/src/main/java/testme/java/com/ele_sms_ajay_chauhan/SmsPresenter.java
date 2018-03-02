package testme.java.com.ele_sms_ajay_chauhan;

import javax.inject.Inject;

/**
 * Created by achau on 01-03-2018.
 */

public class SmsPresenter implements SmsMvpPresenter {

    private SmsMvpView smsMvpView;

    @Inject
    public  SmsPresenter(){

    }

    @Override
    public void readingMessages() {

    }

    @Override
    public void setView(SmsMvpView smsMvpView) {

    }
}
