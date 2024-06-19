package android.kien.remedi.screen

import android.kien.remedi.AppViewModel
import android.kien.remedi.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    appViewModel: AppViewModel,
    onBack: () -> Unit
) {
    var isDarkMode by remember {
        mutableStateOf(appViewModel.mode)
    }
    val settingRowItemHeight = 72.dp
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back button",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = {
                    Text(
                        text = "Cài đặt chung",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LabelListSettingRow(label = "Giao diện")
            SettingRowItem(
                rowHeight = settingRowItemHeight,
                iconPainterResource = R.drawable.mode_night,
                iconContentDescription = "Mode night",
                label = "Chế độ tối",
                actions = {
                    Switch(
                        checked = isDarkMode,
                        onCheckedChange = {
                            isDarkMode = !isDarkMode
                            appViewModel.setDarkMode(isDarkMode)
                        },
                    )
                }
            )
            Spacer(modifier = Modifier.padding(7.dp))
            LabelListSettingRow(label = "Âm thanh")
            SettingRowItem(
                rowHeight = settingRowItemHeight,
                iconPainterResource = R.drawable.music_note,
                iconContentDescription = "Music note",
                label = "Chọn âm thanh",
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right),
                        contentDescription = "Alarm ringtone selection"
                    )
                },
                enableClickable = true,
                onClick = {

                }
            )
            Spacer(modifier = Modifier.padding(7.dp))
            LabelListSettingRow(label = "Ứng dụng ")
            SettingRowItem(
                rowHeight = settingRowItemHeight,
                iconPainterResource = R.drawable.info_icon,
                iconContentDescription = "Icon info",
                label = "Thông tin ứng dụng",
                enableClickable = true,
                onClick = {

                }
            )
        }
    }
}

@Composable
fun LabelListSettingRow(
    label: String
) {
    Text(
        text = label,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)
    )
}

@Composable
fun SettingRowItem(
    rowHeight: Dp,
    iconPainterResource: Int,
    iconContentDescription: String,
    label: String,
    actions: @Composable () -> Unit = {},
    enableClickable: Boolean = false,
    onClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = enableClickable) { onClick() }
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .height(rowHeight)
            .padding(start = 15.dp, end = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = iconPainterResource),
            contentDescription = iconContentDescription,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.weight(1f)
        )
        actions()
    }
}

@Preview
@Composable
fun SettingScreenPreview() {
    SettingScreen(appViewModel = viewModel()) {}
}