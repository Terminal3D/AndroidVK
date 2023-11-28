package com.example.hw2.network.model

import com.google.gson.annotations.SerializedName


data class MashTemp (

  @SerializedName("temp"     ) var temp     : Temp?   = Temp(),
  @SerializedName("duration" ) var duration : String? = null

)