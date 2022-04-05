package com.example.romdatabase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

// tahap ketiga membuat membuat DAO (Data Access Object) yang
//akan digunakan untuk mengelola database

@Dao
interface StudentDao {
//    @Query("SELECT * FROM Student")
//    fun getAllStudent(): List<Student>

    //Method insertStudent membutuhkan parameter
    //object dari Student sebagai data yang akan diinput
    //ke dalam Table yang baru diinput
    @Insert()
    fun insertStudent(student: Student):Long

//    @Update
//    fun updateStudent(student: Student):Int
//
//    @Delete
//    fun deleteStudent(student: Student):Int
}