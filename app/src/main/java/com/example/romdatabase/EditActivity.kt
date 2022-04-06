package com.example.romdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class EditActivity : AppCompatActivity() {
    private var dbnew : StudentDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        dbnew = StudentDatabase.getInstance(this)

        val getDataStudent = intent.getParcelableExtra<Student>("dataStudent") as Student

        input_nama.setText(getDataStudent.nama)
        input_email.setText(getDataStudent.email)

        btn_update.setOnClickListener {
            getDataStudent.nama = input_nama.text.toString()
            getDataStudent.email = input_email.text.toString()
            GlobalScope.async {
                val perintah = dbnew?.studentDao()?.updateStudent(getDataStudent)
                runOnUiThread{
                    if (perintah != 0 ){
                        Toast.makeText(this@EditActivity, "Data ${getDataStudent.nama} Berhasil terupdate", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@EditActivity, "Data ${getDataStudent.nama} gagal update", Toast.LENGTH_LONG).show()
                    }
                    finish()
                }
            }
        }
    }
}