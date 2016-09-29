package com.example.nard.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onSignUpClick(View v){
        if(v.getId() == R.id.bRegister){
            EditText fullname = (EditText) findViewById(R.id.Rfullname);
            EditText username = (EditText) findViewById(R.id.Rusername);
            EditText email = (EditText) findViewById(R.id.Remail);
            EditText password1 = (EditText) findViewById(R.id.Rpass1);
            EditText password2 = (EditText) findViewById(R.id.Rpass2);

            String fullnamestr = fullname.getText().toString();
            String usernamestr = username.getText().toString();
            String emailstr = email.getText().toString();
            String password1str = password1.getText().toString();
            String password2str = password2.getText().toString();

            String userex = helper.searchUser(usernamestr);

            if(!password1str.equals(password2str)){
                //Pop-up message
                Toast passmsg = Toast.makeText(Register.this, "Password don't match!", Toast.LENGTH_SHORT);
                passmsg.show();
            }
            else if(usernamestr.equals(userex)){
                Toast.makeText(getApplicationContext(), "The username is already taken", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                //Insert details in database
                Accounts a = new Accounts();
                a.setFullname(fullnamestr);
                a.setUsername(usernamestr);
                a.setEmail(emailstr);
                a.setPassword(password1str);

                helper.insertAccount(a);

                Toast passmsg = Toast.makeText(Register.this, "Successfully registered!", Toast.LENGTH_SHORT);
                passmsg.show();

                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
            }
        }
    }

}



