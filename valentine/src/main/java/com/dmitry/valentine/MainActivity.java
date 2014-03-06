package com.dmitry.valentine;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

//    private BootstrapButton prevBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        PagesCompoundClass mainViewTop = (PagesCompoundClass) findViewById(R.id.mainViewBot);
        mainViewTop.setClickable(false);
    }
}
