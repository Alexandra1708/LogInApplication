package com.example.alexandra.loginapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;



public class MainActivity extends AppCompatActivity {
        Button buttonLogIn;
        Button buttonCancel;
        Button buttonRegister;
        Database sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI(findViewById(R.id.view));
        buttonLogIn =  (Button) findViewById(R.id.buttonLogIn);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);

        buttonRegister = (Button) findViewById(R.id.button);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
        sqLiteDatabase=new Database(this);

    }

//    public static void hideSoftKeyboard(Activity activity) {
//        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
//    }


//    protected void hideKeyboard (View view)
//    {
//        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//    }


    public static void hideKeyboard (Activity activity) {
        Log.d("hideKeyboard","am intrat in functie");
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void setupUI(View view) {

        if (view instanceof EditText == false) { // metoda cel putin ciudata de-a verifica daca un view este EditText
            view.setOnTouchListener(new View.OnTouchListener() { // Daca este EditText atunci el va asculta atunci cand el este activ si se face touch
                public boolean onTouch(View v, MotionEvent event) {
                    hideKeyboard(MainActivity.this);
                    return false;
                }
            });
        }

    }

public void onClick(View view){
    {
        switch (view.getId()) {
            case R.id.buttonLogIn:
                EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
                EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
                View view2 = findViewById(R.id.view);
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                if (username.equals(sqLiteDatabase)&& password.equals(sqLiteDatabase))
                 view2.setBackgroundResource(R.color.green);
                else view2.setBackgroundResource(R.color.red);
                break;
            case R.id.buttonCancel:
                EditText editTextUsername2 = (EditText) findViewById(R.id.editTextUsername);
                EditText editTextPassword2 = (EditText) findViewById(R.id.editTextPassword);
                editTextUsername2.setText(null);
                editTextPassword2.setText(null);
                View view3= findViewById(R.id.view);
                view3.setBackgroundResource(R.color.white);
                break;


        }


            }

        }

    }







