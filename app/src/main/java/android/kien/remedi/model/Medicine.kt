package android.kien.remedi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicine(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val imageUri: String,
    val medicineName: String,
    val dayTakeMedicineIsDefined: Boolean,
    val dayTakeMedicine: Int
)