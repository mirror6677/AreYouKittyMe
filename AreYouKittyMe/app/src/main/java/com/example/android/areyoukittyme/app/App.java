package com.example.android.areyoukittyme.app;

import android.app.Application;
import android.content.Context;

import com.example.android.areyoukittyme.vocabs_activity.Vocab_DatabaseManager;
import com.example.android.areyoukittyme.vocabs_activity.Vocab_Database;

/**
 * Created by haoyuxiong on 4/16/17.
 */

public class App extends Application{
    private static Context context;
    private static Vocab_Database vocab_database;

    @Override
    public void onCreate(){
        super.onCreate();
        this.context = this.getApplicationContext();
        vocab_database = new Vocab_Database();
        Vocab_DatabaseManager.initializeInstance(vocab_database);


    }

    public static Context getContext(){
        return context;

    }
}