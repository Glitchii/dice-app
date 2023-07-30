package io.github.glitchii.dice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView rolledText, rolledTitle;
    ImageView emptyDice, dice;
    MaterialButton rollButton;
    Boolean firstRoll = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.rollButton);
        rolledTitle = findViewById(R.id.rolledTitle);
        rolledText = findViewById(R.id.rolledNumber);
        emptyDice = findViewById(R.id.emptyDice);
        dice = findViewById(R.id.dice);

        findViewById(R.id.rollButton).setOnClickListener(v -> roll());
    }

    /**
     * Picks a number and performs transition animations
     */
    private void roll() {
        fadeIn(emptyDice, 200);
        fadeOut(dice);
        fadeOut(rolledText);

        // int randomNumber = (int) Math.ceil(Math.random() * 6);
        int randomNumber = new Random().nextInt(6) + 1;

        new Handler().postDelayed(() -> {
            switch (randomNumber) {
                case 1:
                    dice.setImageResource(R.drawable.dice1);
                    break;
                case 2:
                    dice.setImageResource(R.drawable.dice2);
                    break;
                case 3:
                    dice.setImageResource(R.drawable.dice3);
                    break;
                case 4:
                    dice.setImageResource(R.drawable.dice4);
                    break;
                case 5:
                    dice.setImageResource(R.drawable.dice5);
                    break;
                case 6:
                    dice.setImageResource(R.drawable.dice6);
                    break;
            }

            rolledText.setText(Integer.toString(randomNumber));

            if (firstRoll) {
                // rollButton.animate().translationYBy(160f).setDuration(300).start();
                firstRoll = false;
            }

            fadeIn(dice);
            fadeOut(emptyDice);
            fadeIn(rolledText, .6f);
            fadeIn(rolledTitle, .6f);
        }, 500);
    }

    protected void fadeIn(View v) {
        fadeIn(v, 1);
    }

    protected void fadeOut(View v) {
        fadeOut(v, 500);
    }

    protected void fadeIn(View v, int duration) {
        fadeIn(v, 1, duration);
    }

    protected void fadeIn(View v, float maxAlpha) {
        fadeIn(v, maxAlpha, 500);
    }

    protected void fadeOut(View v, int duration) {
        v.animate().alpha(0f).setDuration(duration).start();
    }

    protected void fadeIn(View v, float maxAlpha, int duration) {
        v.animate().alpha(maxAlpha).setDuration(duration).start();
    }
}