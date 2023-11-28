package com.example.rectanglelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter



class MainAdapter(private val rectangles : List<Rectangle>) : Adapter<MainAdapter.MainViewHolder>() {


    class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tv : TextView = itemView.findViewById(R.id.rectangle)

        fun bind(rectangle: Rectangle) {
            tv.text = rectangle.number.toString()
            tv.setBackgroundResource(rectangle.color)
            tv.setOnClickListener {
//                Toast.makeText(itemView.context, rectangle.colorTextName, Toast.LENGTH_SHORT).show()
                tv.context.startActivity(MainActivity2.newInstance(tv.context, rectangle.number, rectangle.color))
            }
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