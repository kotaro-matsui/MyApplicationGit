package com.example.myapplication.Fragment.Login

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Dialog.ErrorDialogFragment
import com.example.myapplication.Fragment.Dialog.MenuDialogFragment
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
        changeHeaderTitle("ログイン")
        switchBackFragment(this)

        val view = inflater.inflate(R.layout.login_fragment, container, false)
        val initialSetting = view.findViewById<TextView>(R.id.initial_setting)
        initialSetting.setOnClickListener(onInitialSettingClick)
        val loginButton = view.findViewById<Button>(R.id.login)
        loginButton.setOnClickListener(onLoginClick)

        // テスト用
        val menuTestButton = view.findViewById<Button>(R.id.menu_test)
        menuTestButton.setOnClickListener(onMenuTestClick)

        val forgetPasswordText = view.findViewById<TextView>(R.id.forget_password)
        forgetPasswordText.setOnClickListener(onForgetPasswordClick)
        return view
    }

    private val onInitialSettingClick = View.OnClickListener {
        replaceFragment(InitialSettingFragment())
    }

    private val onLoginClick = View.OnClickListener {
        if (user_id.text.toString() == "" || password.text.toString() == "") {
            val emptyError = ErrorDialogFragment.newInstance("入力エラー", "IDとパスワードは必ず入力して下さい")
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
                    val mistakeError = ErrorDialogFragment.newInstance("入力エラー", "IDは0（講師用）か1（生徒用）で入力して下さい")
                    mistakeError.show(activity!!.supportFragmentManager, "mistake")
                }
            }
        }
    }

    private val onMenuTestClick = View.OnClickListener {
        MenuDialogFragment(Gravity.LEFT or Gravity.TOP, 0f, 0f).show(activity!!.supportFragmentManager, "info")
    }

    private val onForgetPasswordClick = View.OnClickListener {
        val infoDialog = ErrorDialogFragment.newInstance("教室の先生に相談しましょう", "総合連絡先：XXX-XXXX-XXX")
        infoDialog.show(activity!!.supportFragmentManager, "info")
    }

}