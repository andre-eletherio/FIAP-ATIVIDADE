package br.com.edutech.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.edutech.database.dao.SubjectDao
import br.com.edutech.model.Subject

@Database(entities = [Subject::class], version = 1)
abstract class SubjectDb: RoomDatabase() {

    abstract  fun subjectDao(): SubjectDao

    companion object {

        private lateinit var instance: SubjectDb

        fun getDatabase(context: Context): SubjectDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        SubjectDb::class.java,
                        "subject_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }

}