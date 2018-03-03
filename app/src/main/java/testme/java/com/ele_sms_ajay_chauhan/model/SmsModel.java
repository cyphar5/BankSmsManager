package testme.java.com.ele_sms_ajay_chauhan.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by achau on 01-03-2018.
 */

public class SmsModel implements Parcelable {
    private String id;
    private String amount;
    private String card_number;
    private String transactionTime;
    private String receivedTime;

    public SmsModel(){

    }

    protected SmsModel(Parcel in) {
        id = in.readString();
        amount = in.readString();
        card_number = in.readString();
        transactionTime = in.readString();
        receivedTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(amount);
        dest.writeString(card_number);
        dest.writeString(transactionTime);
        dest.writeString(receivedTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SmsModel> CREATOR = new Creator<SmsModel>() {
        @Override
        public SmsModel createFromParcel(Parcel in) {
            return new SmsModel(in);
        }

        @Override
        public SmsModel[] newArray(int size) {
            return new SmsModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(String receivedTime) {
        this.receivedTime = receivedTime;
    }

}
