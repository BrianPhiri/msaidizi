package blvck.chausiku.nick.msaidizi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileSetup extends AppCompatActivity {

    private final int SELECT_PHOTO = 1;
    private ImageView profilePicture;
    SharedPreferences myPrefrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);

        profilePicture = (ImageView) findViewById(R.id.profile_Picture);

        final Button registration = (Button) findViewById(R.id.btn_Register);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileSetup.this, MainActivity.class);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                startActivity(intent);
            }
        });

        Button chooseImage = (Button) findViewById(R.id.btn_pick);
        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration.setEnabled(true);
                Intent profilePicker = new Intent(Intent.ACTION_PICK);
                profilePicker.setType("image/*");
                startActivityForResult(profilePicker, SELECT_PHOTO);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent ImageReturnedIntent)
    {
        super.onActivityResult(requestCode, resultCode, ImageReturnedIntent);
        switch(requestCode)
        {
            case SELECT_PHOTO:
                if(resultCode==RESULT_OK)
                {
                    try
                    {


                        final Uri imageUri = ImageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        /*SharedPreferences.Editor editor = myPrefrence.edit();
                        editor.putString("imagePreference", encodeTobase64(selectedImage));
                        editor.commit();*/
                        profilePicture.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public static String encodeTobase64(Bitmap image)
    {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }
}
