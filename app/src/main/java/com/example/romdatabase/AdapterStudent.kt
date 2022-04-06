package com.example.romdatabase

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_logbook.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AdapterStudent(val listDataStudent : List<Student>) : RecyclerView.Adapter<AdapterStudent.VieHolder>() {

    private var adb : StudentDatabase? = null
    class VieHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterStudent.VieHolder {
       val viewitem = LayoutInflater.from(parent.context).inflate(R.layout.item_logbook, parent, false)
        return VieHolder(viewitem)
    }

    override fun onBindViewHolder(holder: AdapterStudent.VieHolder, position: Int) {
        holder.itemView.text_id.text = listDataStudent[position].id.toString()
        holder.itemView.text_nama.text = listDataStudent[position].nama
        holder.itemView.text_email.text = listDataStudent[position].email

        holder.itemView.btn_hapus.setOnClickListener {
                adb = StudentDatabase.getInstance(it.context)
            AlertDialog.Builder(it.context)
                .setTitle("Hapus Data")
                .setMessage("Yakin Hapus data")
                .setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                    GlobalScope.async {
                        val result = adb?.studentDao()?.deleteStudent(listDataStudent[position])
                        (holder.itemView.context as MainActivity).runOnUiThread {
                            if (result != 0){
                                Toast.makeText(it.context, "Data ${listDataStudent[position].nama} Berhasil di hapus",
                                    Toast.LENGTH_LONG).show()
                                (holder.itemView.context as MainActivity).getDataStudent()
                            } else {
                                Toast.makeText(it.context, "Data ${listDataStudent[position].nama} Gagal di hapus",
                                    Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }.setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                .show()
        }

        holder.itemView.btn_edit.setOnClickListener {
            val pindah = Intent(it.context, EditActivity::class.java)
            pindah.putExtra("dataStudent", listDataStudent[position])
            it.context.startActivity(pindah)
        }
    }

    override fun getItemCount(): Int {
        return listDataStudent.size
    }
}