package blvck.chausiku.nick.msaidizi;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brianphiri on 6/27/17.
 */

class MyRequestAdapter extends RecyclerView.Adapter<MyRequestAdapter.MyRequestViewHolder>{
    private ArrayList<String> mDataset;

    public MyRequestAdapter(String values) {
        this.mDataset = mDataset;
    }


    @Override
    public MyRequestAdapter.MyRequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRequestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyRequestViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    class MyRequestViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView mTextView;

        public MyRequestViewHolder(View v){
            super(v);
            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.tv_text);
        }

    }
}
