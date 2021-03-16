package com.pradana.tumbuh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TambahEditActivity extends AppCompatActivity {

    EditText editDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_edit);

        editDeskripsi = findViewById(R.id.editTextTextMultiLine);

        Intent i = new Intent();

        if (i.hasExtra("123")) {
            String deskripsi = i.getExtras().getString("123");
            editDeskripsi.setText(deskripsi);
        } else {
            editDeskripsi.setText("data tidak sampai");
        }
    }

    public void save(View view) {
        String deskripsi = editDeskripsi.getText().toString();
        Intent i = new Intent();
        i.putExtra("deskripsi", deskripsi);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}