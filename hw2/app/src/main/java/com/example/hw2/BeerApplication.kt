package com.example.hw2

import android.app.Application
import com.example.hw2.data.AppContainer
import com.example.hw2.data.DefaultAppContainer

class BeerApplication : Application() {
    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}