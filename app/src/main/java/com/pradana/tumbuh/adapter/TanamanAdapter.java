package com.pradana.tumbuh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pradana.tumbuh.R;
import com.pradana.tumbuh.TambahEditActivity;
import com.pradana.tumbuh.model.Tanaman;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class TanamanAdapter extends
        RecyclerView.Adapter<TanamanAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public View layoutItem;
        public TextView textNama;
        public TextView textDeskripsi;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);


            textNama = (TextView) itemView.findViewById(R.id.textNama);
            textDeskripsi = (TextView) itemView.findViewById(R.id.textDeskripsi);
            layoutItem = (View) itemView.findViewById(R.id.layoutItem);
        }
    }

    private List<Tanaman> mTanaman;

    public TanamanAdapter(List<Tanaman> tanaman) {
        mTanaman = tanaman;
    }

    // ... constructor and member variables

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public TanamanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_tanaman, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(TanamanAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        final Tanaman tanaman = mTanaman.get(position);

        // Set item views based on your views and data model
        TextView textNama = holder.textNama;
        textNama.setText(tanaman.getNama());
        TextView textDeskripsi = holder.textDeskripsi;
        textDeskripsi.setText(tanaman.getDeskripsi());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), TambahEditActivity.class);
                i.putExtra("123", tanaman.getDeskripsi().toString());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTanaman.size();
    }

}
