package com.example.myapplication.Fragment.ListTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.R


class ListTestFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeTitle("リストのテスト")
        switchBackFragment(this)
        return inflater.inflate(R.layout.list_test_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val texts = arrayOf("1時間目 10：00 ～ 10：45", "2時間目 11：00 ～ 11：45", "3時間目 12：00 ～ 12：45", "4時間目 13：00 ～ 13：45", "5時間目 14：00 ～ 14：45",
                            "6時間目 15：00 ～ 15：45", "7時間目 16：00 ～ 16：45", "8時間目 17：00 ～ 17：45", "9時間目 18：00 ～ 18：45")

        val listView = view.findViewById<ListView>(com.example.myapplication.R.id.list_view)

        // simple_list_item_1 は、 もともと用意されている定義済みのレイアウトファイルのID
        val arrayAdapter = ArrayAdapter(activity!!.applicationContext,
            android.R.layout.simple_list_item_1, texts)

        listView.adapter = arrayAdapter
    }
}