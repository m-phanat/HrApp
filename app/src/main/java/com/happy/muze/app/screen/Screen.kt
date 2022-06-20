package com.happy.muze.app.screen

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")

    object BottomBar : Screen("bottom_bar")
    object AppScaffold : Screen("app_scaffold")
}
