package blvck.chausiku.nick.msaidizi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import blvck.chausiku.nick.msaidizi.R;
import blvck.chausiku.nick.msaidizi.adapter.ServiceAdapter;
import blvck.chausiku.nick.msaidizi.models.Services;

import static android.content.ContentValues.TAG;

///**
// * Created by brianphiri on 6/28/17.
// */
//
public class ServiceListFragment extends Fragment{


    public List<String> serviceData = new ArrayList<>();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("services");


    ServiceAdapter serviceAdapter;

    public static ServiceListFragment newInstance(){
        ServiceListFragment fragment = new ServiceListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);


        ValueEventListener valueEventListener = myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                serviceData.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Services serv = snapshot.getValue(Services.class);
                    serviceData.add(serv.getTitle());
                }
                serviceAdapter = new ServiceAdapter(getActivity(),serviceData);
                recyclerView.setAdapter(serviceAdapter);
                recyclerView.setHasFixedSize(true);
                // Set padding for Tiles
                int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
                recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        return recyclerView;


    }

}
