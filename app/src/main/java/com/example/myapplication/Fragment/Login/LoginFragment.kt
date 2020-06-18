package com.example.myapplication.Fragment.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Dialog.ConfirmationDialogFragment
import com.example.myapplication.Fragment.Dialog.ErrorDialogFragment
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
        var loginButton = view.findViewById<Button>(R.id.login)
        loginButton.setOnClickListener(onLoginClick)
        var forgetPasswordText = view.findViewById<TextView>(R.id.forget_password)
        forgetPasswordText.setOnClickListener(onForgetPasswordClick)
        return view
    }

    val onInitialSettingClick = View.OnClickListener {
        transitionPage(InitialSettingFragment())
        changeTitle("初回設定")
    }

    val onLoginClick = View.OnClickListener {
        if (user_id.text.toString() == "" || password.text.toString() == "") {
            val emptyError = ErrorDialogFragment.newInstance("入力エラー", "IDとパスワードは必ず入力して下さい")
            emptyError.show(activity!!.supportFragmentManager, "empty")
        } else {
            when (user_id.text.toString()) {
                "0" -> {
                    transitionPage(TeacherHomeFragment())
                    changeTitle("HOME")
                }
                "1" -> {
                    transitionPage(StudentHomeFragment())
                    changeTitle("HOME")
                }
                else -> {
                    val mistakeError = ErrorDialogFragment.newInstance("入力エラー", "IDは0（講師用）か1（生徒用）で入力して下さい")
                    mistakeError.show(activity!!.supportFragmentManager, "mistake")
                }
            }
        }
    }

    val onForgetPasswordClick = View.OnClickListener {
        val infoDialog = ErrorDialogFragment.newInstance("教室の先生に相談しましょう", "総合連絡先：XXX-XXXX-XXX")
        infoDialog.show(activity!!.supportFragmentManager, "info")
    }


}