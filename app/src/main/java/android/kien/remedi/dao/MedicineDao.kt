package android.kien.remedi.dao

import android.kien.remedi.model.Medicine
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(medicine: Medicine)

    @Update
    suspend fun update(medicine: Medicine)

    @Delete
    suspend fun delete(medicine: Medicine)

    @Query("Select * from medicine where id = :id")
    fun getMedicine(id: Int): Flow<Medicine>

    @Query("Select * from medicine")
    fun getAllMedicine(): Flow<List<Medicine>>
}