package blvck.chausiku.nick.msaidizi;

import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import blvck.chausiku.nick.msaidizi.models.Request;

/**
 * Created by brianphiri on 6/30/17.
 */

public class PostRequest {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("requests");

    public PostRequest() {
    }

    public void requestService(String type, String message){
        Request request = new Request(type,message);
        myRef.push().setValue(request);
    }
}
