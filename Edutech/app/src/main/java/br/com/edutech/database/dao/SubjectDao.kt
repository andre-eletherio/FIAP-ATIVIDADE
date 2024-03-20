package br.com.edutech.database.dao

import androidx.room.Dao
import androidx.room.Insert
import br.com.edutech.model.Subject

@Dao
interface SubjectDao {

    @Insert
    fun create(subject: Subject): Long
}