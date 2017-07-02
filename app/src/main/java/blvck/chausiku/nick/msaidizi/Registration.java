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
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String TAG="FireBase Errors";
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

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    createAccount(email, pass);
                    Intent next = new Intent(Registration.this, MainActivity.class);
                    startActivity(next);
                    finish();
            }
        });
    }

    public void createAccount(String email, String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete" + task.isSuccessful());

                        if(!task.isSuccessful())
                        {
                            Toast.makeText(Registration.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
