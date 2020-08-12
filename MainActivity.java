package com.example.bottlespinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

import static com.example.bottlespinner.R.drawable.*;

public class MainActivity extends AppCompatActivity {
ImageView iv;
Button b1;
ConstraintLayout c1;
private Random rng= new Random();
int j;
boolean spinning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        b1 = (Button) findViewById(R.id.b1);
        c1 = (ConstraintLayout) findViewById(R.id.c1);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin(view);
            }
        });
    }
    public void spin(View view)
    {
        if(!spinning)
        {
            int i = rng.nextInt(1800);
            float pivotX = iv.getWidth() /2;
            float pivotY = iv.getHeight() /2;
            Animation rotate= new RotateAnimation(j, i, pivotX, pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            j = i;
            iv.startAnimation(rotate);

        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background();
            }
        });
    }
    public void background() {
        int j = rng.nextInt(5) + 1;

        switch (j) {
            case 1:
                c1.setBackgroundResource(bg1);
                break;
            case 2:
                c1.setBackgroundResource(bg2);
                break;
            case 3:
                c1.setBackgroundResource(bg3);
                break;
            case 4:
                c1.setBackgroundResource(bg4);
                break;
            case 5:
                c1.setBackgroundResource(bg5);
                break;
        }

    }

}
