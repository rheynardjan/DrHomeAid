package com.example.nard.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView registerLink = (TextView) findViewById(R.id.tvRegister);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, Register.class);
                Login.this.startActivity(registerIntent);
            }
        });
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.bLogin){
            EditText a = (EditText) findViewById(R.id.Rusername);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.Rpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)){
                Intent i = new Intent(Login.this, MainActivity.class);
                i.putExtra("Username",str);
                startActivity(i);
                finish();
            }
            else {
                Toast msg = Toast.makeText(Login.this, "Username and Password don't match!", Toast.LENGTH_SHORT);
                msg.show();
            }
        }
    }
}
