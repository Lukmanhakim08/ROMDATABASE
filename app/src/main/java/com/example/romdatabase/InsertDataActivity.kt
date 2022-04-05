package com.example.romdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insert_data.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class InsertDataActivity : AppCompatActivity() {

    var dbstudent : StudentDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        dbstudent = StudentDatabase.getInstance(this)

        btn_save.setOnClickListener {
            GlobalScope.async {
                val nama = edt_nama.text.toString()
                val email = edt_email.text.toString()

                val hasil = dbstudent?.studentDao()?.insertStudent(Student(null, nama, email))

                runOnUiThread {
                    if (hasil != 0.toLong()){
                        Toast.makeText(this@InsertDataActivity, "Success", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@InsertDataActivity, "Failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}