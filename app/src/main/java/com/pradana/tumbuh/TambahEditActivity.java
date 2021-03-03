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
    }

    public void save(View view) {
        String deskripsi = editDeskripsi.getText().toString();
        Intent i = new Intent();
        i.putExtra("deskripsi", deskripsi);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}