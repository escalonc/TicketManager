package com.cejteam.ticketmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cejteam.data.entities.User;
import com.cejteam.data.repositories.BaseRepository;
import com.cejteam.data.repositories.UserRepository;

public class SignUpActivity extends AppCompatActivity {

    BaseRepository<User> userRepository = new UserRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText nameView, usernameView, passwordView, confirmPasswordView, ageView;

        nameView =(EditText) findViewById(R.id.input_name);
        usernameView =(EditText) findViewById(R.id.input_usernamee);
        ageView =(EditText) findViewById(R.id.input_age);
        passwordView =(EditText) findViewById(R.id.input_password);
        confirmPasswordView =(EditText) findViewById(R.id.input_reEnterPassword);

        Button buttonSignUp = (Button) findViewById(R.id.btn_signup);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();

                user.setName(nameView.getText().toString());
                user.setUsername(usernameView.getText().toString());
                user.setAge(Integer.parseInt(ageView.getText().toString()));
                user.setPassword(passwordView.getText().toString());

                userRepository.add(user);

                Toast.makeText(getApplicationContext(), "User has been created",
                        Toast.LENGTH_LONG).show();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
