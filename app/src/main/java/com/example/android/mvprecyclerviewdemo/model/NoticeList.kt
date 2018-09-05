package com.example.android.mvprecyclerviewdemo.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class NoticeList {
    @SerializedName("notice_list")
    var noticeArrayList: ArrayList<Notice>? = null
}