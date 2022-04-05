package com.example.romdatabase

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

// yang kdua membuat dataclass Student

//Menandai bahwa class ini adalah sebuah Entity yang akan diproses menjadi sebuah Table
@Entity
//Object class agar bisa mengirim melalui intent
@Parcelize
data class Student (
    //Menandai atribut ini sebagai Primary Key pada Table.
    @PrimaryKey(autoGenerate = true)
    var id : Int?,

    //Colum Info yaitu Menamaan Kolom pada table
    @ColumnInfo (name = "nama")
    var nama : String,

    @ColumnInfo (name = "email")
    var email : String
) : Parcelable
