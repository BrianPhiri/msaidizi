package blvck.chausiku.nick.msaidizi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import blvck.chausiku.nick.msaidizi.R;
import blvck.chausiku.nick.msaidizi.adapter.MessageListingAdapter;

/**
 * Created by brianphiri on 6/29/17.
 */

public class MessageListFragment extends Fragment{

    public static MessageListFragment newInstance(){
        MessageListFragment fragment = new MessageListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        MessageListingAdapter adapter = new MessageListingAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return recyclerView;
    }

}
