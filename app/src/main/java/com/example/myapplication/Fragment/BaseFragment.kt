package com.example.myapplication.Fragment

import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity

open class BaseFragment : Fragment() {

    fun replaceFragment(fragment: Fragment) {

        val main = activity as MainActivity
        main.replaceFragment(fragment)
    }
}