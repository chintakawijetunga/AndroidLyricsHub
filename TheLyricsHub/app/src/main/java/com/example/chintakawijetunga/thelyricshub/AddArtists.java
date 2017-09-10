package com.example.chintakawijetunga.thelyricshub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.DatabaseHandler;

import static com.example.chintakawijetunga.thelyricshub.MainMenu.dbHandler;

public class AddArtists extends AppCompatActivity {
    protected DatabaseHandler mDbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_artists);
        buttonClick();
    }

    private void AddArtist()
    {
        String sArtistName = ((TextView) findViewById(R.id.txtArtists)).getText().toString();
        String sAbout = ((TextView) findViewById(R.id.txtAbout)).getText().toString();
        mDbHandler = new DatabaseHandler(this, DatabaseHandler.DATABASE_NAME, null, DatabaseHandler.DATABASE_VERSION);

        if(!sArtistName.equals("")) {
            mDbHandler.addArtistsInfo(sArtistName, sAbout);
        }
        mDbHandler.readInfo();
    }

    private void buttonClick() {
        Button btnAddArtists = (Button) findViewById(R.id.btnAddArtists);

        btnAddArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddArtist();
            }
        });

    }
}
