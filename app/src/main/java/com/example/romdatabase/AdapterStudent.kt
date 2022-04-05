package com.example.romdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_logbook.view.*

class AdapterStudent(val listDataStudent : List<Student>) : RecyclerView.Adapter<AdapterStudent.VieHolder>() {
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
    }

    override fun getItemCount(): Int {
        return listDataStudent.size
    }
}