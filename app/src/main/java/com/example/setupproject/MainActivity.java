package com.example.setupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit_name = findViewById(R.id.edit_name);
        final EditText edit_position = findViewById(R.id.edit_position);
        Button btn = findViewById(R.id.btn_submit);

        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(v->
        {
            Intent intent =new Intent(MainActivity.this, RVActivity.class);
            startActivity(intent);
        });

//        Button btn_update = findViewById(R.id.btn_update);
//        Button btn_delete = findViewById(R.id.btn_delete);
        DAOEmployee dao =new DAOEmployee();
        btn.setOnClickListener(v->
        {
            Employee emp = new Employee(edit_name.getText().toString(), edit_position.getText().toString());
            dao.add(emp).addOnSuccessListener(suc ->
            {
                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
//        btn_update.setOnClickListener(v->
//        {
//                HashMap<String, Object> hashMap = new HashMap<>();
//                hashMap.put("name", edit_name.getText().toString());
//                hashMap.put("position", edit_position.getText().toString());
//                dao.update("-MnOW3W3_uTSr0oh_dND", hashMap).addOnSuccessListener(suc ->
//                {
//                    Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
//                    finish();
//                }).addOnFailureListener(er ->
//                {
//                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
//                });
//
//        });
//        btn_delete.setOnClickListener(v->
//        {
//            HashMap<String, Object> hashMap = new HashMap<>();
//            hashMap.put("name", edit_name.getText().toString());
//            hashMap.put("position", edit_position.getText().toString());
//            dao.update("-MnOVxJ7NicQd7g-Okf0", hashMap).addOnSuccessListener(suc ->
//            {
//                Toast.makeText(this, "Record is deleted", Toast.LENGTH_SHORT).show();
//                finish();
//            }).addOnFailureListener(er ->
//            {
//                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
//            });
//
//        });

    }
}