package com.example.fptu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class EditProfileActivity extends AppCompatActivity {
    private TextView firstName;
    private TextView lastName;
    private TextView phone;
    private TextView address;
     private EditText editFirstName;
     private EditText editLastName;
     private EditText editPhone;
     private EditText editAddress;

     private Button saveButton;
     private Button callButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

//        firstName = findViewById(R.id.first_name);
//        lastName = findViewById(R.id.last_name);
//        phone = findViewById(R.id.phone);
//        address = findViewById(R.id.address);

        editFirstName = findViewById(R.id.edit_first_name);
        editLastName = findViewById(R.id.edit_last_name);
        editPhone = findViewById(R.id.edit_phone);
        editAddress = findViewById(R.id.edit_address);


        saveButton = findViewById(R.id.button_save);
        callButton = findViewById(R.id.button_phone);
        Intent intent = getIntent();
        if (intent != null) {
            editFirstName.setText(intent.getStringExtra("FIRST_NAME"));
            editLastName.setText(intent.getStringExtra("LAST_NAME"));
            editPhone.setText(intent.getStringExtra("PHONE"));
        }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("FIRST_NAME", editFirstName.getText().toString());
                intent.putExtra("LAST_NAME", editLastName.getText().toString());
                intent.putExtra("PHONE", editPhone.getText().toString());
                setResult(2, intent);
                finish();

            }
        });


    }

    private boolean isValid(String key, String input){
        String regex = "";
        boolean result = false;
        switch (key) {
            case "EMAIL":
                regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
                break;
            case "PHONE":
                //+84 or 0, 9 or 10 digits
                regex = "^(\\+84|0)(\\d{9,10}|\\d{2}-\\d{4}-\\d{4})$";
                break;
            case "PASSWORD":
                //8 characters, 1Ucase, 1Lcase, 1digit, 1special character
                regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                break;
            default:
                return false;
        }
        return input.matches(regex);
    }

    private boolean isConfirm(String preValue, String currentValue){
        return currentValue.equals(preValue);
    }
}
