package br.com.edutech.database.repository

import android.content.Context
import br.com.edutech.database.dao.UserDb
import br.com.edutech.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(context: Context) {

    var db = UserDb.getDatabase(context).userDao()

    fun create(user: User): Long {
        return db.create(user = user)
    }

    fun getUser(email: String, password: String): User? {
        return db.getUser(email, password)
    }
}