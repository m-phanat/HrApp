package com.happy.muze.app.navigate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationScreen(val route: String, val title: String, val icon: ImageVector) {
    object HomeScreen : NavigationScreen(
        route = "home_screen",
        title = "Home",
        icon = Icons.Filled.Home
    )

    object ProfileScreen : NavigationScreen(
        route = "profile_screen",
        title = "Profile",
        icon = Icons.Filled.Person
    )

    object SettingsScreen : NavigationScreen(
        route = "settings_screen",
        title = "Settings",
        icon = Icons.Filled.Settings
    )
}
