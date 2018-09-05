package com.example.android.mvprecyclerviewdemo.activity

import com.example.android.mvprecyclerviewdemo.model.Notice

interface MainContract {
    interface presenter{
        fun onDestroy()
        fun onRefreshButtonClick()
        fun requestDataFromServer()
    }

    interface MainView {
        fun showProgress()
        fun hideProgress()
        fun setDataToRecyclerView(noticeArrayList: ArrayList<Notice>)
        fun onResponseFailure(throwable: Throwable)
    }

    interface GetNoticeIntractor{
        interface OnFinishedListener{
            fun onFinished(noticeArrayList: ArrayList<Notice>)
            fun onFailure(t: Throwable)
        }

        fun getNoticeArrayList(onFinishedListener: OnFinishedListener)
    }


}