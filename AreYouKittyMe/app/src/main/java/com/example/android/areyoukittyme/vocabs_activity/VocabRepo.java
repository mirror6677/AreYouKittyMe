package com.example.android.areyoukittyme.vocabs_activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

/**
 * Created by haoyuxiong on 4/13/17.
 */




public class VocabRepo {


    /**
     * Created by Tan on 1/26/2016.
     */


    private Vocab vocab;
    private final String TAG = VocabRepo.class.getName().toString();
    private VocabList vocabList;

    public VocabRepo() {
        this.vocab = new Vocab();
    }


    public static String createTable() {
        return "CREATE TABLE " + Vocab.TABLE + "("
                + Vocab.KEY_VOCAB_ID + "   PRIMARY KEY    ,"
                + Vocab.KEY_WORD + " TEXT,"
                + Vocab.KEY_DEFINITION + " TEXT,"
                + Vocab.KEY_PROGRESS + " TEXT,"
                + Vocab.KEY_DAY + " TEXT )";
    }


    public int insert(Vocab vocab) {
        int vocabId;
        SQLiteDatabase db = Vocab_DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Vocab.KEY_VOCAB_ID, vocab.getVocab_Id());
        values.put(Vocab.KEY_WORD, vocab.getWord());
        values.put(Vocab.KEY_DEFINITION, vocab.getDefinition());
        values.put(Vocab.KEY_PROGRESS, vocab.getProgress());
        values.put(Vocab.KEY_DAY, "0");


        // Inserting Row
        vocabId = (int) db.insert(Vocab.TABLE, null, values);
        Vocab_DatabaseManager.getInstance().closeDatabase();

        return vocabId;
    }


    public void delete() {
        SQLiteDatabase db = Vocab_DatabaseManager.getInstance().openDatabase();
        db.delete(Vocab.TABLE, null, null);
        Vocab_DatabaseManager.getInstance().closeDatabase();
    }

    public ArrayList<VocabList> getAllVocabList() {

        ArrayList<VocabList>vocabLists = new ArrayList<VocabList>();
        SQLiteDatabase db = Vocab_DatabaseManager.getInstance().openDatabase();
        String selectQuery = "SELECT  * FROM " + Vocab.TABLE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                vocabList = new VocabList();
                vocabList.setVocab_Id(cursor.getString(cursor.getColumnIndex(Vocab.KEY_VOCAB_ID)));
                vocabList.setWord(cursor.getString(cursor.getColumnIndex(Vocab.KEY_WORD)));
                vocabList.setDefinition(cursor.getString(cursor.getColumnIndex(Vocab.KEY_DEFINITION)));
                vocabLists.add(vocabList);


            }while(cursor.moveToNext());

        }
        cursor.close();
        Vocab_DatabaseManager.getInstance().closeDatabase();
        return vocabLists;
    }

    public ArrayList<VocabList> getVocabsInSpecifiedState(String state ){

        ArrayList<VocabList>vocabLists = new ArrayList<VocabList>();
        SQLiteDatabase db = Vocab_DatabaseManager.getInstance().openDatabase();
        String selectQuery = "SELECT  * FROM " + Vocab.TABLE + " WHERE Vocab.progress='"+state +"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                vocabList = new VocabList();
                vocabList.setVocab_Id(cursor.getString(cursor.getColumnIndex(Vocab.KEY_VOCAB_ID)));
                vocabList.setWord(cursor.getString(cursor.getColumnIndex(Vocab.KEY_WORD)));
                vocabList.setDefinition(cursor.getString(cursor.getColumnIndex(Vocab.KEY_DEFINITION)));
                vocabLists.add(vocabList);


            }while(cursor.moveToNext());

        }
        cursor.close();
        Vocab_DatabaseManager.getInstance().closeDatabase();
        return vocabLists;
    }

    public int getCurrentVocabCount(){
        int count;
        SQLiteDatabase db = Vocab_DatabaseManager.getInstance().openDatabase();
        String selectQuery = "SELECT  * FROM " + Vocab.TABLE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        count = cursor.getCount();
        cursor.close();
        Vocab_DatabaseManager.getInstance().closeDatabase();
        return count;

    }

    public Vocab getAVocabByWord(String criteria, String word){

        SQLiteDatabase db = Vocab_DatabaseManager.getInstance().openDatabase();
        String selectQuery = "SELECT  * FROM " + Vocab.TABLE + " WHERE "+criteria+"='"+word +"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null){
            cursor.moveToFirst();}
        else{
            db.close();
            cursor.close();
            return null;
        }

        Vocab vocabWanted = new Vocab(cursor.getString(cursor.getColumnIndex(Vocab.KEY_VOCAB_ID)),
                cursor.getString(cursor.getColumnIndex(Vocab.KEY_WORD)),
                cursor.getString(cursor.getColumnIndex(Vocab.KEY_DEFINITION)),
                cursor.getString(cursor.getColumnIndex(Vocab.KEY_PROGRESS)),
                cursor.getString(cursor.getColumnIndex(Vocab.KEY_DAY)));

        cursor.close();
        Vocab_DatabaseManager.getInstance().closeDatabase();



        return vocabWanted;

    }

    public void updateAWordOnItsProgress(String newState, String id, String currentState){
        SQLiteDatabase db = Vocab_DatabaseManager.getInstance().openDatabase();
        String selectQuery = "UPDATE "+ Vocab.TABLE +
                " SET " + Vocab.KEY_PROGRESS + " = '" + newState + "' WHERE " + Vocab.KEY_VOCAB_ID + " = '"+ id+"'";

        try{
            db.rawQuery(selectQuery,null);
            if(currentState.equals("Not yet") && newState.equals("Studying")){
                Vocab_DatabaseManager.getInstance().getVocabGeneralProgress().studyOne();
                selectQuery = "UPDATE "+ Vocab.TABLE +
                        " SET " + Vocab.KEY_DAY + " = '" + String.format("%d",1) + "' WHERE " + Vocab.KEY_VOCAB_ID + " = '"+ id+"'";
                db.rawQuery(selectQuery,null);
            }else if(currentState.equals("Studying") && newState.equals("Studied")){
                Vocab_DatabaseManager.getInstance().getVocabGeneralProgress().finishStudyOne();
            }

        }catch(Exception whatever){

        }
        db.close();



    }





}