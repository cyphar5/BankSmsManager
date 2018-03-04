package testme.java.com.ele_sms_ajay_chauhan;


import java.util.List;

import io.reactivex.Observable;
import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 04-03-2018.
 */

public interface SmsListInteractor {
    Observable<List<SmsModel>> fetchMovies();
}
