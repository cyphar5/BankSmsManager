package testme.java.com.ele_sms_ajay_chauhan.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import testme.java.com.ele_sms_ajay_chauhan.R;
import testme.java.com.ele_sms_ajay_chauhan.model.SmsModel;

/**
 * Created by achau on 02-03-2018.
 */

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.SmsViewHolder> {

    private Activity activity;
    private int count = 0;
    private List<SmsModel> smsList = new LinkedList<>();

    public SmsAdapter(Activity activity) {
        this.activity = activity;
        this.notifyDataSetChanged();
    }


    @Override
    public SmsAdapter.SmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sms_adapter, parent, false);
        return new SmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SmsAdapter.SmsViewHolder holder, int position) {
        SmsModel sms = smsList.get(position);
        holder.setSmsData(sms);
    }

    @Override
    public int getItemCount() {
        return smsList.size();
    }

    public class SmsViewHolder extends RecyclerView.ViewHolder {

        private TextView sNo, id, cardNo, amount, transactionTime, receivedDateTime;


        public SmsViewHolder(View itemView) {
            super(itemView);

            sNo = itemView.findViewById(R.id.sa_serial);
            id = itemView.findViewById(R.id.sa_id);
            cardNo = itemView.findViewById(R.id.sa_card_number);
            amount = itemView.findViewById(R.id.sa_amount);
            transactionTime = itemView.findViewById(R.id.sa_transaction_time);
            receivedDateTime = itemView.findViewById(R.id.sa_received_time);
        }

        private void setSmsData(SmsModel smsModel) {
            sNo.setText(count++);
            id.setText(smsModel.getId());
            cardNo.setText(smsModel.getCard_number());
            amount.setText(smsModel.getAmount());
            transactionTime.setText(smsModel.getTransactionTime());
            receivedDateTime.setText(smsModel.getReceivedTime());
        }
    }

}

