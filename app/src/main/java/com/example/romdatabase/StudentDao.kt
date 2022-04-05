package com.example.romdatabase

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface StudentDao{
    @Insert()
    fun insertStudent(student: Student):Long
}
