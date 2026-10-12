package com.example.freegamesapi.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freegamesapi.Model.Usuario
import com.example.freegamesapi.ui.favorites.FavoritesView
import com.example.freegamesapi.ui.profile.ProfileView

val HomeGamepadVector: ImageVector
    get() = ImageVector.Builder(
        name = "HomeGamepad",
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

val SearchVector: ImageVector
    get() = ImageVector.Builder(
        name = "Search",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M15.5 14h-.79l-.28-.27A6.471 6.471 0 0 0 16 9.5 6.5 6.5 0 1 0 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"),
        fill = SolidColor(Color(0xFF9CA3AF))
    ).build()

val ArrowDownVector: ImageVector
    get() = ImageVector.Builder(
        name = "ArrowDown",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M7.41 8.59L12 13.17l4.59-4.58L18 10l-6 6-6-6z"),
        fill = SolidColor(Color(0xFF9CA3AF))
    ).build()

val ChevronRightVector: ImageVector
    get() = ImageVector.Builder(
        name = "ChevronRight",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"),
        fill = SolidColor(Color(0xFF9CA3AF))
    ).build()

val FavoriteFilledVector: ImageVector
    get() = ImageVector.Builder(
        name = "FavoriteFilled",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"),
        fill = SolidColor(Color(0xFFC4B5FD))
    ).build()

val FavoriteOutlineVector: ImageVector
    get() = ImageVector.Builder(
        name = "FavoriteOutline",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M16.5 3c-1.74 0-3.41.81-4.5 2.09C10.91 3.81 9.24 3 7.5 3 4.42 3 2 5.42 2 8.5c0 3.78 3.4 6.86 8.55 11.54L12 21.35l1.45-1.32C18.6 15.36 22 12.28 22 8.5 22 5.42 19.58 3 16.5 3zm-4.4 15.55l-.1.1-.1-.1C7.14 14.24 4 11.39 4 8.5 4 6.5 5.5 5 7.5 5c1.54 0 3.04.99 3.57 2.36h1.87C13.46 5.99 14.96 5 16.5 5 18.5 5 20 6.5 20 8.5c0 2.89-3.14 5.74-7.9 10.05z"),
        fill = SolidColor(Color.White)
    ).build()

val GridViewVector: ImageVector
    get() = ImageVector.Builder(
        name = "GridView",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M4 11h6V4H4v7zm0 9h6v-7H4v7zm10 0h6v-7h-6v7zm0-16v7h6V4h-6z"),
        fill = SolidColor(Color(0xFFC4B5FD))
    ).build()

val PersonVector: ImageVector
    get() = ImageVector.Builder(
        name = "Person",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z"),
        fill = SolidColor(Color(0xFF9CA3AF))
    ).build()

data class GameItem(
    val title: String,
    val description: String,
    val genre: String,
    val platform: String,
    val publisherTag: String,
    val bannerColor: Color,
    val isFavorite: Boolean
)

@Composable
fun HomeView() {
    var selectedTab by remember { mutableStateOf(0) } // 0: Inicio, 1: Mis Favoritos, 2: Perfil
    val usuario = remember { Usuario(1048, "Alex Lara", "alex.lara@email.com") }

    val backgroundColor = Color(0xFF0F0F13)
    val cardColor = Color(0xFF181820)
    val primaryPurple = Color(0xFFC4B5FD)
    val textColor = Color.White
    val mutedTextColor = Color(0xFF9CA3AF)
    val fieldBackground = Color(0xFF161620)
    val borderDark = Color(0xFF2A2A38)

    val sampleGames = listOf(
        GameItem(
            title = "Overwatch 2",
            description = "A hero-focused first-person team shooter from Blizzard Entertainment.",
            genre = "Shooter",
            platform = "PC (Windows)",
            publisherTag = "OVERWATCH",
            bannerColor = Color(0xFF3B4354),
            isFavorite = true
        ),
        GameItem(
            title = "Lost Ark",
            description = "Embark on an odyssey for the Lost Ark in a vast, vibrant action MMORPG.",
            genre = "MMORPG",
            platform = "PC (Windows)",
            publisherTag = "LOSTARK",
            bannerColor = Color(0xFF4D3B33),
            isFavorite = false
        ),
        GameItem(
            title = "PUBG: BATTLEGROUNDS",
            description = "Land on strategic locations, loot weapons and supplies, and survive to become the last team standing.",
            genre = "Shooter",
            platform = "PC (Windows)",
            publisherTag = "PUBG",
            bannerColor = Color(0xFF2D393D),
            isFavorite = false
        ),
        GameItem(
            title = "Valorant",
            description = "A 5v5 character-based tactical shooter set on the global stage.",
            genre = "Shooter",
            platform = "PC (Windows)",
            publisherTag = "VALORANT",
            bannerColor = Color(0xFF422C33),
            isFavorite = true
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        when (selectedTab) {
            0 -> {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 90.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Top Action Bar
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Left Game Icon Badge
                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(primaryPurple),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = HomeGamepadVector,
                                        contentDescription = "Game Icon",
                                        modifier = Modifier.size(24.dp)
                                    )
                                }

                                // Right Avatar Circle -> Switches to Profile tab
                                Box(
                                    modifier = Modifier
                                        .size(42.dp)
                                        .clip(CircleShape)
                                        .background(primaryPurple)
                                        .clickable { selectedTab = 2 },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "AL",
                                        color = Color(0xFF0F0F13),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }

                        // Header Section
                        item {
                            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                                Text(
                                    text = "Juegos gratuitos",
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = textColor
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Encuentra juegos free-to-play para PC.",
                                    fontSize = 15.sp,
                                    color = mutedTextColor
                                )
                            }
                        }

                        // Filter Controls
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                                // Search Field
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(52.dp)
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(fieldBackground)
                                        .border(1.dp, borderDark, RoundedCornerShape(14.dp))
                                        .padding(horizontal = 16.dp),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = SearchVector,
                                            contentDescription = "Buscar",
                                            tint = mutedTextColor,
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(
                                            text = "Buscar por nombre...",
                                            color = mutedTextColor,
                                            fontSize = 15.sp
                                        )
                                    }
                                }

                                // Genre Dropdown Field
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(fieldBackground)
                                        .border(1.dp, borderDark, RoundedCornerShape(14.dp))
                                        .padding(horizontal = 16.dp, vertical = 12.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column {
                                            Text(
                                                text = "GÉNERO",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = mutedTextColor,
                                                letterSpacing = 0.5.sp
                                            )
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = "Todos los géneros",
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = textColor
                                            )
                                        }
                                        Icon(
                                            imageVector = ArrowDownVector,
                                            contentDescription = "Desplegar género",
                                            tint = mutedTextColor,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }

                                // Platform Dropdown Field
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(fieldBackground)
                                        .border(1.dp, borderDark, RoundedCornerShape(14.dp))
                                        .padding(horizontal = 16.dp, vertical = 12.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column {
                                            Text(
                                                text = "PLATAFORMA",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = mutedTextColor,
                                                letterSpacing = 0.5.sp
                                            )
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = "PC (Windows)",
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = textColor
                                            )
                                        }
                                        Icon(
                                            imageVector = ArrowDownVector,
                                            contentDescription = "Desplegar plataforma",
                                            tint = mutedTextColor,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                            }
                        }

                        // Section Title: Explora juegos
                        item {
                            Column(modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)) {
                                Text(
                                    text = "Explora juegos",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = textColor
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "Mostrando 6 juegos para PC",
                                    fontSize = 13.sp,
                                    color = mutedTextColor
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                // Sort pill dropdown
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(Color(0xFF1E1E2A))
                                        .padding(horizontal = 16.dp, vertical = 8.dp)
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = "Más populares",
                                            color = textColor,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Medium
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Icon(
                                            imageVector = ArrowDownVector,
                                            contentDescription = "Ordenar",
                                            tint = textColor,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }
                            }
                        }

                        // Game Items List
                        items(sampleGames) { game ->
                            GameCard(game = game, cardColor = cardColor)
                        }
                    }
                }
            }
            1 -> {
                FavoritesView(usuario = usuario)
            }
            2 -> {
                ProfileView(usuario = usuario)
            }
        }

        // Bottom Navigation Bar
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color(0xFF0F0F13))
                .padding(vertical = 12.dp, horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tab 1: Inicio
                val isHomeSelected = selectedTab == 0
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .background(if (isHomeSelected) Color(0xFF3B3355) else Color.Transparent)
                        .clickable { selectedTab = 0 }
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = GridViewVector,
                            contentDescription = "Inicio",
                            tint = if (isHomeSelected) primaryPurple else mutedTextColor,
                            modifier = Modifier.size(22.dp)
                        )
                        Text(
                            text = "Inicio",
                            color = if (isHomeSelected) textColor else mutedTextColor,
                            fontSize = 11.sp,
                            fontWeight = if (isHomeSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }

                // Tab 2: Mis Favoritos
                val isFavSelected = selectedTab == 1
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .background(if (isFavSelected) Color(0xFF3B3355) else Color.Transparent)
                        .clickable { selectedTab = 1 }
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = if (isFavSelected) FavoriteFilledVector else FavoriteOutlineVector,
                            contentDescription = "Mis Favoritos",
                            tint = if (isFavSelected) primaryPurple else mutedTextColor,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Mis Favoritos",
                            color = if (isFavSelected) textColor else mutedTextColor,
                            fontSize = 11.sp,
                            fontWeight = if (isFavSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }

                // Tab 3: Perfil
                val isProfileSelected = selectedTab == 2
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .background(if (isProfileSelected) Color(0xFF3B3355) else Color.Transparent)
                        .clickable { selectedTab = 2 }
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = PersonVector,
                            contentDescription = "Perfil",
                            tint = if (isProfileSelected) primaryPurple else mutedTextColor,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Perfil",
                            color = if (isProfileSelected) textColor else mutedTextColor,
                            fontSize = 11.sp,
                            fontWeight = if (isProfileSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GameCard(
    game: GameItem,
    cardColor: Color
) {
    val primaryPurple = Color(0xFFC4B5FD)
    val textColor = Color.White
    val mutedTextColor = Color(0xFF9CA3AF)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Column {
            // Banner Header Area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(game.bannerColor)
            ) {
                // Center Gamepad Icon
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .background(Color(0x33000000))
                        .align(Alignment.Center),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = HomeGamepadVector,
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.9f),
                        modifier = Modifier.size(36.dp)
                    )
                }

                // Top Right Favorite Button
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(if (game.isFavorite) Color(0xFF4C426E) else Color(0x66000000))
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (game.isFavorite) FavoriteFilledVector else FavoriteOutlineVector,
                        contentDescription = "Favorito",
                        tint = if (game.isFavorite) primaryPurple else Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Bottom Left Green Badge
                Surface(
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.BottomStart),
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFA7F3D0)
                ) {
                    Text(
                        text = game.platform,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        color = Color(0xFF0F0F13),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Card Content Area
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = game.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF22222D)
                    ) {
                        Text(
                            text = game.genre,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            color = primaryPurple,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = game.description,
                    fontSize = 13.sp,
                    color = mutedTextColor,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "FREE-TO-PLAY",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = primaryPurple
                    )

                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF22222D),
                            contentColor = textColor
                        ),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        modifier = Modifier.height(36.dp)
                    ) {
                        Text(
                            text = "Ver detalles",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
