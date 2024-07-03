package android.kien.remedi.data

import android.content.Context
import android.kien.remedi.dao.AnnouncementDao
import android.kien.remedi.dao.MedicineDao
import android.kien.remedi.model.Announcement
import android.kien.remedi.model.Medicine
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Medicine::class, Announcement::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao
    abstract fun announcementDao(): AnnouncementDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDataBase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "remedi_database")
                    .fallbackToDestructiveMigration().build().also { Instance = it }
            }
        }
    }
}
