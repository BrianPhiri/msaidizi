package blvck.chausiku.nick.msaidizi;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Nick on 6/27/2017.
 */

public class PendingFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.pendingfragment, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_pending);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        //MyRequestAdapter adapter = new MyRequestAdapter(new String[]{"Example One", "Example Two", "Example Three", "Example Four", "Example Five" , "Example Six" , "Example Seven"});

        //rv.setAdapter(adapter);


        return rootView;
    }
}
