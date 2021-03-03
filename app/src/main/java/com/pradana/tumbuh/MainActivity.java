package com.pradana.tumbuh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
    }

    public void tambahData(View view) {
        Intent i = new Intent(this, TambahEditActivity.class);
        startActivityForResult(i, getResources().getInteger(R.integer.INTENT_TAMBAH));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == getResources().getInteger(R.integer.INTENT_TAMBAH)) {
            if (resultCode == Activity.RESULT_OK) {
                text.setText(data.getStringExtra("deskripsi"));
            }
        }
    }
}