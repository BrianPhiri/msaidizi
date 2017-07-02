package blvck.chausiku.nick.msaidizi.adapter;

import android.app.Service;
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

import blvck.chausiku.nick.msaidizi.PostRequest;
import blvck.chausiku.nick.msaidizi.R;
import blvck.chausiku.nick.msaidizi.models.Services;

/**
 * Created by brianphiri on 6/28/17.
 */

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{
    private static final int LENGTH = 18;

    Context context;
//    private String title;
    public List<String> serivceData;

    public ServiceAdapter(FragmentActivity activity, List<String> data) {
//        this.title = title;
        this.context = activity;
        this.serivceData = data;
    }

    public ServiceAdapter(List<String> serviceData) {
        this.serivceData = serviceData;
    }


    @Override
    public ServiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ServiceAdapter.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        holder.btn.setText((CharSequence) serivceData.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View inflater = LayoutInflater.from(context).inflate(R.layout.dialog_request, null);
                final TextView title = (TextView) inflater.findViewById(R.id.request_txt);
                title.setText((CharSequence) serivceData.get(position));
                final EditText comment = (EditText) inflater.findViewById(R.id.description_txt);
                Button button = (Button) inflater.findViewById(R.id.submit_request);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(comment.getText().toString().isEmpty()){
                            Toast.makeText(context, "No comment", Toast.LENGTH_LONG).show();
                        }
                        else{
                            PostRequest pr = new PostRequest();
                            pr.requestService(title.getText().toString(),comment.getText().toString());
                        }
                    }
                });

                builder.setView(inflater);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return serivceData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        Button btn;

        public ViewHolder(View itemView) {
            super(itemView);

        }

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));
            btn = (Button) itemView.findViewById(R.id.tile_item_btn);
        }

    }
}
