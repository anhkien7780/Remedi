package android.kien.remedi.data

import android.content.Context

interface AppContainer {
    val medicineRepository: MedicineRepository
}

class AppDataContainer(private var context: Context) : AppContainer{
    override val medicineRepository: MedicineRepository by lazy {
        OfflineMedicineRepository(
            medicineDao = AppDatabase.getDataBase(context = context).medicineDao()
        )
    }
}