package android.kien.remedi.screen

import android.kien.remedi.R
import android.kien.remedi.ui.theme.RemediTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAnnouncementScreen(
    onBack: () -> Unit
) {
    var note by remember {
        mutableStateOf("")
    }
    var hour by remember {
        mutableIntStateOf(0)
    }
    var minute by remember {
        mutableIntStateOf(0)
    }
    var switched by remember {
        mutableStateOf(false)
    }
    val daysInWeek = remember {
        mutableStateListOf(*List(7) { false }.toTypedArray())
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Thêm thông báo",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }, navigationIcon = {
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .padding(paddingValues)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(if(!switched) 0.8f else 0.65f)
            ) {
                TimePicker(
                    label = "Nhập thời gian",
                    onHourChange = { hour = it },
                    onMinuteChange = { minute = it })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Lặp lại mỗi ngày",
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Switch(checked = switched, onCheckedChange = { switched = !switched })
                }
                when {
                    !switched -> Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(28.dp))
                            .background(color = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 10.dp)
                        ) {
                            LabelCheckBox(label = "Thứ 2", onCheckedChange = {
                                daysInWeek[0] = true
                            })
                            LabelCheckBox(label = "Thứ 3", onCheckedChange = {
                                daysInWeek[1] = true
                            })
                            LabelCheckBox(label = "Thứ 4", onCheckedChange = {
                                daysInWeek[2] = true
                            })
                            LabelCheckBox(label = "Thứ 5", onCheckedChange = {
                                daysInWeek[3] = true
                            })
                            LabelCheckBox(label = "Thứ 6", onCheckedChange = {
                                daysInWeek[4] = true
                            })
                            LabelCheckBox(label = "Thứ 7", onCheckedChange = {
                                daysInWeek[5] = true
                            })
                            LabelCheckBox(label = "Chủ nhật", onCheckedChange = {
                                daysInWeek[6] = true
                            })
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(175.dp)
                        .clip(RoundedCornerShape(28.dp))
                        .background(color = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Chú thích",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(top = 9.dp, start = 30.dp)
                        )
                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant,
                            modifier = Modifier.padding(horizontal = 30.dp)
                        )
                        TextField(
                            value = note,
                            onValueChange = { note = it },
                            maxLines = Int.MAX_VALUE,
                            colors = TextFieldDefaults.colors(
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .weight(1f)
                        )
                    }
                }
            }
            ElevatedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp)
                    .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
            ) {
                Text(
                    text = "Lưu",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun TimePicker(
    label: String = "Enter time",
    onHourChange: (Int) -> Unit,
    onMinuteChange: (Int) -> Unit,
    enableTimePickerActionButton: Boolean = true,
) {
    var hour by remember {
        mutableIntStateOf(0)
    }
    var minute by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier
            .size(width = 380.dp, height = 240.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(color = MaterialTheme.colorScheme.surfaceContainerHighest)

    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 20.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TimeInput(
                label = "Giờ",
                onInputValueChange = {
                    hour = it
                    onHourChange(hour)
                },
                timeMode = TimeMode.Hour
            )
            Text(text = ":", style = MaterialTheme.typography.displayLarge)
            TimeInput(
                label = "Phút",
                onInputValueChange = {
                    minute = it
                    onMinuteChange(minute)
                },
                timeMode = TimeMode.Minute
            )
        }
        when {
            enableTimePickerActionButton -> {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = {
                        },
                        modifier = Modifier.size(70.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.time_selection_icon),
                            contentDescription = "Time selection button",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                }
            }
        }
    }
}

sealed class TimeMode {
    data object Hour : TimeMode()
    data object Minute : TimeMode()
}

@Composable
fun TimeInput(label: String, onInputValueChange: (Int) -> Unit, timeMode: TimeMode) {
    var inputValue by remember {
        mutableStateOf("00")
    }
    OutlinedTextField(
        value = inputValue,
        onValueChange = {
            if (it.isEmpty()) {
                inputValue = ""
                onInputValueChange(0)
            } else {
                when (timeMode) {
                    TimeMode.Hour -> {
                        if (it.toInt() in (0..23)) {
                            inputValue = it
                            onInputValueChange(inputValue.toInt())
                        }
                    }

                    TimeMode.Minute -> {
                        if (it.toInt() in (0..59)) {
                            inputValue = it
                            onInputValueChange(inputValue.toInt())
                        }
                    }
                }
            }
        },
        textStyle = MaterialTheme.typography.displayMedium.copy(
            textAlign = TextAlign.Center
        ),
        supportingText = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface
        ),
        modifier = Modifier
            .size(width = 154.dp, height = 95.dp)
            .onFocusChanged { focusState ->
                if (!focusState.isFocused) {
                    when (inputValue.length) {
                        0 -> inputValue = "00"
                        1 -> inputValue = "0$inputValue"
                    }
                }
            },
    )
}

@Composable
fun LabelCheckBox(
    label: String,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        var checked by remember {
            mutableStateOf(false)
        }
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Checkbox(checked = checked, onCheckedChange = {
            checked = it
            onCheckedChange(checked)
        })
    }
}

@Preview
@Composable
fun AddAnnouncementScreenPreview() {
    RemediTheme {
        AddAnnouncementScreen(onBack = {})
    }
}

@Preview
@Composable
fun TimePickerPreView() {
    RemediTheme {
        TimePicker(
            "Nhập thời gian",
            onHourChange = {},
            onMinuteChange = {},
            enableTimePickerActionButton = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimeInputPreview() {
    RemediTheme {
        TimeInput(label = "Hour", onInputValueChange = {}, timeMode = TimeMode.Minute)
    }
}

@Preview(showBackground = true)
@Composable
fun LabelCheckBoxPreview() {
    RemediTheme {
        LabelCheckBox(label = " Thứ 2", onCheckedChange = {})
    }
}

