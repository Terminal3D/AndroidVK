package com.example.hw2.network.model

import com.google.gson.annotations.SerializedName


data class Temp (

  @SerializedName("value" ) var value : Int?    = null,
  @SerializedName("unit"  ) var unit  : String? = null

)