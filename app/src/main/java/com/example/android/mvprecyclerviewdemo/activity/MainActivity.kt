package com.example.android.mvprecyclerviewdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.android.mvprecyclerviewdemo.R
import com.example.android.mvprecyclerviewdemo.adapter.NoticeAdapter
import com.example.android.mvprecyclerviewdemo.model.Notice
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {
    lateinit var presenter:MainContract.presenter
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun setDataToRecyclerView(noticeArrayList: ArrayList<Notice>) {
        val adapter = NoticeAdapter(noticeArrayList, recyclerItemClickListener)
        recyclerViewEmployeeList.adapter = adapter
    }

    override fun onResponseFailure(throwable: Throwable) {
        Toast.makeText(this@MainActivity, "Something went wrong "+throwable.message, Toast.LENGTH_LONG).show()
    }

    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeToolbarAndRecyclerView()
        initializeProgressbar()

        presenter = MainPresenter(this, GetNoticeIntractorImpl())
        presenter.requestDataFromServer()
    }

    private fun initializeProgressbar() {
        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        progressBar.isIndeterminate = true
        val relativeLayout = RelativeLayout(this)
        relativeLayout.gravity = Gravity.CENTER
        relativeLayout.addView(progressBar)
        val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        progressBar.visibility = View.INVISIBLE
        this.addContentView(relativeLayout, params)
    }

    private fun initializeToolbarAndRecyclerView() {
        setSupportActionBar(toolbar)
        recyclerViewEmployeeList.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    val recyclerItemClickListener = object:RecyclerItemClickListener{
        override fun onItemClick(notice: Notice) {
            Toast.makeText(this@MainActivity, "List title: "+ notice.title, Toast.LENGTH_LONG).show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
