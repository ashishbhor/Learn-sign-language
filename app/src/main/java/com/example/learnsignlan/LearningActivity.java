package com.example.learnsignlan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import java.io.IOException;

public class LearningActivity extends AppCompatActivity {
    private GifImageView signGif;
    private TextView signMeaning;
    private int currentIndex = 0;

    private final String[] signGifs = {
            "aslhello.gif",
            "aslthankyou.gif",
            "aslplease.gif",
            "aslgoodbye.gif",
            "aslyes.gif",
            "aslno.gif",
            "asllove.gif",
            "aslfriend.gif",
            "aslsorry.gif",
            "aslgoodmorning.gif"
    };

    private final String[] meanings = {
            "Hello - Start with your fingers together and your thumb tucked in (as if giving a salute).",
            "Thank You - Touch lips and move forward",
            "Please - Rub chest in circular motion",
            "Goodbye - Wave hand outward",
            "Yes - Make fist and nod up/down",
            "No - Index and middle finger close like scissors",
            "Love - Cross arms over chest",
            "Friend - Hook index fingers together",
            "Sorry - Fist in circular motion on chest",
            "Good Morning - Wave from mouth outward"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        signGif = findViewById(R.id.signGif);
        signMeaning = findViewById(R.id.signMeaning);
        Button nextButton = findViewById(R.id.nextButton);

        showCurrentSign();

        nextButton.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % signGifs.length;
            showCurrentSign();
        });
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            finish(); // This will return to MainActivity
        });
    }

    private void showCurrentSign() {
        try {
            String gifPath = "gifs/" + signGifs[currentIndex];
            GifDrawable gifFromAssets = new GifDrawable(getAssets(), gifPath);
            signGif.setImageDrawable(gifFromAssets);
            signMeaning.setText(meanings[currentIndex]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

