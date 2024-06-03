package com.example.lab7_1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHold extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView colourView, descriptionView;


    public ViewHold(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        colourView = itemView.findViewById(R.id.colour);
        descriptionView = itemView.findViewById(R.id.description);

    }
}