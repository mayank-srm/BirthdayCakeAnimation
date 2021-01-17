package com.mayank.birthdaycakeanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        CircleImageView fb_button = findViewById(R.id.link_fb);
        CircleImageView insta_button = findViewById(R.id.link_insta);
        CircleImageView Linkedin_button = findViewById(R.id.link_Linkedin);
        TextView ver = findViewById(R.id.ver);
        ver.setText("Version "+BuildConfig.VERSION_NAME);

        fb_button.setOnClickListener(v -> {
            Uri uri = Uri  .parse("http://www.fb.com/mayu198"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        insta_button.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.instagram.com/singh.mayank_"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        Linkedin_button.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.linkedin.com/in/mayank-singh-398b05143/"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ps(View view) {
        Uri uri = Uri.parse("https://play.google.com/store/apps/dev?id=7064561465671345068"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}