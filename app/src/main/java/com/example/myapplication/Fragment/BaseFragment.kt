package com.example.myapplication.Fragment

import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity

open class BaseFragment: Fragment() {

    fun replaceFragment(fragment: Fragment) {
//        // activity→今どのアクティビティに乗っているかをとってきて、そのスーパークラスを示す
//        //　明示しておく必要があるので、キャスト（as）でそれを記載
        val main = activity as MainActivity
        main.replaceFragment(fragment)
    }

    fun switchBackFragment(fragment: Fragment) {
        val main = activity as MainActivity
        main.switchBackButton(fragment)
    }

    fun changeHeaderTitle(headerTitle: String) {
        val main = activity as MainActivity
        main.changeHeaderTitle(headerTitle)
    }

}