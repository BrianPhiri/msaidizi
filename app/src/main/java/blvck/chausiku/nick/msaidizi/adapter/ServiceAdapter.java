//package blvck.chausiku.nick.msaidizi.adapter;
//
//import android.content.Context;
//import android.support.v4.app.FragmentActivity;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.List;
//
//import blvck.chausiku.nick.msaidizi.MainActivity;
//import blvck.chausiku.nick.msaidizi.R;
//import blvck.chausiku.nick.msaidizi.models.Service;
//
///**
// * Created by brianphiri on 6/28/17.
// */
//
//public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{
//    public List<Service> dataService;
//
//    public String serviceString;
//    public String serverce;
//    Context context;
//
//    public ServiceAdapter(List<Service> dataService, FragmentActivity activity, String serverce) {
//        this.dataService = dataService;
//        this.context = activity;
//        this.serviceString = serverce;
//    }
//
//    @Override
//    public ServiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
//        return new ServiceAdapter.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ServiceAdapter.ViewHolder holder, int position) {
//        holder.mTextView.setText((CharSequence) dataService.get(position));
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return dataService.size();
//    }
//
//    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        public CardView mCardView;
//        public TextView mTextView;
//        public ViewHolder(View view) {
//            super(view);
//            mCardView = (CardView) view.findViewById(R.id.card_view);
//            mTextView = (TextView) view.findViewById(R.id.tv_text);
//
//        }
//
//        @Override
//        public void onClick(View view) {
//            Toast ts = Toast.makeText(context, "", Toast.LENGTH_LONG);
//            ts.show();
//        }
//    }
//}
