package android.kien.remedi.data

import android.kien.remedi.dao.MedicineDao
import android.kien.remedi.model.Medicine
import kotlinx.coroutines.flow.Flow

class OfflineMedicineRepository(
    private val medicineDao: MedicineDao
) : MedicineRepository {
    override fun getAllMedicineStream(): Flow<List<Medicine>> = medicineDao.getAllMedicine()

    override fun getMedicineStream(id: Int): Flow<Medicine> = medicineDao.getMedicine(id)

    override suspend fun insertMedicine(medicine: Medicine) = medicineDao.insert(medicine)

    override suspend fun updateMedicine(medicine: Medicine) = medicineDao.update(medicine)

    override suspend fun deleteMedicine(medicine: Medicine) = medicineDao.delete(medicine)

}