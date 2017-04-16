package com.example.android.areyoukittyme.vocabs_activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.areyoukittyme.app.App;

/**
 * Created by haoyuxiong on 4/13/17.
 */

public class Vocab_Database extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Vocabs.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TAG = Vocab_Database.class.getSimpleName().toString();



    public Vocab_Database() {
        super(App.getContext(), this.DATABASE_NAME, null, this.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(Vocab_Repo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
