package com.example.freegamesapi.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

val GamepadVector: ImageVector
    get() = ImageVector.Builder(
        name = "Gamepad",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        fill = SolidColor(Color(0xFF0F0F13))
    ) {
        moveTo(21f, 6f)
        horizontalLineTo(3f)
        curveTo(1.9f, 6f, 1f, 6.9f, 1f, 8f)
        verticalLineTo(16f)
        curveTo(1f, 17.1f, 1.9f, 18f, 3f, 18f)
        horizontalLineTo(21f)
        curveTo(22.1f, 18f, 23f, 17.1f, 23f, 16f)
        verticalLineTo(8f)
        curveTo(23f, 6.9f, 22.1f, 6f, 21f, 6f)
        moveTo(7f, 14f)
        horizontalLineTo(5f)
        verticalLineTo(12f)
        horizontalLineTo(7f)
        verticalLineTo(14f)
        moveTo(7f, 11f)
        horizontalLineTo(5f)
        verticalLineTo(9f)
        horizontalLineTo(7f)
        verticalLineTo(11f)
        moveTo(10f, 14f)
        horizontalLineTo(8f)
        verticalLineTo(12f)
        horizontalLineTo(10f)
        verticalLineTo(14f)
        moveTo(10f, 11f)
        horizontalLineTo(8f)
        verticalLineTo(9f)
        horizontalLineTo(10f)
        verticalLineTo(11f)
        moveTo(16f, 15f)
        horizontalLineTo(14f)
        verticalLineTo(13f)
        horizontalLineTo(16f)
        verticalLineTo(15f)
        moveTo(19f, 12f)
        horizontalLineTo(17f)
        verticalLineTo(10f)
        horizontalLineTo(19f)
        verticalLineTo(12f)
    }.build()

@Composable
fun LoginView(
    viewModel: LoginViewModel = viewModel(),
    onLoginSuccess: () -> Unit
) {
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()

    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn) {
            onLoginSuccess()
        }
    }

    val backgroundColor = Color(0xFF0F0F13)
    val cardColor = Color(0xFF181820)
    val primaryPurple = Color(0xFFC4B5FD)
    val textColor = Color.White
    val mutedTextColor = Color(0xFF9CA3AF)
    val fieldBackground = Color(0xFF22222D)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 480.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top small icon badge
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(primaryPurple),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = GamepadVector,
                    contentDescription = "Game Icon",
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Title
            Text(
                text = "Iniciar sesión",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = "Accede para descubrir juegos gratuitos y guardar tus favoritos.",
                fontSize = 14.sp,
                color = mutedTextColor,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Card container
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                color = cardColor
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    // Email Field
                    Text(
                        text = "Correo electrónico",
                        fontSize = 12.sp,
                        color = primaryPurple,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    OutlinedTextField(
                        value = viewModel.email,
                        onValueChange = { viewModel.onEmailChange(it) },
                        placeholder = { Text("nombre@correo.com", color = mutedTextColor) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = fieldBackground,
                            unfocusedContainerColor = fieldBackground,
                            disabledContainerColor = fieldBackground,
                            focusedBorderColor = primaryPurple,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = textColor,
                            unfocusedTextColor = textColor
                        ),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Password Field
                    Text(
                        text = "Contraseña",
                        fontSize = 12.sp,
                        color = primaryPurple,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    OutlinedTextField(
                        value = viewModel.password,
                        onValueChange = { viewModel.onPasswordChange(it) },
                        placeholder = { Text("Escribe cualquier contraseña", color = mutedTextColor) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = fieldBackground,
                            unfocusedContainerColor = fieldBackground,
                            disabledContainerColor = fieldBackground,
                            focusedBorderColor = primaryPurple,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = textColor,
                            unfocusedTextColor = textColor
                        ),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Login Button
                    Button(
                        onClick = { viewModel.login() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primaryPurple,
                            contentColor = Color(0xFF0F0F13)
                        )
                    ) {
                        Text(
                            text = "Iniciar sesión",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Footer
            Text(
                text = "FreeGames Finder · Juegos gratuitos para PC",
                fontSize = 12.sp,
                color = mutedTextColor
            )
        }
    }
}
