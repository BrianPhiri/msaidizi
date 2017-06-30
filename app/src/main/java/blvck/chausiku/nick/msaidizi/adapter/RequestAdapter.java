package blvck.chausiku.nick.msaidizi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import blvck.chausiku.nick.msaidizi.R;

/**
 * Created by brianphiri on 6/28/17.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder>{
    private static final int LENGTH = 18;

    Context context;

    public RequestAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RequestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RequestAdapter.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return LENGTH;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
        }
    }

    public void showDialog(){
        Toast toast = Toast.makeText(context,"",Toast.LENGTH_LONG);
        toast.show();
    }
}
