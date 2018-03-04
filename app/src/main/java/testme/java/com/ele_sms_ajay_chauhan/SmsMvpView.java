package testme.java.com.ele_sms_ajay_chauhan;

import java.util.List;

import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 01-03-2018.
 */

public interface SmsMvpView {
    void displayMessages(List<SmsModel> smsList);

    void loadingMessages();

    void cancelLoading();
}
