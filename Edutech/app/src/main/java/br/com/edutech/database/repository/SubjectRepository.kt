package br.com.edutech.database.repository

import android.content.Context
import br.com.edutech.database.dao.SubjectDb
import br.com.edutech.model.Subject

class SubjectRepository(context: Context) {

    var db = SubjectDb.getDatabase(context).subjectDao()

    fun create(subject: Subject): Long {
        return db.create(subject = subject)
    }
}