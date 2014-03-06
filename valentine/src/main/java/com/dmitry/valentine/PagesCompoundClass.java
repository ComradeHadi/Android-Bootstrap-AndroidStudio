package com.dmitry.valentine;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PagesCompoundClass extends LinearLayout implements View.OnClickListener, Animation.AnimationListener {

    private ImageView imgLeft, imgRight;
    Animation nextAnimation;
    Animation prevAnimation;

    public PagesCompoundClass(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.pages_layout, this);

        initInterface();
    }

    public PagesCompoundClass(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.pages_layout, this);

        initInterface();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageLeft:
                Log.d("flipper", "Left");
                imgLeft.startAnimation(prevAnimation);
                break;
            case R.id.imageRight:
                Log.d("flipper", "Right");
                imgRight.startAnimation(nextAnimation);
                break;
        }
    }

    private void initInterface() {
        imgLeft = (ImageView) findViewById(R.id.imageLeft);
        imgRight = (ImageView) findViewById(R.id.imageRight);

        imgLeft.setOnClickListener(this);
        imgRight.setOnClickListener(this);

        nextAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.next_flip);
        prevAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.prev_flip);
        nextAnimation.setAnimationListener(this);
        prevAnimation.setAnimationListener(this);
    }

    public void setClickable(boolean b) {
        if (!b) {
            imgLeft.setOnClickListener(null);
            imgRight.setOnClickListener(null);
        } else {

        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        imgRight.setClickable(false);
        imgLeft.setClickable(false);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        imgRight.setClickable(true);
        imgLeft.setClickable(true);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
