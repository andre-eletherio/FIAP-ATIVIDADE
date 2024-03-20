package br.com.edutech.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["email"], unique = true)], tableName = "tb_user")
data class User (
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val email: String,
    val password: String
)