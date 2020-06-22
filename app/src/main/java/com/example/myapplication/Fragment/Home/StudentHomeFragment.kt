package com.example.myapplication.Fragment.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import com.example.myapplication.Adapter.TimetableAdapter
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.R
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class StudentHomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeTitle("HOME")
        switchBackFragment(this)
        val view = inflater.inflate(R.layout.student_home_fragment, container, false)
        val data = "QRコード" //ここに生徒名をいれてQRコードを作る想定
        val size = 200
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, size, size)
            val imageQr = view.findViewById<ImageView>(R.id.qr_code)
            imageQr.setImageBitmap(bitmap)
        } catch(e: Exception) {

        }

//        val nextTimetableButton = view.findViewById<Button>(R.id.next_timetable_button)
//        nextTimetableButton.setOnClickListener(onNextTimetableClick)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val times = listOf("1時間目 10：00 ～ 10：45", "2時間目 11：00 ～ 11：45", "3時間目 12：00 ～ 12：45", "4時間目 13：00 ～ 13：45", "5時間目 14：00 ～ 14：45",
            "6時間目 15：00 ～ 15：45", "7時間目 16：00 ～ 16：45", "8時間目 17：00 ～ 17：45", "9時間目 18：00 ～ 18：45")
        val booths = listOf("G22", "A1", "G22", "A1", "G22", "A1", "G22", "A1", "G22")
        val subjects = listOf("日本史", "国語", "日本史", "国語", "日本史", "国語", "日本史", "国語", "日本史")
        val teachers = listOf("担当：キング", "担当：板金", "担当：キング", "担当：板金", "担当：キング", "担当：板金", "担当：キング", "担当：板金", "担当：キング")


        val listView = view.findViewById<ListView>(R.id.today_timetable)

        listView.adapter = TimetableAdapter(activity!!.applicationContext, times, booths, subjects, teachers)
    }

//    private val onNextTimetableClick = View.OnClickListener {
//        val user = "student"
//        replaceFragment(NextTimetableFragment.newInstance(user))
//    }

}