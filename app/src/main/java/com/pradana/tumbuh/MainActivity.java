package com.pradana.tumbuh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pradana.tumbuh.adapter.TanamanAdapter;
import com.pradana.tumbuh.model.Tanaman;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView text;

    ArrayList<Tanaman> tanaman;
    TanamanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);

        tanaman = new ArrayList<Tanaman>();

        // Lookup the recyclerview in activity layout
        RecyclerView rvTanaman = (RecyclerView) findViewById(R.id.rvTanaman);

        // Create adapter passing in the sample user data
        adapter = new TanamanAdapter(tanaman);
        // Attach the adapter to the recyclerview to populate items
        rvTanaman.setAdapter(adapter);
        // Set layout manager to position the items
        rvTanaman.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

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
                Tanaman itemData = new Tanaman();
                itemData.setDeskripsi(data.getStringExtra("deskripsi"));
                tanaman.add(itemData);
                adapter.notifyDataSetChanged();
            }
        }
    }
}