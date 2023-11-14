package com.example.retrofit_pppb1.model

import com.google.gson.annotations.SerializedName

data class BuahModel(
    @SerializedName("result")
    var result : List<BuahData>
)

data class BuahData(
    @SerializedName("id")
    val id : Int,
    @SerializedName("title")
    val title : String,
    @SerializedName("image")
    val image : String
)