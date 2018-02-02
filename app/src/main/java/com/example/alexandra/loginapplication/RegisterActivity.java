package com.example.alexandra.loginapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

//import static android.R.attr.contextUri;
//import static android.R.attr.dialogMessage;
//import static android.R.attr.onClick;
//import static com.example.alexandra.loginapplication.Database.DATABASE_NAME;
//import static com.example.alexandra.loginapplication.Database.DATABASE_VERSION;
//import static com.example.alexandra.loginapplication.R.id.button;
//import static com.example.alexandra.loginapplication.R.id.view;

public class RegisterActivity extends AppCompatActivity   {

    Database Database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        final EditText editTextUsername = (EditText) findViewById(R.id.editText_register_username);
        final EditText editTextPassword = (EditText) findViewById(R.id.editText_register_password);
        final EditText editTextPasswordConfirmation = (EditText) findViewById(R.id.editText_register_password_confirmation);
        final  Button buttonRegister = (Button) findViewById(R.id.button_register);


        buttonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Database openHelper =new Database(RegisterActivity.this);
                SQLiteDatabase database=openHelper.getWritableDatabase();

//                String usernameText= String.valueOf(editTextUsername);
//                String passwordText= String.valueOf(editTextPassword);
//                String passwordConfirmationText= String.valueOf(editTextPasswordConfirmation);
                String usernameText= editTextUsername.getText().toString();

                String passwordText= editTextPassword.getText().toString();

                String passwordConfirmationText= editTextPasswordConfirmation.getText().toString();


                Log.d("registrationStrings","username = " + usernameText+ " passwordText = "+passwordText + " passwordConfirmationText = " + passwordConfirmationText);
                if(usernameText.length()>=5 && passwordText.length()>=4 && passwordText.equals(passwordConfirmationText)) {
                    Database db = new Database(RegisterActivity.this);
                    User user = new User();
                    db.addUser(user);
                    AlertDialog.Builder alert= new AlertDialog.Builder(RegisterActivity.this);
                    alert.setMessage("The registration was successful!");
                    alert.setPositiveButton("OK", null);
                    alert.setCancelable(true);
                    alert.create().show();
                }
                if (passwordConfirmationText.contentEquals(passwordText) == false) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                        alert.setMessage("Your password confirmation is different!");
                        alert.setPositiveButton("OK", null);
                        alert.setCancelable(true);
                        alert.create().show();
                    }
                if (usernameText.length() < 5) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                        alert.setMessage("Your username must have at least 5 characters!");
                        alert.setPositiveButton("OK", null);
                        alert.setCancelable(true);
                        alert.create().show();
                    }
                if (passwordText.length() < 4 && passwordConfirmationText.length() < 4) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                        alert.setMessage("Your password must have at least 4 characters!");
                        alert.setPositiveButton("OK", null);
                        alert.setCancelable(true);
                        alert.create().show();
                    }




//                ContentValues values = new ContentValues();
//                values.put(Database.USERNAME, String.valueOf(editTextUsername));
//                values.put(Database.PASSWORD, String.valueOf(editTextPassword));
//                long id = database.insert(Database.TABLE_NAME, null, values);
//                AlertDialog.Builder alert= new AlertDialog.Builder(RegisterActivity.this);
//                alert.setMessage("The registration was successful!");
//                alert.setPositiveButton("OK", null);
//                alert.setCancelable(true);
//                alert.create().show();

            }

        });
    }



}
