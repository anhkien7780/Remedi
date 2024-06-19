package android.kien.remedi.model

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("home_screen")
    data object SettingScreen: Screen("setting_screen")
}