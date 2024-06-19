package android.kien.remedi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    var mode: Boolean by mutableStateOf(false)
        private set
    fun setDarkMode(isDarkMode: Boolean){
        this@AppViewModel.mode = isDarkMode
    }
}