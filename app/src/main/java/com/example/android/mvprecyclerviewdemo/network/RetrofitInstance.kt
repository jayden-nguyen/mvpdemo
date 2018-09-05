package com.example.android.mvprecyclerviewdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        var retrofit: Retrofit? = null
        val BASE_URL = "https://api.myjson.com/"
        val retrofitInstance: Retrofit
        get() {
            if (retrofit == null){
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return this.retrofit!!
        }
    }
}