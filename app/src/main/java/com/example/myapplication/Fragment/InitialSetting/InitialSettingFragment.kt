package com.example.myapplication.Fragment.InitialSetting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Dialog.EmptyErrorDialogFragment
import com.example.myapplication.Fragment.Dialog.MistakeErrorDialogFragment
import com.example.myapplication.Fragment.Home.StudentHomeFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.initial_setting_fragment.*
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.user_id
import kotlinx.android.synthetic.main.login_fragment.view.*
import kotlinx.android.synthetic.main.login_fragment.view.password
import kotlinx.android.synthetic.main.login_fragment.view.user_id

class InitialSettingFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.initial_setting_fragment, container, false)
//        val mainActivity = MainActivity()
//////        mainActivity.throwButton()!!.setOnClickListener(onBackClick)
        var entryButton = view.findViewById<Button>(R.id.entry_button)
       entryButton.setOnClickListener(onEntryClick)

        return view
    }

//    val onBackClick = View.OnClickListener {
//        replaceFragment(LoginFragment())
//    }

    val onEntryClick = View.OnClickListener {
        if (user_id.text.toString() == "" || phone_number.text.toString() == "" || new_password.text.toString() == "" || re_password.text.toString() == "") {
            val emptyError = EmptyErrorDialogFragment()
            emptyError.show(activity!!.supportFragmentManager, "empty")
        } else if (new_password.text.toString() != re_password.text.toString()) {
            val mistakeError = MistakeErrorDialogFragment()
            mistakeError.show(activity!!.supportFragmentManager, "mistake")
        } else {
            replaceFragment(LoginFragment())
        }
    }
}