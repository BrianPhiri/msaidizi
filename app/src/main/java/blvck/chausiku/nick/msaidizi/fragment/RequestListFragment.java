package blvck.chausiku.nick.msaidizi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import blvck.chausiku.nick.msaidizi.R;
import blvck.chausiku.nick.msaidizi.adapter.RequestAdapter;

/**
 * Created by brianphiri on 6/28/17.
 */

public class RequestListFragment extends Fragment implements View.OnClickListener {

    Button button;

    public static RequestListFragment newInstance(){
        RequestListFragment fragment = new RequestListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        RequestAdapter adapter = new RequestAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        View ss = inflater.inflate(R.layout.item_tile,container,false);

        button = (Button) ss.findViewById(R.id.tile_item_btn);
        button.setOnClickListener(this);


        return recyclerView;
    }

    @Override
    public void onClick(View view) {
        System.out.print("Woriking");
    }
}
