package com.example.myapplication.Fragment.ClassroomMap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.R

class ClassroomMapFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeHeaderTitle("教室マップ")
        switchBackButton(this)
        switchMenuButton(this)
        return inflater.inflate(R.layout.classroom_map_fragment, container, false)
    }
}