package com.example.chintakawijetunga.thelyricshub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddInformation extends AppCompatActivity {
Button btnAddArtists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information);
        buttonClick();
    }

    private void buttonClick() {
        btnAddArtists = (Button) findViewById(R.id.btnAddArtists);

        btnAddArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddArtists.class));
            }
        });

    }
}
