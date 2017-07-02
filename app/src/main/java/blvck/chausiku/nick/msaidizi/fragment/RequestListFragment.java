package blvck.chausiku.nick.msaidizi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import blvck.chausiku.nick.msaidizi.R;
import blvck.chausiku.nick.msaidizi.adapter.RequestAdapter;
import blvck.chausiku.nick.msaidizi.models.Request;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by brianphiri on 6/28/17.
 */

public class RequestListFragment extends Fragment  {

    private List<String> requestsDataTitle = new ArrayList<>();
    private List<String> requestsDataMessage = new ArrayList<>();
    RequestAdapter requestAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("requests");

    Button button;

    public static RequestListFragment newInstance(){
        RequestListFragment fragment = new RequestListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        final RecyclerView recyclerView = (RecyclerView) inflater.inflate( R.layout.recycler_view, container, false);

        ValueEventListener valueEventListener = myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                requestsDataMessage.clear();
                requestsDataTitle.clear();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Request request = snapshot.getValue(Request.class);
                    requestsDataMessage.add(request.getDescription());
                    requestsDataTitle.add(request.getServiceType());
                }
                requestAdapter = new RequestAdapter(getActivity(),requestsDataTitle,requestsDataMessage);
                recyclerView.setAdapter(requestAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }

        });

        return recyclerView;
    }

}
