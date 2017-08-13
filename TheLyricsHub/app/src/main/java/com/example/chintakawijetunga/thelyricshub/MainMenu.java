package com.example.chintakawijetunga.thelyricshub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.DatabaseHandler;

import java.util.List;

public class MainMenu extends AppCompatActivity {
    DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
}
