package com.example.romdatabase

import androidx.room.*

@Dao
interface StudentDao{
    @Query("SELECT * FROM Student")
    fun getAllStudent(): List<Student>

    @Insert()
    fun insertStudent(student: Student):Long

    @Update
    fun updateStudent(student: Student):Int

    @Delete
    fun deleteStudent(student: Student):Int
}
