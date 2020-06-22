package com.example.myapplication.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myapplication.R

class TimetableAdapter(
    //要修正
    private val context : Context,
    private val timeList : List<String>,
    private val boothList : List<String>,
    private val subjectList : List<String>,
    private val teacherList : List<String>
    ) : BaseAdapter() {
    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return boothList.count()
    }

    override fun getItem(position: Int): String {
        return boothList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.timetable_list, parent, false) //表示するレイアウト取得
        view.findViewById<TextView>(R.id.time).text = timeList[position]
        view.findViewById<TextView>(R.id.booth).text = boothList[position]
        view.findViewById<TextView>(R.id.subject).text = subjectList[position]
        view.findViewById<TextView>(R.id.teacher).text = teacherList[position]
        return view
    }
}