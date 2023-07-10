package com.inigo.organizeme_front.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.inigo.organizeme_front.ui.LoginScreen
import com.inigo.organizeme_front.ui.MainPageScreen
import com.inigo.organizeme_front.ui.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.Login.route
    ) {
        composable(route = AppScreens.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.Register.route) {
            RegisterScreen(navController)
        }
        composable(route = AppScreens.MainPage.route) {
            MainPageScreen(navController)
        }
    }
}