package com.example.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.model.Todo

/**
 * Created by rajeshkumar07 on 06-02-2020.
 */
class MainAdapter(private val contex : Context, private var listItem: List<Todo>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private val mContext = contex
    private var mList = listItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view  =
            LayoutInflater.from(mContext).inflate(R.layout.row_recyclerview, parent, false);
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = mList[position]
        holder.userId.text = item.userId.toString()
        holder.id.text = item.id.toString()
        holder.title.text = item.title
        holder.completed.text = item.completed.toString()
    }
    /**
     * Created by : rajeshkumar07
     * Created Date/Time : 06-02-2020 16:40
     * Description : This method is use to reflect the adapter item
     */
    fun update(list : List<Todo>){
        mList = list
        notifyDataSetChanged()
    }
    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userId : TextView = view.findViewById(R.id.tvUserId)
        val id : TextView = view.findViewById(R.id.tvId)
        val title : TextView = view.findViewById(R.id.tvTitle)
        val completed : TextView = view.findViewById(R.id.tvCompleted)
    }
}