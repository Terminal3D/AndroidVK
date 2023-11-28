package com.example.hw2.network.model

import com.example.hw2.network.model.Amount
import com.google.gson.annotations.SerializedName


data class Hops (

  @SerializedName("name"      ) var name      : String? = null,
  @SerializedName("amount"    ) var amount    : Amount? = Amount(),
  @SerializedName("add"       ) var add       : String? = null,
  @SerializedName("attribute" ) var attribute : String? = null

)