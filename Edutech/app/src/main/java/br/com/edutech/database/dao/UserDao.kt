package br.com.edutech.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.edutech.model.User

@Dao
interface UserDao {

    @Insert
    fun create(user: User): Long

    @Query("SELECT * FROM tb_user WHERE email = :email and password = :password")
    fun getUser(email: String, password: String): User?
}