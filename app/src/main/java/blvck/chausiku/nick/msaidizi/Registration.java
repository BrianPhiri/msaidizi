package blvck.chausiku.nick.msaidizi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String TAG="Firebase";

    EditText edtEmail, edtFname, edtLname, edtPhone, edtPassword, edtConfirm;
    String email, pass, conf, fname, lname, phone;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        email = edtEmail.getText().toString();
        edtFname = (EditText) findViewById(R.id.edtFName);
        fname = edtFname.getText().toString();
        edtLname = (EditText) findViewById(R.id.edtLName);
        lname = edtLname.getText().toString();
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        phone = edtPhone.getText().toString();
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        pass = edtPassword.getText().toString();
        edtConfirm = (EditText) findViewById(R.id.edtConfirmPass);
        conf = edtConfirm.getText().toString();
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(pass == conf){
                    createAccount(email, pass);
                    Intent next = new Intent(Registration.this, Details.class);
                    /*next.putExtra("First_name", fname);
                    next.putExtra("Last_name", lname);
                    next.putExtra("Phone", phone);*/
                    startActivity(next);
                    finish();
                //}
                //else{
                    //Toast.makeText(Registration.this, "Passwords do not match!"+"Please try again...", Toast.LENGTH_SHORT).show();
                //}//
            }//
        });
    }

    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Registration.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}
