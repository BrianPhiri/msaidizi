//package blvck.chausiku.nick.msaidizi.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
//import blvck.chausiku.nick.msaidizi.adapter.ServiceAdapter;
import blvck.chausiku.nick.msaidizi.models.Service;

import static android.R.attr.progress;
import static android.R.attr.value;
import static android.content.ContentValues.TAG;

///**
// * Created by brianphiri on 6/28/17.
// */
//
public class RequestFragment extends Fragment{
//
//    RecyclerView recyclerView;
//    View view;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    ProgressDialog progress;
//    List<Service> dataService = new ArrayList<>();
//    List<String> servicesString = new ArrayList<>();
//
//    ServiceAdapter serviceAdapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.cardlayout,container,false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        this.view = view;
//        init();
//        progress = new ProgressDialog(getActivity());
//        progress.setTitle("Loading...");
//        progress.setMessage("Syncing");
//        progress.setCancelable(false);
//        progress.show();
//        loadData();
//    }
//
//
//    private void loadData(){
//        DatabaseReference myRef = database.getReference("services");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                dataService.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    dataService.add(snapshot.getValue(Service.class));
//                    servicesString.add(snapshot.getKey().toString());
//                }
//                progress.dismiss();
////                String value = dataSnapshot.getValue(String.class);
////                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//    }
//
//    private void init(){
//        recyclerView = (RecyclerView) view.findViewById(R.id.rv_recycler_request);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        serviceAdapter = new ServiceAdapter(dataService,getActivity(),"serverce");
//        recyclerView.setAdapter(serviceAdapter);
//
//    }
//
}
