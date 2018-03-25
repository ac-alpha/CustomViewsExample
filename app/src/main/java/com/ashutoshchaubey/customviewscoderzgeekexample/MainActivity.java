package com.ashutoshchaubey.customviewscoderzgeekexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ashutoshchaubey.customviewscoderzgeekexample.views.CustomView;

public class MainActivity extends AppCompatActivity {

    private Button swapButton;
    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView=(CustomView)findViewById(R.id.custom_view);
        swapButton=(Button)findViewById(R.id.btn_swap_color);
        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customView.swapColor();
            }
        });

    }
}
