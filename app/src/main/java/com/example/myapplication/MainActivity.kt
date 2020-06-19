package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.Fragment.Home.StudentHomeFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.Fragment.InitialSetting.InitialSettingFragment
import com.example.myapplication.Fragment.Lesson.LessonFragment
import com.example.myapplication.Fragment.ListTest.ListTestFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.Fragment.OCR.OCRFragment
import com.example.myapplication.Model.ListObject
import io.realm.Realm

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    //　現在のフラグメントを格納する場所
    private var mFragment: Fragment? = null
    private var backButton: Button? = null
    private var headerTitle: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //keyを設定
        val ids =  arrayOf(1, 2, 3, 4)
        //initしたインスタンスをとってくる
        realm = Realm.getDefaultInstance()

        // トランザクションして登録
        try {
            realm.executeTransaction { realm ->
                val obj1 = realm.createObject(ListObject::class.java, ids[0])
                obj1.booth = "A1"
                obj1.teacher = "松井"
                obj1.student = "実原"
                obj1.subject = "国語"
                val obj2 = realm.createObject(ListObject::class.java, ids[1])
                obj2.booth = "A1"
                obj2.teacher = "松井"
                obj2.student = "渕田"
                obj2.subject = "数学"
                val obj3 = realm.createObject(ListObject::class.java, ids[2])
                obj3.booth = "A1"
                obj3.teacher = "松井"
                obj3.student = "実原"
                obj3.subject = "英語"
                val obj4 = realm.createObject(ListObject::class.java, ids[3])
                obj4.booth = "A1"
                obj4.teacher = "松井"
                obj4.student = "渕田"
                obj4.subject = "物理"
            }
        } catch (e: Exception) {

        } catch (r: RuntimeException) {

        }

        setContentView(R.layout.activity_main)

        val backButton = findViewById<Button>(R.id.back_fragment)
        backButton.visibility = View.INVISIBLE
        backButton.setOnClickListener(onBackView)
        this.backButton = backButton

        val headerTitle = findViewById<TextView>(R.id.header)
        this.headerTitle = headerTitle

        replaceFragment(LoginFragment())
    }

//    override fun onDestroy() {
//       super.onDestroy()

//       realm.close()
//   }

    fun replaceFragment(fragment: Fragment) {
        //　遷移先のフラグメントを格納
        this.mFragment = fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_base, fragment)
        fragmentTransaction.commit()
    }

    fun switchBackButton(fragment: Fragment) {
        if(fragment is LoginFragment) {
            this.backButton?.visibility = View.INVISIBLE
        } else {
            this.backButton?.visibility = View.VISIBLE
        }
    }

    fun changeTitle(headerTitle: String) {
        this.headerTitle?.text = headerTitle
    }

    private val onBackView = View.OnClickListener {
        when(this.mFragment){
            is InitialSettingFragment -> replaceFragment(LoginFragment())
            is ListTestFragment -> replaceFragment(LoginFragment())
            is StudentHomeFragment -> replaceFragment(LoginFragment())
            is TeacherHomeFragment -> replaceFragment(LoginFragment())
            is LessonFragment  -> replaceFragment(TeacherHomeFragment())
            is OCRFragment -> replaceFragment(TeacherHomeFragment())
            else -> {

            }
        }
    }

}
