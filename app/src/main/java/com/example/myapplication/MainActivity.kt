package com.example.myapplication


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.Fragment.Dialog.MenuDialogFragment
import com.example.myapplication.Fragment.Home.StudentHomeFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.Fragment.InitialSetting.InitialSettingFragment
import com.example.myapplication.Fragment.Lesson.LessonFragment
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
    private var menuButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //keyを設定
        val ids =  arrayOf(1, 2, 3, 4,5,6,7)
        //initしたインスタンスをとってくる
        realm = Realm.getDefaultInstance()
        // トランザクションして登録
        try {
            realm.executeTransaction { realm ->
                val obj1 = realm.createObject(ListObject::class.java, ids[0])
                obj1.booth = "A10"
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
                val obj5 = realm.createObject(ListObject::class.java, ids[4])
                obj5.booth = "A2"
                obj5.teacher = "明石"
                obj5.student = "渕田"
                obj5.subject = "物理"

            }
        } catch (e: Exception) {
            println("exceptionエラー:" + e.message)
        } catch (r: RuntimeException) {
            println("runtime exceptionエラー:" + r.message)
        }

        val backButton = findViewById<Button>(R.id.back_fragment)
        backButton.visibility = View.INVISIBLE
        backButton.setOnClickListener(onBackView)
        this.backButton = backButton

        val menuButton = findViewById<Button>(R.id.menu_fragment)
        menuButton.visibility = View.INVISIBLE
        menuButton.setOnClickListener(onMenuView)
        this.menuButton = menuButton

        val headerTitle = findViewById<TextView>(R.id.header)
        this.headerTitle = headerTitle

        replaceFragment(LoginFragment())
    }

    override fun onDestroy() {
       super.onDestroy()
       realm.close()
   }

    // 以下、ページ遷移に関するメソッド

    // 画面遷移先を決定するメソッド
    // 引数に設定したフラグメントを呼び出す
    fun replaceFragment(fragment: Fragment) {
        //　遷移先のフラグメントを格納
        this.mFragment = fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_base, fragment)
        fragmentTransaction.commit()
    }

    // 戻るボタンの表示/非表示を切り替えるメソッド
    // 非表示にしたいフラグメントをif文に追加する
    fun switchBackButton(fragment: Fragment) {
        if(fragment is LoginFragment || fragment is TeacherHomeFragment || fragment is StudentHomeFragment) {
            this.backButton?.visibility = View.INVISIBLE
        } else {
            this.backButton?.visibility = View.VISIBLE
        }
    }


    //設定ボタンの表示非表示切り替え
    fun switchMenuButton(fragment: Fragment) {
        if(fragment is LoginFragment) {
            this.menuButton?.visibility = View.INVISIBLE
        } else {
            this.menuButton?.visibility = View.VISIBLE
        }
    }

    // ヘッダーのタイトルを変更するメソッド
    // 引数に表示したい文字列を指定する

    fun changeHeaderTitle(headerTitle: String) {
        this.headerTitle?.text = headerTitle
    }

    // 戻るボタンをクリックしたときの処理内容
    // 画面毎の遷移先を決定する

    private val onBackView = View.OnClickListener {
        when(this.mFragment){
            is InitialSettingFragment -> replaceFragment(LoginFragment())
            is LessonFragment  -> replaceFragment(TeacherHomeFragment())
            is OCRFragment -> replaceFragment(TeacherHomeFragment())
            else -> {

            }
        }
    }

    @SuppressLint("RtlHardcoded")
    private val onMenuView = View.OnClickListener {
        MenuDialogFragment(Gravity.LEFT or Gravity.TOP, 0f, 0f).show(supportFragmentManager, "info")
        //スライドメニューを表示する処理
    }

}
