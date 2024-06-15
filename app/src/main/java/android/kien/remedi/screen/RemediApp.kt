package android.kien.remedi.screen

import android.content.Context
import android.kien.remedi.R
import android.kien.remedi.ui.theme.lightCustomColorScheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RemediApp(
    modifier: Modifier = Modifier, context: Context = LocalContext.current
) {
    val iconButtonColors =
        IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)
    Scaffold(
        containerColor = lightCustomColorScheme.surfaceContainerLow,
        modifier = modifier, topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }, colors = iconButtonColors) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Drawer")
                    }
                }, title = {
                    Text(
                        text = context.getString(R.string.app_name),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }, actions = {
                    IconButton(onClick = { /*TODO*/ }, colors = iconButtonColors) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Truy cập vào tài khoản"
                        )
                    }
                })
        }) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bạn không còn liều thuốc nào để uống hôm nay",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            ElevatedButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Thêm thuốc",
                    modifier = Modifier.padding(end = 5.dp)
                )
                Text(text = "Thêm thuốc", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}


@Preview
@Composable
fun RemediAppPreview() {
    RemediApp()
}

