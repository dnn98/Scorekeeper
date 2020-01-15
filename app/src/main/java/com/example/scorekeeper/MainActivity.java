package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView team1view;
private TextView team2view;
private int team1score = 0;
private int team2score = 0;
private int nightMode;
private String STATE_SCORE_1 = "team1";
private String STATE_SCORE_2 = "team2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team1view = findViewById(R.id.team1score);
        team2view = findViewById(R.id.team2score);

        if (savedInstanceState != null) {
            team1score = savedInstanceState.getInt(STATE_SCORE_1);
            team2score = savedInstanceState.getInt(STATE_SCORE_2);
        }
            //Set the score text views
            team1view.setText(String.valueOf(team1score));
            team2view.setText(String.valueOf(team2score));


    }
    public void team1minus(View view){
        if(team1score>0){
            team1score=team1score-1;
            team1view.setText(Integer.toString(team1score));
        }

    }
    public void team1plus(View view){
        team1score=team1score+1;
        team1view.setText(Integer.toString(team1score));
    }

    public void team2minus(View view){
        if(team2score>0){
            team2score=team2score-1;
            team2view.setText(Integer.toString(team2score));
        }
    }
    public void team2plus(View view){
        team2score=team2score+1;
        team2view.setText(Integer.toString(team2score));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //change the label
        nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode ==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //call if is night mode
        AppCompatDelegate.getDefaultNightMode();
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){

        }
        nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            recreate();
        }else
            {AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            recreate();
            }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        //Save the scores

        outState.putInt(STATE_SCORE_1, team1score);
        outState.putInt(STATE_SCORE_2, team2score);
        super.onSaveInstanceState(outState, outPersistentState);

    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //team1score = savedInstanceState.getInt(STATE_SCORE_1);
        //team2score = savedInstanceState.getInt(STATE_SCORE_2);

    }

}
