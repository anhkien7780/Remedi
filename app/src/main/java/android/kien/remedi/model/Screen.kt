package android.kien.remedi.model

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("home_screen")
    data object SettingScreen: Screen("setting_screen")
    data object AddMedicineScreen: Screen("add_medicine_screen")
    data object AddAnnouncementScreen: Screen("add_announcement_screen")
}