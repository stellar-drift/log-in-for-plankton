package com.example.loginappplankton;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    // initialize input variables
    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set input variables
        usernameInput = findViewById(R.id.txtUsername);
        passwordInput = findViewById(R.id.txtPassword);

        // get button object
        Button btnLogin = findViewById(R.id.btnSubmit);

        // add event listener to button object
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // when event is triggered, call this function
                checkLogin();
            }
        });
    }


    // this method handles simple login logic
    private void checkLogin() {

        // get and store user input
        String user = usernameInput.getText().toString();
        String pass = passwordInput.getText().toString();

        // using simple if/else for brevity in app prototype
        if ((user.equals("Admin") && pass.equals("abc123")) ||
                (user.equals("Jared") && pass.equals("Password1")) ||
                (user.equals("ITP226") && pass.equals("678ABC"))) {

            // if un/pw combo matches one of the above, launch the gallery activity
            Intent intent = new Intent(MainActivity.this, ImageGallery.class);
            startActivity(intent);
        }
        else {
            // otherwise, launch the unsuccessful activity
            Intent intent = new Intent(MainActivity.this, Unsuccessful.class);
            startActivity(intent);

        }
    }

}
