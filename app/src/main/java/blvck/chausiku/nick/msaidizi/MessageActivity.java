package blvck.chausiku.nick.msaidizi;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import blvck.chausiku.nick.msaidizi.adapter.MessageChatAdapter;
import blvck.chausiku.nick.msaidizi.models.Message;

public class MessageActivity extends AppCompatActivity{

    final List<Message> messages = new LinkedList<>();

    public MessageActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        final Button button = (Button) findViewById(R.id.send_message_btn);
        final TextView text = (TextView) findViewById(R.id.new_message);
        final ListView messageList = (ListView) findViewById(R.id.message_list);
        String[] ids = {"briannick", "test"};
        final String id = ids[0]+ids[1];

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("messages");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message(text.getText().toString(), "BrianNick", new Date());

//                System.out.print("Message" + message);
//                myRef.child(id).push().setValue(message);
                myRef.push().setValue(message);
                text.setText("");
            }
        });

        final ArrayAdapter<Message> adapter = new ArrayAdapter<Message>(this, R.layout.message_item, messages){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.message_item, parent, false);
                }
                Message message = messages.get(position);

                TextView nameView = (TextView) convertView.findViewById(R.id.message);
                nameView.setText(message.getText());

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)nameView.getLayoutParams();

                if (message.getSender().equals("Test")){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        nameView.setBackground(getDrawable(R.drawable.bubble_left_gray));
                    }
                    layoutParams.gravity = Gravity.LEFT;
                }else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        nameView.setBackground(getDrawable(R.drawable.bubble_right_green));
                    }
                    layoutParams.gravity = Gravity.RIGHT;
                }
                nameView.setLayoutParams(layoutParams);
                return convertView;
            }
        };
        messageList.setAdapter(adapter);


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Message message = dataSnapshot.getValue(Message.class);
                messages.add(message);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
