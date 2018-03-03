package testme.java.com.ele_sms_ajay_chauhan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import testme.java.com.ele_sms_ajay_chauhan.R;

/**
 * Created by achau on 02-03-2018.
 */

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.SmsViewHolder> {

    public SmsAdapter() {

    }


    @Override
    public SmsAdapter.SmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SmsAdapter.SmsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
    }

}

