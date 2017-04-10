package com.example.android.areyoukittyme;


import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class VocabActivity extends AppCompatActivity {

    private Button studyButton;
    private Button reviewButton;
    private ProgressBar progressBar;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        studyButton = (Button)findViewById(R.id.vocab_study_button2);
        reviewButton = (Button)findViewById(R.id.vocab_Review_button);
        progressBar = (ProgressBar)findViewById(R.id.Vocab_progressBar);

        Intent vocabIntent = getIntent();

        studyButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Context context = VocabActivity.this;
                Class destActivity = VocabStudyActivity.class;
                Intent startVocabActivityIntent = new Intent(context, destActivity);

                startActivity(startVocabActivityIntent);

            }

        });

        reviewButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Context context = VocabActivity.this;
                Class destActivity = VocabReviewActivity.class;
                Intent startVocabActivityIntent = new Intent(context, destActivity);

                startActivity(startVocabActivityIntent);

            }

        });
/*
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus = doWork();

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
*/
    }
}
