package com.happy.muze.app.screen.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.happy.muze.app.theme.homeBackground

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {

    homeViewModel.getConfig()

    navController.context

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.homeBackground)
    ) {
        Text(
            text = "Home",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp
        )
    }
}
