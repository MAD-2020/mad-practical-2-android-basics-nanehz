package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button leftbutton;
    private Button middlebutton;
    private Button rightbutton;
    private int point = 0;
    private TextView score;
    private static final String TAG = "MessagePrompt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftbutton = (Button) findViewById(R.id.leftbutton);
        middlebutton = (Button) findViewById(R.id.middlebutton);
        rightbutton = (Button) findViewById(R.id.rightbutton);
        score = findViewById(R.id.score);


    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Application launched!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Application launched!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Application launched!");
    }

    public void setNewMole()
    {
        Random rand = new Random();
        int n = rand.nextInt(3);

        Button[] ButtonArray = {leftbutton,middlebutton,rightbutton};
        Button mole = ButtonArray[n];

        for ( Button b : ButtonArray)
        {
            if (b== mole)
            {
                b.setText("*");
            }
            else
            {
                b.setText("O");
            }
        }

    }

    public boolean checkMole(String s)
    {
        if (s == "*")
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setScore()
    {


        String Scores = String.valueOf(point);
        score.setText(Scores);

    }
    public void onClickButton(View v)
    {
        Button button = (Button) v;

        if (checkMole(button.getText().toString()))
        {
            point +=1;
        }
        else
        {
            point-=1;
        }


        setNewMole();
        setScore();

    }

}
