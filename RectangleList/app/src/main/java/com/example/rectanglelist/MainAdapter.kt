package com.example.rectanglelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class MainAdapter(private val rectangles : List<Rectangle>) : Adapter<MainAdapter.MainViewHolder>() {



    class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tv : TextView = itemView.findViewById(R.id.rectangle)

        fun bind(rectangle: Rectangle) {
            tv.text = rectangle.number.toString()
            if (rectangle.number % 2 == 0) {
                tv.setBackgroundResource(R.color.red)
            } else tv.setBackgroundResource(R.color.blue)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rectangle_view, null)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rectangles.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(rectangles[position])
    }
}