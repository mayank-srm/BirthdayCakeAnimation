package com.mayank.birthdaycakeanimation;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    ObjectAnimator mSlideAnim;
    @SuppressLint({"ClickableViewAccessibility", "ObsoleteSdkInt"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            

        final ImageView imgFront = findViewById(R.id.img_front);

        RelativeLayout parent = findViewById(R.id.parent);
        parent.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        if (mSlideAnim == null) {
                            triggerSlideUpAnimation(imgFront);
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        goToAnotherPage();
                        break;
                }
                return true;
            }
        });
    }

    private void triggerSlideUpAnimation(ImageView imgFront) {
        int height = imgFront.getHeight();
        mSlideAnim = ObjectAnimator.ofFloat(imgFront, "translationY", 0, -height);
        mSlideAnim.setDuration(4000);
        mSlideAnim.start();
    }

    private void goToAnotherPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}