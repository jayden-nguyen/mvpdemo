package com.example.android.mvprecyclerviewdemo.adapter

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.mvprecyclerviewdemo.R
import com.example.android.mvprecyclerviewdemo.activity.RecyclerItemClickListener
import com.example.android.mvprecyclerviewdemo.model.Notice
import kotlinx.android.synthetic.main.single_view_row.view.*

class NoticeAdapter(noticeArrayList: ArrayList<Notice>, recyclerItemClickListener: RecyclerItemClickListener): RecyclerView.Adapter<NoticeAdapter.EmployeeViewHolder>() {
    val dataList = noticeArrayList
    val recyclerItemClickListener = recyclerItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_view_row, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.itemView.txtNoticeTitle.text = dataList[position].title
        holder.itemView.txtNoticeBrief.text = dataList[position].brief
        holder.itemView.txtNoticeFilePath.text = dataList[position].fileSource
        holder.itemView.setOnClickListener {
            recyclerItemClickListener.onItemClick(dataList[position])
        }
    }

    class EmployeeViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    }

}
