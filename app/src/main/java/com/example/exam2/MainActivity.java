package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DB_Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtBID = (EditText) findViewById(R.id.edtBID);
        EditText edtBName = (EditText) findViewById(R.id.edtBName);
        EditText edtBPrice = (EditText) findViewById(R.id.edtBPrice);
        EditText edtBUnit = (EditText) findViewById(R.id.edtBUnit);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        Button btnDel = (Button) findViewById(R.id.btnDel);
        Button btnView = (Button) findViewById(R.id.btnView);
        controller = new DB_Controller(this, "", null, 1);
        // add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.insert_product(edtBID.getText().toString(),edtBName.getText().toString(),edtBPrice.getText().toString(),edtBUnit.getText().toString());
            }
        });
        //update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.update_product(edtBID.getText().toString(),edtBName.getText().toString(),edtBPrice.getText().toString(),edtBUnit.getText().toString());
            }
        });
        //delete
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.delete_product(edtBID.getText().toString());
            }
        });
        // display
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShowData.class);
                startActivity(i);
            }
        });
    }
}