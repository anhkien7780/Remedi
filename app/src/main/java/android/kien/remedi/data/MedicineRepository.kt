package android.kien.remedi.data

import android.kien.remedi.model.Medicine
import kotlinx.coroutines.flow.Flow

interface MedicineRepository {
    fun getAllMedicineStream(): Flow<List<Medicine>>

    fun getMedicineStream(id: Int): Flow<Medicine>

    suspend fun insertMedicine(medicine: Medicine)
    suspend fun updateMedicine(medicine: Medicine)
    suspend fun deleteMedicine(medicine: Medicine)

}