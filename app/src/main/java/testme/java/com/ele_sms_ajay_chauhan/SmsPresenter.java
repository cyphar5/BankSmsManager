package testme.java.com.ele_sms_ajay_chauhan;


import android.content.Context;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 01-03-2018.
 */

public class SmsPresenter implements SmsMvpPresenter {

    private SmsMvpView smsMvpView;
    private SmsMvpView view;
    private Disposable fetchSmsData;
    private SmsListInteractor smsInteractor;
    private Context context;

    public SmsPresenter(Context context) {
        this.context = context;
        smsInteractor = new SmsListInteractorImpl(context);
    }

    @Override
    public void setView(SmsMvpView smsMvpView) {
        this.view = smsMvpView;
        fetchTransactionMessage();
    }

    @Override
    public void fetchTransactionMessage() {
        showLoading();
        fetchSmsData = smsInteractor.fetchMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showMessages);

    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void showMessages(List<SmsModel> smsList) {

        if (isViewAttached())
            view.cancelLoading();
            view.displayMessages(smsList);
    }

    private void showLoading() {
        if(isViewAttached())
            view.loadingMessages();
    }
}
