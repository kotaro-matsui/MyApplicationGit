package com.example.myapplication.Fragment.Lesson

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Context.OCRUtil
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Dialog.ProgressDialog
import com.example.myapplication.Fragment.OCR.OCRFragment
import com.example.myapplication.Model.ListObject
import com.example.myapplication.R
import io.realm.Realm
import kotlin.concurrent.thread

class LessonFragment : BaseFragment() {
    private lateinit var realm: Realm
    private val progressDialog = ProgressDialog.newInstance("文字を読み取っています")

    var lessonName = ""
    var lessonNum = 1

    companion object {
        fun newInstance(lessonName: String, lessonNum: Int): LessonFragment {
            val fragment = LessonFragment()
            fragment.lessonName = lessonName
            fragment.lessonNum = lessonNum
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeHeaderTitle("授業")
        switchBackFragment(this)
        val view = inflater.inflate(R.layout.lesson_fragment, container, false)
        val lessonNameTextView = view.findViewById<TextView>(R.id.lesson_name)
        lessonNameTextView.text = lessonName
        realm = Realm.getDefaultInstance()
        //ここでrealmの中身が無い場合は各コマへのボタンをグレーアウトにする処理にする
        val seatInfo = realm.where(ListObject::class.java).equalTo("id", lessonNum).findFirst()
        val booth = seatInfo?.booth
        val boothTextView = view.findViewById<TextView>(R.id.booth)
        boothTextView.text = booth
        val teacher = seatInfo?.teacher
        val teacherTextView = view.findViewById<TextView>(R.id.teacher)
        teacherTextView.text = teacher
        val student = seatInfo?.student
        val studentTextView = view.findViewById<TextView>(R.id.student)
        studentTextView.text = student
        val subject = seatInfo?.subject
        val subjectTextView = view.findViewById<TextView>(R.id.subject)
        subjectTextView.text = subject
        val qrCodeScannerButton = view.findViewById<Button>(R.id.start_qr_code_scanner)
        qrCodeScannerButton.setOnClickListener(onQrCodeScannerButton)
        return view
    }

    private val onQrCodeScannerButton = View.OnClickListener {

        var ocrUtil: OCRUtil

        progressDialog.show(activity!!.supportFragmentManager,"TAG")

        thread {
            val bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test)
            ocrUtil = OCRUtil(activity!!.applicationContext)
            val copyText = ocrUtil.getString(activity!!.applicationContext, bitmap, "jpnnew")
            progressDialog.dismiss()
            replaceFragment(OCRFragment.newInstance(copyText))
        }

    }

}