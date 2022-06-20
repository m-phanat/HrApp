package com.happy.muze.app.screen.bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.happy.muze.app.navigate.NavigationScreen

@Composable
fun BottomBar(navController: NavController, bottomBarState: MutableState<Boolean>) {

    val items = listOf(
        NavigationScreen.HomeScreen,
        NavigationScreen.ProfileScreen,
        NavigationScreen.SettingsScreen,
    )

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                elevation = 5.dp,
                modifier = Modifier.navigationBarsPadding()
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.map {
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = it.icon,
                                contentDescription = it.title
                            )
                        },
                        label = {
                            Text(
                                text = it.title
                            )
                        },
                        selected = currentRoute == it.route,
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(alpha = 0.4f),
                        onClick = {
                            navController.navigate(it.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        },
                    )
                }

            }
        }
    )
}
