package com.example.myapplication.Fragment.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.Fragment.NextTimetable.NextTimetableFragment
import com.example.myapplication.R
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class StudentHomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.student_home_fragment, container, false)
        var logoutButton = view.findViewById<Button>(R.id.logout)
        logoutButton.setOnClickListener(onLogoutClick)
        val data = "QRコード" //ここに生徒名をいれてQRコードを作る想定
        val size = 200
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, size, size)
            val imageQr = view.findViewById<ImageView>(R.id.qr_code)
            imageQr.setImageBitmap(bitmap)
        } catch (e: Exception) {

        }
        var nextTimetableButton = view.findViewById<Button>(R.id.next_timetable_button)
        nextTimetableButton.setOnClickListener(onNextTimetableClick)
        return view
    }

    val onLogoutClick = View.OnClickListener {
        replaceFragment(LoginFragment())
    }

    val onNextTimetableClick = View.OnClickListener {
        var user = "student"
        replaceFragment(NextTimetableFragment.newInstance(user))
    }
}