package android.kien.remedi

import android.kien.remedi.screen.RemediApp
import android.kien.remedi.ui.theme.RemediTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemediTheme {
                RemediApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

