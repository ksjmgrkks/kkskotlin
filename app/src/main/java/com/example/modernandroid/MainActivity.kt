package com.example.modernandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*


//상속은 생성자 표시'()' 를 무조건 붙이고 인터페이스는 뒤에 '()'를 붙이지 않는다.
// null이 가능한 데이터 타입(String,Bundle,Int 등등) 뒤에는 ?가 붙고,
// 데이터 타입 뒤에 ?가 붙지 않으면 null을 넣을 수 없는 변수구나 라고 생각하면 된다.
// 하지만 ?가 온다면 null 인지 아닌지 반드시 체크해줘야한다.
//class MainActivity : AppCompatActivity(), View.OnClickListener {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//
//    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
//    }
//}
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries()
         .build()

        result_text.text = db.todoDaoKotlin().getAll().toString()

        add_button.setOnClickListener{
            db.todoDaoKotlin().insert(TodoKotlin(todo_edit.text.toString()))

            result_text.text = db.todoDaoKotlin().getAll().toString()
        }
    }


}