package com.example.android.areyoukittyme.vocabs_activity;

/**
 * Created by haoyuxiong on 4/11/17.
 */

public class Vocab_progress_general {

    private int numOfVocabStudied;
    private int numOfVocabStudying;
    private int numOfVocabHaventStudied;
    private int numOfVocabInTotal;
    private String nameOfTheVocabList;

    public Vocab_progress_general(int numOfVocabInTotal, String nameOfTheVocabList){
        this.numOfVocabInTotal = numOfVocabInTotal;
        this.numOfVocabHaventStudied = numOfVocabInTotal;
        this.numOfVocabStudied = 0;
        this.numOfVocabStudying = 0;
        this.nameOfTheVocabList = nameOfTheVocabList;

    }

    public void studyOne(){

        this.numOfVocabStudying += 1;
        this.numOfVocabHaventStudied -=1 ;


    }

    public void finishStudyOne(){
        this.numOfVocabStudying -=1;
        this.numOfVocabStudied += 1;

    }

    public void restudyAWord(){
        this.numOfVocabStudied-=1;
        this.numOfVocabStudying+=1;

    }

}
