package com.example.freegamesapi.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freegamesapi.Model.Usuario

@Composable
fun FavoritesView(
    usuario: Usuario
) {
    val backgroundColor = Color(0xFF0F0F13)
    val cardColor = Color(0xFF181820)
    val textColor = Color.White
    val mutedTextColor = Color(0xFF9CA3AF)

    val favoritos = usuario.verFavoritos()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Mis Favoritos",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Tus juegos guardados (${favoritos.size})",
                fontSize = 14.sp,
                color = mutedTextColor
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (favoritos.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No tienes juegos favoritos guardados aún.",
                        color = mutedTextColor,
                        fontSize = 15.sp
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 80.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(favoritos) { juego ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = cardColor)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = juego.nombre, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = textColor)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = juego.descripcion, fontSize = 14.sp, color = mutedTextColor)
                            }
                        }
                    }
                }
            }
        }
    }
}
