package com.example.retrofit_pppb1.network

import com.example.retrofit_pppb1.model.BuahModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("data.php")
    fun getBuah() : Call<BuahModel>
}