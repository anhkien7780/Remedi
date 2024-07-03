package android.kien.remedi.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Medicine::class,
            parentColumns = ["id"],
            childColumns = ["medicineId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Announcement(
    val medicineId: Int,
    val hour: Int = 0,
    val minute: Int = 0,
    val isRepeated: Boolean = false,
    val monday: Boolean = false,
    val tuesday: Boolean = false,
    val wednesday: Boolean = false,
    val thursday: Boolean = false,
    val friday: Boolean = false,
    val saturday: Boolean = false,
    val sunday: Boolean = false
)
