package com.example.lisnrbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // initialize variables
    boolean buttonState = true;
    Button mainButton;
    String ouchString;
    int clickCount;
    Random randNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainButton = (Button) findViewById(R.id.mainButton);
        clickCount = 0;
        ouchString = "Ouch";
        randNum = new Random();

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;

                // handle click constraints
                if (clickCount == 10) {
                    mainButton.setText(ouchString);
                } else if (clickCount == 20) {
                    mainButton.setText(String.valueOf(randNum.nextInt(1000)));
                }

                // toggle button color
                if (buttonState) {
                    mainButton.setBackgroundColor(Color.RED);
                } else {
                    mainButton.setBackgroundColor(Color.BLUE);
                }
                buttonState = !buttonState;
            }
        });
    }
}
