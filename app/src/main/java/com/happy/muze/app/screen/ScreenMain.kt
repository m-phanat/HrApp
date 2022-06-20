package com.happy.muze.app.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.happy.muze.app.screen.bottombar.AppScaffold
import com.happy.muze.app.screen.login.ui.LoginScreen
import com.happy.muze.app.screen.login.ui.LoginViewModel
import com.happy.muze.app.screen.login.ui.RegisterScreen

@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    val navBarNavController = rememberNavController()

    val loginViewModel = hiltViewModel<LoginViewModel>()

    val startDestination = if (loginViewModel.isLoggedIn())
        Screen.AppScaffold.route
    else
        Screen.LoginScreen.route

    NavHost(navController = navController, startDestination = startDestination) {
        composable(
            route = Screen.LoginScreen.route,
            content = {
                LoginScreen(navController = navController, loginViewModel)
            })
        composable(
            route = Screen.RegisterScreen.route,
            content = { RegisterScreen(navController = navController) })
        composable(
            route = Screen.AppScaffold.route,
            content = {
                AppScaffold(navController = navBarNavController)
            })
    }
}
