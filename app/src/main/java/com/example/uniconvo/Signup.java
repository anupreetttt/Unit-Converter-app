package com.example.uniconvo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button button;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        button = findViewById(R.id.signupbutton);

        auth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEmail = email.getText().toString();
                String textPassword = password.getText().toString();

                if (TextUtils.isEmpty(textEmail) || TextUtils.isEmpty(textPassword)){
                    Toast.makeText(Signup.this, "Empty credential", Toast.LENGTH_SHORT).show();
                } else if (textPassword.length() < 6 ){
                    Toast.makeText(Signup.this, "Password too short", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(textEmail, textPassword);
                }
            }
        });

    }

    private void registerUser(String email, String password) {

        auth.createUserWithEmailAndPassword(email,  password).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Signup.this, "Signed up", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Signup.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}