package com.example.chintakawijetunga.thelyricshub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.DatabaseHandler;

import java.util.List;

public class MainMenu extends AppCompatActivity {
    public static DatabaseHandler dbHandler;
    Button btnAddInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //dbHandler = new DatabaseHandler(this, DatabaseHandler.DATABASE_NAME, null, DatabaseHandler.DATABASE_VERSION);;
        buttonClick();



    }

    private void buttonClick() {
        btnAddInfo = (Button) findViewById(R.id.btnAddInformation);

        btnAddInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddInformation.class));
            }
        });

    }
}
