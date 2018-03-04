package testme.java.com.ele_sms_ajay_chauhan;

import java.util.List;

import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 01-03-2018.
 */

public interface SmsMvpPresenter {
    void showMessages(List<SmsModel> smsList);

    void setView(SmsMvpView smsMvpView);

    void fetchTransactionMessage();
}
