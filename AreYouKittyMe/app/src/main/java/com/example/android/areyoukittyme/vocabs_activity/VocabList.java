package com.example.android.areyoukittyme.vocabs_activity;

/**
 * Created by haoyuxiong on 4/15/17.
 */

public class VocabList {

    private String Vocab_Id;
    private String word;
    private String definition;

    public VocabList() {
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


}
