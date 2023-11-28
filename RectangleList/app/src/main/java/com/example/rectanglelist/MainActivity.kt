package com.example.rectanglelist

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton



class MainActivity : AppCompatActivity() {

    private var container : MutableList<Rectangle> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_landscape)
        } else {
            setContentView(R.layout.activity_main_portrait)
        }


        if (savedInstanceState != null) {
            container = savedInstanceState.getSerializable("containerKey") as ArrayList<Rectangle>
        }
        val rv: RecyclerView = findViewById(R.id.activity_main_rv)
        val adapter = MainAdapter(container)
        rv.adapter = adapter
        val addButton : FloatingActionButton = findViewById(R.id.float_add_button)
        addButton.setOnClickListener {
            container.add(Rectangle(container.size))
            adapter.notifyItemInserted(container.size - 1)
            rv.smoothScrollToPosition(container.size - 1)
        }


    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("containerKey", ArrayList(container))
    }


}