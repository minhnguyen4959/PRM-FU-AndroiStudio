package com.example.fptu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView phone;
    private TextView address;

    private ActivityResultLauncher activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 2){
                        Intent data = result.getData();
                        firstName.setText(data.getStringExtra("FIRST_NAME"));
                        lastName.setText(data.getStringExtra("LAST_NAME"));
                        phone.setText(data.getStringExtra("PHONE"));
                    }
                }
            }
    );
    private Button editButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firstName = findViewById(R.id.edit_first_name);
        lastName = findViewById(R.id.edit_last_name);
        phone = findViewById(R.id.edit_phone);
        address = findViewById(R.id.edit_address);

        editButton = findViewById(R.id.button_edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, EditProfileActivity.class);
                intent.putExtra("FIRST_NAME", firstName.getText().toString());
                intent.putExtra("LAST_NAME", lastName.getText().toString());
                intent.putExtra("PHONE", phone.getText().toString());

                activityResultLauncher.launch(intent);
            }
        });

    }




}
