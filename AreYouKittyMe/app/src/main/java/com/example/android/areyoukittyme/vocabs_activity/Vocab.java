package com.example.android.areyoukittyme.vocabs_activity;

/**
 * Created by haoyuxiong on 4/13/17.
 */

public class Vocab {

    public static final String TAG = Vocab.class.getSimpleName();
    public static final String TABLE = "Vocab";
    // Labels Table Columns names
    public static final String KEY_VOCAB_ID = "Vocab_Id";
    public static final String KEY_WORD = "Word";
    public static final String KEY_DEFINITION = "Name";
    public static final String KEY_DAY = "Days";
    public static final String KEY_PROGRESS = "Progress";


    private String Vocab_Id;
    private String word;
    private String definition;
    private String day;
    private String progress;
    public Vocab(){}

    public Vocab(String vocab_Id, String word, String definition, String day, String progress) {
        Vocab_Id = vocab_Id;
        this.word = word;
        this.definition = definition;
        this.day = day;
        this.progress = progress;
    }

    public String getVocab_Id() {
        return Vocab_Id;
    }

    public void setVocab_Id(String vocab_Id) {
        Vocab_Id = vocab_Id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
