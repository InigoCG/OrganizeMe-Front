package com.inigo.organizeme_front.ui.navigation

sealed class AppScreens(val route: String) {
    object Login: AppScreens("login")
    object Register: AppScreens("register")
    object MainPage: AppScreens("main-page")
}
