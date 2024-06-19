package android.kien.remedi.screen

import android.content.Context
import android.kien.remedi.R
import android.kien.remedi.model.Screen
import android.kien.remedi.ui.theme.RemediTheme
import android.kien.remedi.ui.theme.lightCustomColorScheme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    context: Context,
    navController: NavController
) {
    val iconButtonColors =
        IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceContainerLow),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp)
                    )
                    .width(304.dp)
            ) {
                DrawerHead(name = null)
                Text(
                    text = "Cá nhân",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(start = 10.dp, top = 18.dp, bottom = 18.dp)
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.dot_icon),
                            contentDescription = "Dot icon"
                        )
                    },
                    label = {
                        Text(
                            text = "Cài đặt tài khoản",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    },
                    onClick = {

                    },
                    selected = false
                )
                Text(
                    text = "Ứng dụng",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(start = 10.dp, top = 18.dp, bottom = 18.dp)
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.dot_icon),
                            contentDescription = "Dot icon"
                        )
                    },
                    label = {
                        Text(
                            text = "Cài đặt chung",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    },
                    onClick = {
                        navController.navigate(route = Screen.SettingScreen.route)
                    },
                    selected = false
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.dot_icon),
                            contentDescription = "Dot icon"
                        )
                    },
                    label = {
                        Text(
                            text = "Đánh giá ứng dụng",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    },
                    onClick = {

                    },
                    selected = false
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.dot_icon),
                            contentDescription = "Dot icon"
                        )
                    },
                    label = {
                        Text(
                            text = "Phản hồi ứng ",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    },
                    onClick = {

                    },
                    selected = false
                )
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 40.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .background(
                                color = MaterialTheme.colorScheme.errorContainer,
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.logout_icon),
                                contentDescription = "Log out",
                                tint = MaterialTheme.colorScheme.error
                            )
                            Text(
                                text = "Đăng xuất",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        },
    ) {
        Scaffold(
            containerColor = lightCustomColorScheme.surfaceContainerLow,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background), topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }, colors = iconButtonColors) {
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
                        IconButton(onClick = {

                        }, colors = iconButtonColors) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Truy cập vào tài khoản"
                            )
                        }
                    })
            }) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background ),
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
}

@Composable
fun DrawerHead(name: String?) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Spacer(modifier = Modifier.padding(start = 10.dp))
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Account Icon",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(40.dp)
        )
        when {
            name == null -> {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Đăng nhập",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
            }

            else -> {
                Text(
                    text = "Xin chào $name",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    RemediTheme {
        HomeScreen(context = LocalContext.current, navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerHeadPreview() {
    DrawerHead(name = "Nguyen Van Kien")
}