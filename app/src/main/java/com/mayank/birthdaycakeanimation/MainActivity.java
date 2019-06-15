package com.mayank.birthdaycakeanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
import tyrantgit.explosionfield.ExplosionField;

public class MainActivity extends AppCompatActivity {

    ImageView candle1, candle2,flame1,flame2,balloon1;
    Button button;
    int counter = 0;
    int[] imageArray = { R.drawable.candle_0, R.drawable.candle_1, R.drawable.candle_2, R.drawable.candle_3, R.drawable.candle_4
                        ,R.drawable.candle_5, R.drawable.candle_6, R.drawable.candle_7, R.drawable.candle_8, R.drawable.candle_9,
                         R.drawable.candle_0, R.drawable.candle_1, R.drawable.candle_2, R.drawable.candle_3, R.drawable.candle_4
                        ,R.drawable.candle_5, R.drawable.candle_6, R.drawable.candle_7, R.drawable.candle_8, R.drawable.candle_9,
                         R.drawable.candle_0, R.drawable.candle_1, R.drawable.candle_2, R.drawable.candle_3, R.drawable.candle_4
                        ,R.drawable.candle_5, R.drawable.candle_6, R.drawable.candle_7, R.drawable.candle_8, R.drawable.candle_9,
                         R.drawable.candle_0, R.drawable.candle_1, R.drawable.candle_2, R.drawable.candle_3, R.drawable.candle_4
                        ,R.drawable.candle_5, R.drawable.candle_6, R.drawable.candle_7, R.drawable.candle_8, R.drawable.candle_9,
                         R.drawable.candle_0, R.drawable.candle_1, R.drawable.candle_2, R.drawable.candle_3, R.drawable.candle_4
                        ,R.drawable.candle_5, R.drawable.candle_6, R.drawable.candle_7, R.drawable.candle_8, R.drawable.candle_9,
                         R.drawable.candle_0, R.drawable.candle_1, R.drawable.candle_2, R.drawable.candle_3, R.drawable.candle_4
                        ,R.drawable.candle_5, R.drawable.candle_6, R.drawable.candle_7, R.drawable.candle_8, R.drawable.candle_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        candle1 = findViewById(R.id.candle1);
        candle2 = findViewById(R.id.candle2);
        flame1 = findViewById(R.id.flame1);
        flame2 = findViewById(R.id.flame2);
        balloon1 = findViewById(R.id.balloon1);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
        balloon1.setAnimation(animation);
        final MediaPlayer mediaPlayer  = MediaPlayer.create(getApplicationContext(),R.raw.song);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mediaPlayer.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //mediaPlayer.pause();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        final KonfettiView konfettiView = findViewById(R.id.viewKonfetti);

        konfettiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                konfettiView.build()
                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA,Color.RED,Color.GRAY,Color.TRANSPARENT)
                        .setDirection(0.0, 359.0)
                        .setSpeed(1f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000)
                        .addShapes(Shape.RECT, Shape.CIRCLE)
                        .addSizes(new Size(8, 2f))
                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                        .streamFor(50, 5000);
            }
        });
    }

    public void candle1(View view) {
        counter = counter + 1;
        for(int i=0;i<10;i++) {
            Glide.with(this).load(imageArray[counter]).into(candle1);
        }

    }
    public void candle2(View view) {
        counter = counter + 1;
        for(int i=0;i<10;i++) {
            Glide.with(this).load(imageArray[counter]).into(candle2);
        }
    }

    public void flame1(View view) {
        flame1.setVisibility(View.INVISIBLE);
    }
    public void flame2(View view) {
        flame2.setVisibility(View.INVISIBLE);
    }

    public void Wish(View view) {

        button.setVisibility(View.INVISIBLE);
        flame1.setVisibility(View.VISIBLE);
        flame2.setVisibility(View.VISIBLE);


    }

    public void explode(View view) {
        ExplosionField explosionField = ExplosionField.attach2Window(this);
        explosionField.explode(view);
    }
}
