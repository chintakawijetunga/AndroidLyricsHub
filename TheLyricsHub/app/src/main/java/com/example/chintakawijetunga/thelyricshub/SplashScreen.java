package com.example.chintakawijetunga.thelyricshub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread splash_Screen = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                }
                catch (Exception e) {
                    e.printStackTrace();

                }
                finally {
                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    finish();
                }
            }
        };

        splash_Screen.start();

    }
}
