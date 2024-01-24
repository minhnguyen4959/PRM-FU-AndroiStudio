package com.example.fptu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fptu.database.DatabaseHandler;

public class RegisterUserActivity extends AppCompatActivity {
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHandler = new DatabaseHandler(this);
        Button registerButton = findViewById(R.id.register_btn);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("test@@99", String.valueOf(databaseHandler.insertUser("001", "123456", "admin", "Ha Noi")));
                if (databaseHandler.insertUser("001", "123456", "admin", "Ha Noi")) {
                    Toast.makeText(RegisterUserActivity.this, "Register success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
