package android.kien.remedi

import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    private var isDarkMode = false
    fun setDarkMode(isDarkMode: Boolean){
        this@AppViewModel.isDarkMode = isDarkMode
    }
    fun getDarkMode(): Boolean{
        return isDarkMode
    }
}