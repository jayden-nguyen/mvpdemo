package com.example.android.mvprecyclerviewdemo.activity

import com.example.android.mvprecyclerviewdemo.`interface`.GetNoticeDataService
import com.example.android.mvprecyclerviewdemo.model.NoticeList
import com.example.android.mvprecyclerviewdemo.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class GetNoticeIntractorImpl: MainContract.GetNoticeIntractor {
    override fun getNoticeArrayList(onFinishedListener: MainContract.GetNoticeIntractor.OnFinishedListener) {
        var service:GetNoticeDataService = RetrofitInstance.retrofitInstance.create(GetNoticeDataService::class.java)
        var call = service.getNoticeData()
        call.enqueue(object :  retrofit2.Callback<NoticeList> {
            override fun onFailure(call: Call<NoticeList>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }

            override fun onResponse(call: Call<NoticeList>, response: Response<NoticeList>) {
                onFinishedListener.onFinished(response.body()!!.noticeArrayList!!)
            }
        })

    }
}
