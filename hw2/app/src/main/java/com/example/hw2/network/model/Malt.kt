package com.example.hw2.network.model

import com.example.hw2.network.model.Amount
import com.google.gson.annotations.SerializedName


data class Malt (

  @SerializedName("name"   ) var name   : String? = null,
  @SerializedName("amount" ) var amount : Amount? = Amount()

)