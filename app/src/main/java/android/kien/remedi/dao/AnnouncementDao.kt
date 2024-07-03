package android.kien.remedi.dao

import android.kien.remedi.model.Announcement
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AnnouncementDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(announcement: Announcement)

    @Update
    suspend fun update(announcement: Announcement)

    @Delete
    suspend fun delete(announcement: Announcement)

    @Query("select * from Announcement")
    fun getAllAnnouncement(): Flow<List<Announcement>>

    @Query("select * from Announcement where medicineId = :medicineId")
    fun getAnnouncement(medicineId: Int): Flow<Announcement>

}