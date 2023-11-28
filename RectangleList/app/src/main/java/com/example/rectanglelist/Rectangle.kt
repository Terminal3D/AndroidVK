package com.example.rectanglelist

import java.io.Serializable


data class Rectangle(val number : Int) : Serializable {

//    val colorTextName : String
    val color : Int

    init {
        if (number % 2 == 0) {
            color = R.color.red
        } else {
            color = R.color.blue
        }
    }
}