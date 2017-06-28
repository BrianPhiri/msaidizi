package blvck.chausiku.nick.msaidizi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private EditText email, fname, lname, pwd, confpwd, pnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = (EditText) findViewById(R.id.email_address);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        pwd = (EditText) findViewById(R.id.pword);
        confpwd = (EditText) findViewById(R.id.pword_confirm);
        pnumber = (EditText) findViewById(R.id.pNumber);

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database =  FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users");
                myRef.setValue(email.getText().toString(), fname.getText().toString());
                Intent profileSetup = new Intent(RegistrationActivity.this, ProfileSetup.class);
                startActivity(profileSetup);
            }
        });
    }
}
