package com.example.android.lovemeter;

import static com.example.android.lovemeter.R.id.img_heart_broken;
import static com.example.android.lovemeter.R.id.img_heart_unbroken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int johnScore = 0;
    int janeScore = 0;
    int totalScore = 0;
    String baggageDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ImageView img_heart_unbroken = (ImageView) findViewById(img_heart_unbroken);
        //img_heart_unbroken.setAlpha(0.1f);

        //ImageView img_heart_broken = (ImageView) findViewById(R.id.img_heart_broken);
        //img_heart_broken.setAlpha(0.9f);

        //increment3PtsForTeamA();
        //displayForTeamA();
        //displayForTeamB(scoreTeamB);
    }

    /**
     * Displays score for John.
     */
    public void displayForJohn(int score) {
        TextView scoreView = (TextView) findViewById(R.id.johnScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays score for Jane.
     */
    public void displayForJane(int score) {
        TextView scoreView = (TextView) findViewById(R.id.janeScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays total score.
     */
    public void displayTotalScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.totalScore);
        scoreView.setText(String.valueOf(score));
        if(totalScore==0){
            baggageDescription = "Now the relationship is like new! No baggage!!";
        }
        if(totalScore>=10){
            baggageDescription = "Too much baggage broke the relationship.\nTime to reset relationship or start forgiving!";

        }
        displayBaggageDescription();
        setTransparencyUnBrokenHeart();
    }

    /**
     * Displays baggage description
     */
    public void displayBaggageDescription() {
        TextView baggageDescription = (TextView) findViewById(R.id.baggageDescription);
        baggageDescription.setText(this.baggageDescription);
    }

    /**
     * Adjust transparency for unbroken heart image
     */
    public void setTransparencyUnBrokenHeart() {
        float transparencyUnBrokenHeart = 1.0f;

        transparencyUnBrokenHeart -= totalScore  * 0.1;
        ImageView imgUnbrokenHeart = (ImageView) findViewById(img_heart_unbroken);
        imgUnbrokenHeart.setAlpha(transparencyUnBrokenHeart);
    }


    /**
     * Hurt Jane
     */
    public void hurtJane(View view) {
        janeScore += 1;
        totalScore = johnScore + janeScore;
        baggageDescription = "John increased Jane's baggage by hurting her.";
        displayForJane(janeScore);
        displayTotalScore(totalScore);
    }

    /**
     * Forgive Jane
     */
    public void forgiveJane(View view) {
        if(johnScore>0){
            johnScore -= 1;
        }
        totalScore = johnScore + janeScore;
        baggageDescription = "John reduced his own baggage by forgiving Jane.";
        displayForJohn(johnScore);
        displayTotalScore(totalScore);
    }

    /**
     * Hurt John
     */
    public void hurtJohn(View view) {
        johnScore += 1;
        totalScore = johnScore + janeScore;
        baggageDescription = "Jane increased John's baggage by hurting him.";
        displayForJohn(johnScore);
        displayTotalScore(totalScore);
    }

    /**
     * Forgive John
     */
    public void forgiveJohn(View view) {
        if(janeScore>0){
            janeScore-= 1;
        }
        totalScore = johnScore + janeScore;
        baggageDescription = "Jane reduced her own baggage by forgiving John.";
        displayForJane(janeScore);
        displayTotalScore(totalScore);
    }

    /**
     * Reset total score
     */
    public void resetTotalScore(View view) {
        johnScore = janeScore = totalScore = 0;
        displayForJohn(johnScore);
        displayForJane(janeScore);
        displayTotalScore(totalScore);

        //displayForTeamA();
        //displayForTeamB(scoreTeamB);
    }

}
