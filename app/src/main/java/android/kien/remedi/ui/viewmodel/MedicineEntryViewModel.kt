package android.kien.remedi.ui.viewmodel

data class MedicineDetails(
    val id: Int = 0,
    val userId: Int,
    val imageUri: String,
    val medicineName: String,
    val dayTakeMedicineIsDefined: Boolean,
    val dayTakeMedicine: Int
)