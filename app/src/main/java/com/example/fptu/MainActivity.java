package com.example.fptu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText editUsername;
    private EditText editPassword;
    private Spinner spinnerCampus;
    private CheckBox checkBoxRemember;
    private RadioButton radioStaff;
    private RadioButton radioManager;
    private Button btnLogin;

    private String role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editUsername = findViewById(R.id.edtUsername);
        editPassword = findViewById(R.id.edtPassword);
        spinnerCampus = findViewById(R.id.spinner_campus);
        checkBoxRemember = findViewById(R.id.cbremember);
        radioStaff = findViewById(R.id.staff);
        radioManager = findViewById(R.id.manager);
        btnLogin = findViewById(R.id.buttonLogin);

        //fill data
        ArrayAdapter<CharSequence> campusAdapter = ArrayAdapter.createFromResource(this, R.array.campus, android.R.layout.simple_spinner_item);
        campusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCampus.setAdapter(campusAdapter);


        //setOnItemSelectedListener của AdapterView.OnItemSelectedListener
        spinnerCampus.setOnItemSelectedListener(this);

        radioStaff.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                role = radioStaff.getText().toString();
            }
        });
        radioManager.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                role = radioManager.getText().toString();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                boolean remember = checkBoxRemember.isChecked();
                Toast.makeText(MainActivity.this, "Login button is clicked, role="+role+"username="+username, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
                startActivity(intent);
           
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
