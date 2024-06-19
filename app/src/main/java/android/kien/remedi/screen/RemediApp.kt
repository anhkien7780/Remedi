package android.kien.remedi.screen

import android.content.Context
import android.kien.remedi.AppViewModel
import android.kien.remedi.model.Screen
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RemediApp(
    appViewModel: AppViewModel,
    context: Context = LocalContext.current
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(context = context, navController = navController)
        }
        composable(route = Screen.SettingScreen.route) {
            SettingScreen(appViewModel = appViewModel, onBack = { navController.popBackStack() })
        }
        composable(route = Screen.AddMedicineScreen.route) {
            AddMedicineScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}

