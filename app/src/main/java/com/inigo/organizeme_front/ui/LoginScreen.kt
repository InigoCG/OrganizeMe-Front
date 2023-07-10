package com.inigo.organizeme_front.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.inigo.organizeme_front.R
import com.inigo.organizeme_front.data.auth.AuthResult
import com.inigo.organizeme_front.ui.navigation.AppScreens


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current
    LaunchedEffect(viewModel, context) {
        viewModel.authResults.collect { result ->
            when (result) {
                is AuthResult.Authorized -> {
                    navController.popBackStack()
                    navController.navigate(AppScreens.MainPage.route)
                }
                is AuthResult.Unauthorized -> {
                    Toast.makeText(
                        context,
                        "No está autorizado",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(
                        context,
                        "Ha sucedido un error desconocido",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Application logo"
        )
        Spacer(modifier = Modifier.padding(30.dp))
        TextField(
            value = state.signInUsername,
            onValueChange = {
                viewModel.onEvent(AuthUiEvent.SignInUsernameChanged(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Nombre")
            }
        )
        Spacer(modifier = Modifier.padding(15.dp))
        TextField(
            value = state.signInPassword,
            onValueChange = {
                viewModel.onEvent(AuthUiEvent.SignInPasswordChanged(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Contraseña")
            }
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Row(
            modifier = Modifier.weight(1f, false)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 15.dp)
            ) {
                Divider(color = Color.Black, thickness = 2.dp)
                Spacer(modifier = Modifier.padding(15.dp))
                Row {
                    Text(
                        text = "¿No tienes cuenta?"
                    )
                    TextButton(
                        onClick = { navController.navigate(AppScreens.Register.route) }
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text ="Regístrate",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}