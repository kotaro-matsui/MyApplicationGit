package com.example.myapplication.Fragment.Login

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Dialog.EmptyErrorDialogFragment
import com.example.myapplication.Fragment.Dialog.InformationDialogFragment
import com.example.myapplication.Fragment.Dialog.MistakeErrorDialogFragment
import com.example.myapplication.Fragment.Home.StudentHomeFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.Fragment.InitialSetting.InitialSettingFragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        var initialSetting = view.findViewById<TextView>(R.id.initial_setting)
        initialSetting.setOnClickListener(onInitialSettingClick)
        var studentLoginButton = view.findViewById<Button>(R.id.login)
        studentLoginButton.setOnClickListener(onLoginClick)
        var forgetPasswordText = view.findViewById<TextView>(R.id.forget_password)
        forgetPasswordText.setOnClickListener(onForgetPasswordClick)
        return view
    }

    val onInitialSettingClick = View.OnClickListener {
        replaceFragment(InitialSettingFragment())
    }

    val onLoginClick = View.OnClickListener {

        if (user_id.text.toString() == "" || password.text.toString() == "") {
            val emptyError = EmptyErrorDialogFragment()
            emptyError.show(activity!!.supportFragmentManager, "empty")
        } else {
            when (user_id.text.toString()) {
                "0" -> {
                    replaceFragment(TeacherHomeFragment())
                }
                "1" -> {
                    replaceFragment(StudentHomeFragment())
                }
                else -> {
                    val mistakeError = MistakeErrorDialogFragment()
                    mistakeError.show(activity!!.supportFragmentManager, "mistake")
                }
            }
        }
    }

    val onForgetPasswordClick = View.OnClickListener {
        val dialog = InformationDialogFragment()
        dialog.show(activity!!.supportFragmentManager, "info")
    }


}