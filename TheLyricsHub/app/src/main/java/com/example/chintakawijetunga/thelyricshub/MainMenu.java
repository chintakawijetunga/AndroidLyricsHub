package com.example.chintakawijetunga.thelyricshub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainMenu extends AppCompatActivity {
    DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        dbHandler = new DatabaseHandler();
        dbHandler.CreateDB();
    }
}
