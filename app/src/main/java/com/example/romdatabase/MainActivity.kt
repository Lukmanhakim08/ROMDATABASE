package com.example.romdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var nDbnew : StudentDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nDbnew = StudentDatabase.getInstance(this)

        btn_add.setOnClickListener {
            val pindah = Intent(this, InsertDataActivity::class.java)
            startActivity(pindah)
        }

        getDataStudent()
    }

    fun getDataStudent(){
        rv_student.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        GlobalScope.launch {
            val listdata = nDbnew?.studentDao()?.getAllStudent()
            runOnUiThread {
                listdata.let {
                    val adapt = AdapterStudent(it!!)
                    rv_student.adapter = adapt
                }
            }
        }
    }
}