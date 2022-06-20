package com.happy.muze.app.screen.bottombar

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import com.happy.muze.app.navigate.NavigationHost

@Composable
fun AppScaffold(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController, bottomBarState = bottomBarState)
        },
        scaffoldState = scaffoldState
    ) {
        NavigationHost(navController = navController, bottomBarState = bottomBarState)
    }

}
