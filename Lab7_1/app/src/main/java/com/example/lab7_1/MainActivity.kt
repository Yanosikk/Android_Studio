package com.example.lab7_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val items: ArrayList<Item> = ArrayList()
        items.add(Item("Blue", "A colour of peace", R.drawable.blue));
        items.add(Item("Green", "A colour of nature", R.drawable.green));
        items.add(Item("Pink", "Not a part of spectrum", R.drawable.pink));

        for (i in 1..10) {
            items.add(Item("Blue", "A colour of peace", R.drawable.blue));
            items.add(Item("Green", "A colour of nature", R.drawable.green));
            items.add(Item("Pink", "Not a part of spectrum", R.drawable.pink));
        }


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this@MainActivity, items);
    }
}