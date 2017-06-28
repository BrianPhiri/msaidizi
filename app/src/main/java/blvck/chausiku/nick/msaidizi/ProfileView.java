package blvck.chausiku.nick.msaidizi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Nick on 6/28/2017.
 */

class ProfileView extends AppCompatActivity {
    ImageView profPicture;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileview);

        profPicture = (ImageView) findViewById(R.id.imageView);
        //profPicture.setImageBitmap();
        profPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
