package blvck.chausiku.nick.msaidizi.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import blvck.chausiku.nick.msaidizi.R;

/**
 * Created by brianphiri on 6/28/17.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder>{
    private static final int LENGTH = 18;

    Context context;
    public List<String> requestsDataTitle;
    public List<String> requestsDataMessage;

    public RequestAdapter(FragmentActivity activity, List<String> requestsDataTitle, List<String> requestsDataMessage) {
        this.context = activity;
        this.requestsDataTitle = requestsDataTitle;
        this.requestsDataMessage = requestsDataMessage;

    }



    @Override
    public RequestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RequestAdapter.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(requestsDataTitle.get(position));
        holder.message.setText(requestsDataMessage.get(position));
        holder.read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View inflater = LayoutInflater.from(context).inflate(R.layout.dialog_readmore, null);

                final TextView message = (TextView) inflater.findViewById(R.id.more_information_txt);
                message.setText(requestsDataMessage.get(position));

                Button button = (Button) inflater.findViewById(R.id.accept_request);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //
                    }
                });

                builder.setView(inflater);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });
    }

    @Override
    public int getItemCount() {
        return requestsDataTitle.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, message;
        Button accept, read;

        public ViewHolder(View itemView) {
            super(itemView);

        }
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            title = (TextView) itemView.findViewById(R.id.card_title);
            message = (TextView) itemView.findViewById(R.id.card_text);
            accept = (Button) itemView.findViewById(R.id.action_button);
            read = (Button) itemView.findViewById(R.id.read_btn);
        }
    }

}
