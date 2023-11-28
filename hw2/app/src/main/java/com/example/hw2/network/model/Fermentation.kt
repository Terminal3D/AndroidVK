package com.example.hw2.network.model

import com.google.gson.annotations.SerializedName


data class Fermentation (

  @SerializedName("temp" ) var temp : Temp? = Temp()

)