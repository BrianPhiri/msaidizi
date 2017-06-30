package blvck.chausiku.nick.msaidizi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import blvck.chausiku.nick.msaidizi.R;

/**
 * Created by brianphiri on 6/28/17.
 */

public class MessageListingAdapter extends RecyclerView.Adapter<MessageListingAdapter.ViewHolder>{
    private static final int LENGTH = 18;

    public MessageListingAdapter(Context context) {

    }

    @Override
    public MessageListingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageListingAdapter.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
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
            super(inflater.inflate(R.layout.item_list, parent, false));
        }
    }
}
