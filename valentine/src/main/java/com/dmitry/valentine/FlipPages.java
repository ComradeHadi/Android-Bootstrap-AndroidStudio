package com.dmitry.valentine;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FlipPages extends LinearLayout implements View.OnClickListener, Animation.AnimationListener {

    private final static int DELAY = 1300;

    private Context context;
    private int count = 1;

    private ImageView topLeft, topRight, botLeft, botRight;

    Animation nextAnimation1, nextAnimation2, prevAnimation1, prevAnimation2;

    public FlipPages(Context context) {
        super(context);
        this.context = context;
        initInterface();
    }

    public FlipPages(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initInterface();
    }

    private void initInterface() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.flip_pages_layout, this);

        topRight = (ImageView) findViewById(R.id.imageRightTop);
        botRight = (ImageView) findViewById(R.id.imageRightBot);
        topLeft = (ImageView) findViewById(R.id.imageLeftTop);
        botLeft = (ImageView) findViewById(R.id.imageLeftBot);

        topLeft.setImageResource(R.drawable.img_1l);
        topRight.setImageResource(R.drawable.img_1r);


        topLeft.setOnClickListener(this);
        topRight.setOnClickListener(this);

        nextAnimation1 = AnimationUtils.loadAnimation(context, R.anim.next_flip1);
        nextAnimation2 = AnimationUtils.loadAnimation(context, R.anim.next_flip2);
        prevAnimation1 = AnimationUtils.loadAnimation(context, R.anim.prev_flip1);
        prevAnimation2 = AnimationUtils.loadAnimation(context, R.anim.prev_flip2);

        nextAnimation1.setAnimationListener(this);
        nextAnimation2.setAnimationListener(this);
        prevAnimation1.setAnimationListener(this);
        prevAnimation2.setAnimationListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageLeftTop:
                prevAnimation();
                break;
            case R.id.imageRightTop:
                nextAnimation();
                break;
        }
    }

    private void prevAnimation() {
        if (count == 1) {
            Vibrator v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(30);
            return;
        }
        switch (count) {
            case 2:
                botLeft.setImageResource(R.drawable.img_1l);
                topLeft.startAnimation(prevAnimation1);
                topLeft.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topLeft.setImageResource(R.drawable.img_1l);
                        botRight.setImageResource(R.drawable.img_2r);
                        topRight.setImageResource(R.drawable.img_1r);
                        topRight.startAnimation(prevAnimation2);
                    }
                }, DELAY);
                count -= 1;
                break;
            case 3:
                botLeft.setImageResource(R.drawable.img_2l);
                topLeft.startAnimation(prevAnimation1);
                topLeft.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topLeft.setImageResource(R.drawable.img_2l);
                        botRight.setImageResource(R.drawable.img_3r);
                        topRight.setImageResource(R.drawable.img_2r);
                        topRight.startAnimation(prevAnimation2);
                    }
                }, DELAY);
                count -= 1;
                break;
            case 4:
                botLeft.setImageResource(R.drawable.img_3l);
                topLeft.startAnimation(prevAnimation1);
                topLeft.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topLeft.setImageResource(R.drawable.img_3l);
                        botRight.setImageResource(R.drawable.img_4r);
                        topRight.setImageResource(R.drawable.img_3r);
                        topRight.startAnimation(prevAnimation2);
                    }
                }, DELAY);
                count -= 1;
                break;
            case 5:
                botLeft.setImageResource(R.drawable.img_4l);
                topLeft.startAnimation(prevAnimation1);
                topLeft.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topLeft.setImageResource(R.drawable.img_4l);
                        botRight.setImageResource(R.drawable.img_5r);
                        topRight.setImageResource(R.drawable.img_4r);
                        topRight.startAnimation(prevAnimation2);
                    }
                }, DELAY);
                count -= 1;
                break;
            case 6:
                botLeft.setImageResource(R.drawable.img_5l);
                topLeft.startAnimation(prevAnimation1);
                topLeft.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topLeft.setImageResource(R.drawable.img_5l);
                        botRight.setImageResource(R.drawable.img_6r);
                        topRight.setImageResource(R.drawable.img_5r);
                        topRight.startAnimation(prevAnimation2);
                    }
                }, DELAY);
                count -= 1;
                break;
            case 7:
                botLeft.setImageResource(R.drawable.img_6l);
                topLeft.startAnimation(prevAnimation1);
                topLeft.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topLeft.setImageResource(R.drawable.img_6l);
                        botRight.setImageResource(R.drawable.img_7r);
                        topRight.setImageResource(R.drawable.img_6r);
                        topRight.startAnimation(prevAnimation2);
                    }
                }, DELAY);
                count -= 1;
                break;
            case 8:
                botLeft.setImageResource(R.drawable.img_7l);
                topLeft.startAnimation(prevAnimation1);
                topLeft.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topLeft.setImageResource(R.drawable.img_7l);
                        botRight.setImageResource(R.drawable.img_8r);
                        topRight.setImageResource(R.drawable.img_7r);
                        topRight.startAnimation(prevAnimation2);
                    }
                }, DELAY);
                count -= 1;
                break;
            case 9:
                botLeft.setImageResource(R.drawable.img_8l);
                topLeft.startAnimation(prevAnimation1);
                topLeft.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topLeft.setImageResource(R.drawable.img_8l);
                        botRight.setImageResource(R.drawable.img_9r);
                        topRight.setImageResource(R.drawable.img_8r);
                        topRight.startAnimation(prevAnimation2);
                    }
                }, DELAY);
                count -= 1;
                break;
        }
    }

    private void nextAnimation() {
        if (count == 8) {
            Vibrator v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(30);
            return;
        }
        switch (count) {
            case 1:
                botRight.setImageResource(R.drawable.img_2r);
                topRight.startAnimation(nextAnimation1);
                topRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topRight.setImageResource(R.drawable.img_2r);
                        botLeft.setImageResource(R.drawable.img_1l);
                        topLeft.setImageResource(R.drawable.img_2l);
                        topLeft.startAnimation(nextAnimation2);
                    }
                }, DELAY);
                count += 1;
                break;
            case 2:
                botRight.setImageResource(R.drawable.img_3r);
                topRight.startAnimation(nextAnimation1);
                topRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topRight.setImageResource(R.drawable.img_3r);
                        botLeft.setImageResource(R.drawable.img_2l);
                        topLeft.setImageResource(R.drawable.img_3l);
                        topLeft.startAnimation(nextAnimation2);
                    }
                }, DELAY);
                count += 1;
                break;
            case 3:
                botRight.setImageResource(R.drawable.img_4r);
                topRight.startAnimation(nextAnimation1);
                topRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topRight.setImageResource(R.drawable.img_4r);
                        botLeft.setImageResource(R.drawable.img_3l);
                        topLeft.setImageResource(R.drawable.img_4l);
                        topLeft.startAnimation(nextAnimation2);
                    }
                }, DELAY);
                count += 1;
                break;
            case 4:
                botRight.setImageResource(R.drawable.img_5r);
                topRight.startAnimation(nextAnimation1);
                topRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topRight.setImageResource(R.drawable.img_5r);
                        botLeft.setImageResource(R.drawable.img_4l);
                        topLeft.setImageResource(R.drawable.img_5l);
                        topLeft.startAnimation(nextAnimation2);
                    }
                }, DELAY);
                count += 1;
                break;
            case 5:
                botRight.setImageResource(R.drawable.img_6r);
                topRight.startAnimation(nextAnimation1);
                topRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topRight.setImageResource(R.drawable.img_6r);
                        botLeft.setImageResource(R.drawable.img_5l);
                        topLeft.setImageResource(R.drawable.img_6l);
                        topLeft.startAnimation(nextAnimation2);
                    }
                }, DELAY);
                count += 1;
                break;
            case 6:
                botRight.setImageResource(R.drawable.img_7r);
                topRight.startAnimation(nextAnimation1);
                topRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topRight.setImageResource(R.drawable.img_7r);
                        botLeft.setImageResource(R.drawable.img_6l);
                        topLeft.setImageResource(R.drawable.img_7l);
                        topLeft.startAnimation(nextAnimation2);
                    }
                }, DELAY);
                count += 1;
                break;
            case 7:
                botRight.setImageResource(R.drawable.img_8r);
                topRight.startAnimation(nextAnimation1);
                topRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topRight.setImageResource(R.drawable.img_8r);
                        botLeft.setImageResource(R.drawable.img_7l);
                        topLeft.setImageResource(R.drawable.img_8l);
                        topLeft.startAnimation(nextAnimation2);
                    }
                }, DELAY);
                count += 1;
                break;
            case 8:
                botRight.setImageResource(R.drawable.img_9r);
                topRight.startAnimation(nextAnimation1);
                topRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topRight.setImageResource(R.drawable.img_9r);
                        botLeft.setImageResource(R.drawable.img_8l);
                        topLeft.setImageResource(R.drawable.img_9l);
                        topLeft.startAnimation(nextAnimation2);
                    }
                }, DELAY);
                count += 1;
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (animation == nextAnimation1 || animation == prevAnimation1) {
            topLeft.setOnClickListener(null);
            topRight.setOnClickListener(null);
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == nextAnimation2 || animation == prevAnimation2) {
            topLeft.setOnClickListener(this);
            topRight.setOnClickListener(this);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
