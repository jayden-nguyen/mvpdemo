package com.example.android.mvprecyclerviewdemo.activity

import com.example.android.mvprecyclerviewdemo.model.Notice

class MainPresenter(mainView: MainContract.MainView?, getNoticeIntractor: MainContract.GetNoticeIntractor): MainContract.presenter, MainContract.GetNoticeIntractor.OnFinishedListener {
    private var mainView = mainView
    private var getNoticeIntractor: MainContract.GetNoticeIntractor = getNoticeIntractor
    override fun onDestroy() {
        mainView = null
    }

    override fun onRefreshButtonClick() {
        mainView?.showProgress()
        getNoticeIntractor.getNoticeArrayList(this)
    }

    override fun requestDataFromServer() {
        getNoticeIntractor.getNoticeArrayList(this)
    }

    override fun onFinished(noticeArrayList: ArrayList<Notice>) {
        if (mainView != null) {
            mainView!!.setDataToRecyclerView(noticeArrayList)
            mainView!!.hideProgress()
        }
    }

    override fun onFailure(t: Throwable) {
        if (mainView != null) {
            mainView!!.onResponseFailure(t)
            mainView!!.hideProgress()
        }
    }
}