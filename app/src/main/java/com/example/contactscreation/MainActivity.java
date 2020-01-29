package com.example.contactscreation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ShowAllDataInterface {
    private static final String TAG = "MainActivity";
    // Define a constant (final) for the starrActivityForResult()
    static final int MAIN_ACTIVITY_REQ_CONTACTS = 6969;

    FloatingActionButton btnNewContact;
    RecyclerView recyclerView;
    ContactsAdapter adapter = new ContactsAdapter();

    List<PojoContacts> dataSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNewContact = findViewById(R.id.floatingActionButton);
        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ContactsCreationActivity.class);
                startActivityForResult(intent, MAIN_ACTIVITY_REQ_CONTACTS);
            }
        });

        // RecyclerView set as a LinearLayout
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Adapter
        adapter = new ContactsAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setDataSet(dataSet);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MAIN_ACTIVITY_REQ_CONTACTS && resultCode == RESULT_OK && data != null) {
            // todo item layout, viewable adapter for the RecyclerView
            PojoContacts newEntry =
                    data.getParcelableExtra(ContactsCreationActivity.CONTACTS_CREATION_ACTIVITY_KEY);
            dataSet.add(newEntry);
            adapter.setDataSet(dataSet);
            adapter.setListener(this);

            Log.d(TAG, "onActivityResult: "
                    + newEntry.getSocialMediaList().get(0).getSocialMediaApp());
            Log.d(TAG, "onActivityResult: "
                    + newEntry.getSocialMediaList().get(0).getUserUrl());
        }
    }

    @Override
    public void openDetailedView(PojoContacts contact) {
        // todo intent to create the new activity.
        Toast.makeText(this, contact.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openFromLast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
