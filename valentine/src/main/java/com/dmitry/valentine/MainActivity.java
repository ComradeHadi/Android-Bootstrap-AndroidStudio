package com.dmitry.valentine;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private BootstrapButton prevBtn, nextBtn;
    ImageView leftImageView, rightImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        leftImageView=(ImageView)findViewById(R.id.limageView);
        rightImageView=(ImageView)findViewById(R.id.rimageView);

        prevBtn = (BootstrapButton) findViewById(R.id.prevBtn);
        nextBtn = (BootstrapButton) findViewById(R.id.nextBtn);

        prevBtn.setAlpha(0.9f);
        nextBtn.setAlpha(0.9f);

        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.prevBtn:
                leftImageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.prev_flip));
                break;
            case R.id.nextBtn:
                rightImageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.next_flip));
                break;
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
