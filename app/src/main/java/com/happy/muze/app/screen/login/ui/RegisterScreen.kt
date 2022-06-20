package com.happy.muze.app.screen.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.happy.muze.app.screen.Screen
import com.happy.muze.app.screen.login.ui.baseitem.LoginBaseItem


@Composable
fun RegisterScreen(navController: NavController) {
    val image = Icons.Filled.Login
    val passwordVector = Icons.Filled.Password
    val confirmPasswordValue = remember { mutableStateOf("") }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {

            Image(
                imageVector = image, contentDescription = "Login main image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(0.8f)

            )

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Sign Up",
                style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 2.sp),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                LoginBaseItem()

                OutlinedTextField(
                    value = confirmPasswordValue.value,
                    onValueChange = { confirmPasswordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                        }) {
                            Icon(
                                imageVector = passwordVector, contentDescription = "Password icon",
                                tint = if (confirmPasswordVisibility.value) Color.White else Color.Gray
                            )
                        }
                    },
                    label = { Text(text = "Confirm password") },
                    placeholder = { Text(text = "Confirm the password") },
                    singleLine = true,
                    visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)

                )

                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {}, modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(text = "Sign Up", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Login instead", fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate(Screen.LoginScreen.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}
