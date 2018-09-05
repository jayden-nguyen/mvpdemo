package com.example.android.mvprecyclerviewdemo.`interface`

import com.example.android.mvprecyclerviewdemo.model.Notice
import com.example.android.mvprecyclerviewdemo.model.NoticeList
import retrofit2.Call
import retrofit2.http.GET

interface GetNoticeDataService {
    @GET("bins/1bsqcn/")
    fun getNoticeData(): Call<NoticeList>
}