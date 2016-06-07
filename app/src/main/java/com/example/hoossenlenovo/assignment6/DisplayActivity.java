package com.example.hoossenlenovo.assignment6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by hoossenLenovo on 2016-06-06.
 */
public class DisplayActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String username = getIntent().getStringExtra("Username");

        TextView tV = (TextView)findViewById(R.id.txtUN);

        tV.setText(username);
    }
}
