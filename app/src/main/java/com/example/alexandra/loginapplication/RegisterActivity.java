package com.example.alexandra.loginapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.contextUri;
import static android.R.attr.dialogMessage;
import static android.R.attr.onClick;
import static com.example.alexandra.loginapplication.Database.DATABASE_NAME;
import static com.example.alexandra.loginapplication.Database.DATABASE_VERSION;
import static com.example.alexandra.loginapplication.R.id.button;
import static com.example.alexandra.loginapplication.R.id.view;

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

                ContentValues values = new ContentValues();
                values.put(Database.USERNAME, String.valueOf(editTextUsername));
                values.put(Database.PASSWORD, String.valueOf(editTextPassword));
                values.put(Database.CONFIRMPASSWORD, String.valueOf(editTextPasswordConfirmation));
                long id = database.insert(Database.TABLE_NAME, null, values);
                AlertDialog.Builder alert= new AlertDialog.Builder(RegisterActivity.this);
                alert.setMessage("The registration was successful!");
                alert.setPositiveButton("OK", null);
                alert.setCancelable(true);
                alert.create().show();

            }

        });
    }



}
