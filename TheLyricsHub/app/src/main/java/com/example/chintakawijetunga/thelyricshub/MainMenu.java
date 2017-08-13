package com.example.chintakawijetunga.thelyricshub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.DatabaseHandler;
import com.example.chintakawijetunga.thelyricshub.DatabaseHandling.Tables.ContactTable;

import java.util.List;

public class MainMenu extends AppCompatActivity {
    DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        dbHandler = new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        dbHandler.addContact(new ContactTable("Ravi", "9100000000"));
        dbHandler.addContact(new ContactTable("Srinivas", "9199999999"));
        dbHandler.addContact(new ContactTable("Tommy", "9522222222"));
        dbHandler.addContact(new ContactTable("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<ContactTable> contacts = dbHandler.getAllContacts();

        for (ContactTable cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
