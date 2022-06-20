package com.happy.muze.app.navigate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.happy.muze.app.screen.bottombar.SettingsScreen
import com.happy.muze.app.screen.bottombar.HomeScreen
import com.happy.muze.app.screen.bottombar.HomeViewModel
import com.happy.muze.app.screen.bottombar.ProfileScreen

@Composable
fun NavigationHost(navController: NavController, bottomBarState: MutableState<Boolean>) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = NavigationScreen.HomeScreen.route
    ) {
        composable(NavigationScreen.HomeScreen.route) {
            bottomBarState.value = true
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController, homeViewModel)
        }
        composable(NavigationScreen.ProfileScreen.route) {
            bottomBarState.value = true
            ProfileScreen()
        }
        composable(NavigationScreen.SettingsScreen.route) {
            bottomBarState.value = false
            SettingsScreen()
        }
    }
}

