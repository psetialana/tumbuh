package com.pradana.tumbuh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;

public class TambahEditActivity extends AppCompatActivity {

    EditText editDeskripsi;
    ImageView imageView;
    int status = 0;
    int indexData = 9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_edit);

        editDeskripsi = findViewById(R.id.etDeskripsi);
        imageView = findViewById(R.id.ivFoto);

        Intent i = getIntent();

        if (i.hasExtra("detailList")) {
            String deskripsi = i.getExtras().getString("detailList");
            indexData = i.getExtras().getInt("indexData");
            editDeskripsi.setText(deskripsi);
            status = 1;
        }
    }

    public void save(View view) {
        String deskripsi = editDeskripsi.getText().toString();
        Intent i = new Intent();
        if (status==1) {
            i.putExtra("indexData", indexData);
        }
        i.putExtra("deskripsi", deskripsi);
        setResult(Activity.RESULT_OK, i);
        finish();
    }

    public void cancel(View view) {
        finish();
    }

    public void pickImage(View view) {
        ImagePicker.Companion.with(this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start();

    }

    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            Uri fileUri = data.getData();
            Log.e("test", fileUri.toString());
            Glide.with(this)
                    .load(fileUri)
                    .into(imageView);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}