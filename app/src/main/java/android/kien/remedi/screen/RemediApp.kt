package android.kien.remedi.screen

import android.content.Context
import android.kien.remedi.AppViewModel
import android.kien.remedi.data.AppDatabase
import android.kien.remedi.model.Screen
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room

@Composable
fun RemediApp(
    appViewModel: AppViewModel,
    context: Context = LocalContext.current,
    navController: NavHostController = rememberNavController()
) {
    val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "remedi-database"
    ).build()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(context = context, navController = navController)
        }
        composable(route = Screen.SettingScreen.route) {
            SettingScreen(appViewModel = appViewModel, onBack = { navController.popBackStack() })
        }
        composable(route = Screen.AddMedicineScreen.route) {
            AddMedicineScreen(
                onBack = { navController.popBackStack() },
                onNavToAddAnnouncementScreen = { navController.navigate(route = Screen.AddAnnouncementScreen.route) }
            )
        }
        composable(route = Screen.AddAnnouncementScreen.route) {
            AddAnnouncementScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}

