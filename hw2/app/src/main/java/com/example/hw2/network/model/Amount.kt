package com.example.hw2.network.model

import com.google.gson.annotations.SerializedName


data class Amount (

  @SerializedName("value" ) var value : Double?    = null,
  @SerializedName("unit"  ) var unit  : String? = null

)