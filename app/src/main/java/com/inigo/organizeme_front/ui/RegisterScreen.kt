package com.inigo.organizeme_front.ui

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.inigo.organizeme_front.R

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val state = viewModel.state

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
            value = state.signUpUsername,
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
            value = state.signUpPassword,
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
                        text = "¿Ya tienes una cuenta?"
                    )
                    TextButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text ="Inicia sesión",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}