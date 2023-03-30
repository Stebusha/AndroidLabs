package com.example.achievementroom;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ChoicesActivity extends AppCompatActivity {
    ImageView imageView;
    TransitionDrawable transitionDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        imageView = findViewById(R.id.transition_image);
        transitionDrawable = (TransitionDrawable) imageView.getDrawable();
    }

    public void startTransition(View view){
        transitionDrawable.startTransition(1000);
    }
}
