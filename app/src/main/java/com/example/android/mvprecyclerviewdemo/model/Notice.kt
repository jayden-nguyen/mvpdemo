package com.example.android.mvprecyclerviewdemo.model

import com.google.gson.annotations.SerializedName

class Notice (@field:SerializedName("id") var id:String?,
              @field:SerializedName("title") var title:String?,
              @field:SerializedName("brief") var brief: String?,
              @field:SerializedName("fileSource") var fileSource: String?)
