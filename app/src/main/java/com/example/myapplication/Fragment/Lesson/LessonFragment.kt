package com.example.myapplication.Fragment.Lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Context.OCRUtil
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.Fragment.OCR.OCRFragment
import com.example.myapplication.Model.ListObject
import com.example.myapplication.R
import com.google.zxing.integration.android.IntentIntegrator
import io.realm.Realm

class LessonFragment : BaseFragment() {
    private lateinit var realm: Realm

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
        val view = inflater.inflate(R.layout.lesson_fragment, container, false)
        var lessonNameTextView = view.findViewById<TextView>(R.id.lesson_name)
        lessonNameTextView.text = lessonName
        realm = Realm.getDefaultInstance()
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
        var teacherHomeButton = view.findViewById<Button>(R.id.teacher_home_button)
        teacherHomeButton.setOnClickListener(onTeacherHomeClick)
        var qrCodeScannerButton = view.findViewById<Button>(R.id.start_qr_code_scanner)
        qrCodeScannerButton.setOnClickListener(onQrCodeScannerButton)
        return view
    }

    val onTeacherHomeClick = View.OnClickListener {
        replaceFragment(TeacherHomeFragment())
    }

    val onQrCodeScannerButton = View.OnClickListener {
        replaceFragment(OCRFragment())
    }

}