package com.example.android.areyoukittyme;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.areyoukittyme.User.User;
import com.example.android.areyoukittyme.Vocabs_Utilities.Vocab_Repo;

public class AdoptActivity extends AppCompatActivity {

    private EditText catNameTxt;
    private Button catNameButton;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt);

        // find the button and the edittext from xml using findViewById
        catNameTxt = (EditText) findViewById(R.id.cat_name_txt);
        catNameButton = (Button) findViewById(R.id.cat_name_btn);
        System.out.println("Yo");

        // Setting an OnClickLister for the catNameButton
        catNameButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the text entered by the user in the EditText
                String textEntered = catNameTxt.getText().toString();

                if (textEntered.length() > 0) {
                    // Initialize User object
                    mUser = new User(textEntered);
                    System.out.println("New health is " + mUser.getHealth());
                    System.out.println("New mood is " + mUser.getMood());
                    System.out.println("New cash is " + mUser.getCash());

                    // Store the context variable
                    Context context = AdoptActivity.this;
                    // This is the class we want to start and open when button is clicked
                    Class destActivity = MainActivity.class;
                    // create Intent that will start the activity
                    Intent startMainActivityIntent = new Intent(context, destActivity);
                    startMainActivityIntent.putExtra("User", mUser);
                    startActivity(startMainActivityIntent);
                }
                else {
                    new AlertDialog.Builder(AdoptActivity.this)
                            .setTitle(getResources().getString(R.string.title_adopt_name))
                            .setMessage(getResources().getString(R.string.message_adopt_name))
                            .setNeutralButton(getResources().getString(R.string.ok_btn), new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }

            }
        });

    }


    public void onClickNameCatButton(View v) {

    }
}
