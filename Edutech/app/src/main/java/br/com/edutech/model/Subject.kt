package br.com.edutech.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject (
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
)