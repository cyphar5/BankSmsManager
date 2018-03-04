package testme.java.com.ele_sms_ajay_chauhan;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;
import testme.java.com.ele_sms_ajay_chauhan.utility.Util;


/**
 * Created by achau on 04-03-2018.
 */

public class SmsListInteractorImpl implements SmsListInteractor {

    private Context context;

    public SmsListInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<SmsModel>> fetchMovies() {
        // return Observable.just(Util.movieFetcher(context));
        return Observable.just(Util.movieFetcher(context))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
