package com.example.contactscreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class ContactsCreationActivity extends AppCompatActivity {

    TextInputLayout tilFirstName;
    TextInputLayout tilLastName;
    EditText etSocialMediaApp;
    EditText etSocialMediaURL;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_creation);
        tilFirstName = findViewById(R.id.til_first_name);
        tilLastName = findViewById(R.id.til_last_name);
        etSocialMediaApp = findViewById(R.id.et_social_media_app);
        etSocialMediaURL = findViewById(R.id.et_social_media_url);
        btnSave = findViewById(R.id.btn_social_media_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkEmptyInputs())
                    Toast.makeText(ContactsCreationActivity.this,
                            "No empty values",
                            Toast.LENGTH_SHORT)
                            .show();
                else {
                    Intent intent = new Intent();
                    PojoContacts contactInfo = new PojoContacts();
                    SocialMedia socialMediaInfo = new SocialMedia();

                    List<SocialMedia> socialMediaList = new ArrayList<>();

                    contactInfo.setFirstName(tilFirstName.getEditText().getText().toString());

                    contactInfo.setLastName(tilLastName.getEditText().getText().toString());

                    socialMediaInfo.setUserUrl(
                            etSocialMediaURL.getText()
                                    .toString().trim().isEmpty() ? "N/A" : etSocialMediaURL.getText().toString()
                    );

                    socialMediaInfo.setSocialMediaApp(
                            etSocialMediaApp.getText()
                                    .toString().trim().isEmpty() ? "N/A" : etSocialMediaApp.getText().toString()
                    );

                    socialMediaList.add(socialMediaInfo);
                    contactInfo.setSocialMediaList(socialMediaList);
                    intent.putExtra("data", contactInfo);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private Boolean checkEmptyInputs() {
        if (tilLastName.getEditText().getText().toString().isEmpty() ||
                tilFirstName.getEditText().getText().toString().isEmpty())
            return true;

        else return false;
    }

}
