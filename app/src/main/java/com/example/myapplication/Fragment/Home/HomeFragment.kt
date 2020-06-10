package com.example.myapplication.Fragment.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.R

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        val logoutButton = view.findViewById<Button>(R.id.logout)
        logoutButton.setOnClickListener(onLogoutClick)
        return view
    }

    val onLogoutClick = View.OnClickListener {
        replaceFragment(LoginFragment())
    }
}