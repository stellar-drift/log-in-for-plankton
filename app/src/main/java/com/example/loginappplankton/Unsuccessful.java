package com.example.loginappplankton;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Unsuccessful extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unsuccessful);

        // get button object
        Button btnBack = findViewById(R.id.btnReturn);

        // add event listener to button object
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Unsuccessful.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
