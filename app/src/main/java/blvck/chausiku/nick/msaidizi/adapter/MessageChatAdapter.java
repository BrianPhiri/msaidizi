package blvck.chausiku.nick.msaidizi.adapter;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import blvck.chausiku.nick.msaidizi.MessageActivity;
import blvck.chausiku.nick.msaidizi.models.Message;

import static android.content.ContentValues.TAG;

/**
 * Created by brianphiri on 7/2/17.
 */

public class MessageChatAdapter {
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference("messages");

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddmmss");
    final static  String COLUMN_TEXT = "text";
    final static String COLUMN_SENDER = "sender";


    public static void saveMessage(Message message, String convoId){

        Date date = message.getDate();
        String key = dateFormat.format(date);
        HashMap<String, String> msg = new HashMap<>();
        msg.put(COLUMN_TEXT, message.getText());
        msg.put(COLUMN_SENDER, "test");
        System.out.println("Message recived : " +convoId);
        myRef.child(convoId).child(key).push().setValue(msg);
//        myRef.child(key).push().setValue(msg);
    }


    public static void stop(MessageListener listener){
        myRef.removeEventListener(listener);
    }

    public static class MessageListener implements ChildEventListener{

        private MessageCallbacks callbacks;

        public MessageListener(MessageCallbacks callbacks) {
            this.callbacks = callbacks;
        }

        public MessageListener(String id, MessageActivity messageActivity) {
        }

        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            HashMap<String, String> msg = (HashMap<String, String>)dataSnapshot.getValue();
            Message message = new Message();
            message.setSender(msg.get(COLUMN_SENDER));
            message.setText(msg.get(COLUMN_TEXT));

            try {
                message.setDate(dateFormat.parse(dataSnapshot.getKey()));
            } catch (ParseException e) {
                Log.d(TAG, "Couldn't parse date"+e);
            }

            if(callbacks != null){
                callbacks.onMessageAdded(message);
            }
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
    }

    public  interface MessageCallbacks{
        public void onMessageAdded(Message message);
    }

}
