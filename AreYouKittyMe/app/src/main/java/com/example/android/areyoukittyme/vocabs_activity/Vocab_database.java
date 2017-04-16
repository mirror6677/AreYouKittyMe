package com.example.android.areyoukittyme.vocabs_activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by haoyuxiong on 4/13/17.
 */

public class Vocab_database extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Vocabs.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TAG = Vocab_database.class.getSimpleName().toString();



    public Vocab_database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(VocabRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
