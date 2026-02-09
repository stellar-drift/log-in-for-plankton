package com.example.loginappplankton;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageFull extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full);


        // get button object
        Button btnBack = findViewById(R.id.btnReturn);

        // add event listener to button object
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // end the current activity and remove it from the activity stack; return to previous activity if available
                finish();
            }
        });


        // store the image resource id (or -1O);
        //  (using -1 is safe as resource ids are always positive and 0, a non-negative number, could be interpreted as valid)
        // getIntent(): returns the intent that started the activity
        // getIntExtra(): get the other stuff that was sent with the intent, associated with the key that was set (otherwise use -1)
        int imageResId = getIntent().getIntExtra("imageResId", -1);
        String txtCaptions = getIntent().getStringExtra("captions");

        // get the ImageView
        ImageView imageView = findViewById(R.id.imgFull);
        TextView imgCaptions = findViewById(R.id.txtCaption);

        // if the stored value is not -1, then set the resource id passed from the previous activity to the image view in this activity
        if(imageResId != -1) {
            imageView.setImageResource(imageResId);
        }

        imgCaptions.setText(txtCaptions);
    }
}
