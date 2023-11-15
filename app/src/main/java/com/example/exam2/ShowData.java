package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {

    DB_Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        TextView dis = (TextView) findViewById(R.id.dis);
        Button btnback = (Button) findViewById(R.id.btnback);
        controller = new DB_Controller(this, "", null, 1);
        controller.list_product(dis);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(a);
            }
        });
    }
}