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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freegamesapi.model.Usuario
import com.example.freegamesapi.ui.favorites.FavoritesView
import com.example.freegamesapi.ui.profile.ProfileView

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
    var selectedTab by remember { mutableIntStateOf(0) }
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

    Scaffold(
        containerColor = backgroundColor,
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF0F0F13),
                contentColor = mutedTextColor,
                tonalElevation = 0.dp
            ) {
                // Tab 1: Inicio
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.GridView,
                            contentDescription = "Inicio"
                        )
                    },
                    label = {
                        Text(
                            text = "Inicio",
                            fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Medium
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = primaryPurple,
                        selectedTextColor = textColor,
                        unselectedIconColor = mutedTextColor,
                        unselectedTextColor = mutedTextColor,
                        indicatorColor = Color(0xFF3B3355)
                    )
                )

                // Tab 2: Mis Favoritos
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Icon(
                            imageVector = if (selectedTab == 1) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Mis Favoritos"
                        )
                    },
                    label = {
                        Text(
                            text = "Mis Favoritos",
                            fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Medium
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = primaryPurple,
                        selectedTextColor = textColor,
                        unselectedIconColor = mutedTextColor,
                        unselectedTextColor = mutedTextColor,
                        indicatorColor = Color(0xFF3B3355)
                    )
                )

                // Tab 3: Perfil
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Perfil"
                        )
                    },
                    label = {
                        Text(
                            text = "Perfil",
                            fontWeight = if (selectedTab == 2) FontWeight.Bold else FontWeight.Medium
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = primaryPurple,
                        selectedTextColor = textColor,
                        unselectedIconColor = mutedTextColor,
                        unselectedTextColor = mutedTextColor,
                        indicatorColor = Color(0xFF3B3355)
                    )
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedTab) {
                0 -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
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
                                        imageVector = Icons.Default.SportsEsports,
                                        contentDescription = "Game Icon",
                                        tint = Color(0xFF0F0F13),
                                        modifier = Modifier.size(26.dp)
                                    )
                                }

                                // Right Avatar Circle
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
                                            imageVector = Icons.Default.Search,
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
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "Desplegar género",
                                            tint = mutedTextColor,
                                            modifier = Modifier.size(24.dp)
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
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "Desplegar plataforma",
                                            tint = mutedTextColor,
                                            modifier = Modifier.size(24.dp)
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
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "Ordenar",
                                            tint = textColor,
                                            modifier = Modifier.size(20.dp)
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
                1 -> {
                    FavoritesView(usuario = usuario)
                }
                2 -> {
                    ProfileView(usuario = usuario)
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
                // Center Game Icon
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .background(Color(0x33000000))
                        .align(Alignment.Center),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.SportsEsports,
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
                        imageVector = if (game.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
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
                        text = "FREE TO PLAY",
                        color = Color(0xFF065F46),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                // Bottom Right Publisher Tag
                Text(
                    text = game.publisherTag,
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.BottomEnd)
                )
            }

            // Card Body Info Area
            Column(
                modifier = Modifier.padding(16.dp)
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
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Ver detalles",
                        tint = mutedTextColor,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = game.description,
                    fontSize = 13.sp,
                    color = mutedTextColor,
                    lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Tag Chips
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Genre Tag
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFF22222E),
                        border = BorderStroke(1.dp, Color(0xFF2D2D3A))
                    ) {
                        Text(
                            text = game.genre,
                            color = textColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }

                    // Platform Tag
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFF3B3355)
                    ) {
                        Text(
                            text = game.platform,
                            color = primaryPurple,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }
    }
}
