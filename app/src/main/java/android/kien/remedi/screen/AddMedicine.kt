package android.kien.remedi.screen

import android.kien.remedi.R
import android.kien.remedi.ui.theme.RemediTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedicineScreen(
    onNavToAddAnnouncementScreen: () -> Unit,
    onBack: () -> Unit
) {
    val imageSize = 374.dp
    var switchChecked by remember {
        mutableStateOf(false)
    }
    var medicineName by remember {
        mutableStateOf("")
    }
    var day by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Thêm thuốc",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back button",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(imageSize)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(color = MaterialTheme.colorScheme.surfaceVariant)
                    .clickable {
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.gallery_add),
                    contentDescription = "Add medicine image",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.padding(bottom = 15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Không xác định ngày uống",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.weight(1f)
                )
                Switch(checked = switchChecked, onCheckedChange = {
                    switchChecked = !switchChecked
                })
            }
            OutlinedTextField(
                value = medicineName, onValueChange = { medicineName = it },
                textStyle = MaterialTheme.typography.bodyLarge,
                label = {
                    Text(
                        text = "Tên thuốc",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
                    )
                },
                placeholder = {
                    Text(
                        text = "Nhập tên thuốc",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            )
            when {
                !switchChecked -> OutlinedTextField(
                    value = day, onValueChange = { day = it },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    label = {
                        Text(
                            text = "Ngày thuốc",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.background(MaterialTheme.colorScheme.surface)
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Nhập số ngày cần uống thuốc",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.secondary,
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                )
            }
            OutlinedButton(
                onClick = { onNavToAddAnnouncementScreen() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add icon",
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Thêm thông báo nhắc uống thuốc",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Row (Modifier.fillMaxHeight().padding(bottom = 20.dp)){
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
                        .align(Alignment.Bottom)
                ) {
                    Text(
                        text = "Lưu",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun AddMedicineScreenPreview() {
    RemediTheme {
        AddMedicineScreen (onNavToAddAnnouncementScreen = {}, onBack = {})
    }
}