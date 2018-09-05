package com.example.android.mvprecyclerviewdemo.activity

import com.example.android.mvprecyclerviewdemo.model.Notice

interface RecyclerItemClickListener{
    fun onItemClick(notice: Notice)
}