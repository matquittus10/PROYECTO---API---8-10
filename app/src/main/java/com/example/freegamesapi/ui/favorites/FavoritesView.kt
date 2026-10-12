package com.example.freegamesapi.ui.favorites

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freegamesapi.Model.Usuario

val FavGamepadVector: ImageVector
    get() = ImageVector.Builder(
        name = "FavGamepad",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M21 6H3c-1.1 0-2 .9-2 2v8c0 1.1.9 2 2 2h18c1.1 0 2-.9 2-2V8c0-1.1-.9-2-2-2zm-14 8H5v-2h2v2zm0-3H5V9h2v2zm3 3H8v-2h2v2zm0-3H8V9h2v2zm6 4h-2v-2h2v2zm3-3h-2v-2h2v2z"),
        fill = SolidColor(Color.White)
    ).build()

val FavChevronRightVector: ImageVector
    get() = ImageVector.Builder(
        name = "FavChevronRight",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"),
        fill = SolidColor(Color(0xFF9CA3AF))
    ).build()

val FavHeartFilledVector: ImageVector
    get() = ImageVector.Builder(
        name = "FavHeartFilled",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"),
        fill = SolidColor(Color(0xFFC4B5FD))
    ).build()

val FavHeartOutlineVector: ImageVector
    get() = ImageVector.Builder(
        name = "FavHeartOutline",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M16.5 3c-1.74 0-3.41.81-4.5 2.09C10.91 3.81 9.24 3 7.5 3 4.42 3 2 5.42 2 8.5c0 3.78 3.4 6.86 8.55 11.54L12 21.35l1.45-1.32C18.6 15.36 22 12.28 22 8.5 22 5.42 19.58 3 16.5 3zm-4.4 15.55l-.1.1-.1-.1C7.14 14.24 4 11.39 4 8.5 4 6.5 5.5 5 7.5 5c1.54 0 3.04.99 3.57 2.36h1.87C13.46 5.99 14.96 5 16.5 5 18.5 5 20 6.5 20 8.5c0 2.89-3.14 5.74-7.9 10.05z"),
        fill = SolidColor(Color(0xFFC4B5FD))
    ).build()

val FavGridViewVector: ImageVector
    get() = ImageVector.Builder(
        name = "FavGridView",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).addPath(
        pathData = addPathNodes("M4 11h6V4H4v7zm0 9h6v-7H4v7zm10 0h6v-7h-6v7zm0-16v7h6V4h-6z"),
        fill = SolidColor(Color(0xFF0F0F13))
    ).build()

@Composable
fun FavoritesView(
    usuario: Usuario = Usuario(1048, "Alex Lara", "alex.lara@email.com")
) {
    val backgroundColor = Color(0xFF0F0F13)
    val cardColor = Color(0xFF181820)
    val primaryPurple = Color(0xFFC4B5FD)
    val textColor = Color.White
    val mutedTextColor = Color(0xFF9CA3AF)
    val borderDark = Color(0xFF2A2A38)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Top Header Bar
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Controller icon top-left
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(primaryPurple),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = FavGamepadVector,
                            contentDescription = "Logo",
                            tint = Color(0xFF0F0F13),
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    // Avatar circle top-right
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(primaryPurple),
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

            // Title, Subtitle and Pill Counter
            item {
                Column {
                    Text(
                        text = "Mis Favoritos",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Tus juegos guardados, siempre a un clic.",
                        fontSize = 14.sp,
                        color = mutedTextColor
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // "2 juegos guardados" Pill
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color(0xFF1E1E28),
                        border = BorderStroke(1.dp, Color(0xFF2A2A3A))
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "2 ",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = textColor
                            )
                            Text(
                                text = "juegos guardados",
                                fontSize = 14.sp,
                                color = mutedTextColor
                            )
                        }
                    }
                }
            }

            // Card 1: Overwatch 2
            item {
                FavoriteGameCard(
                    title = "Overwatch 2",
                    description = "A hero-focused first-person team shooter from Blizzard Entertainment.",
                    genre = "Shooter",
                    platform = "PC (Windows)",
                    publisherTag = "OVERWATCH",
                    bannerColor = Color(0xFF3B4354),
                    badgeBgColor = Color(0xFF86EFAC),
                    cardColor = cardColor
                )
            }

            // Card 2: Valorant
            item {
                FavoriteGameCard(
                    title = "Valorant",
                    description = "A tactical 5v5 character-based shooter where precise gunplay meets abilities.",
                    genre = "Shooter",
                    platform = "PC (Windows)",
                    publisherTag = "VALORANT",
                    bannerColor = Color(0xFF422C33),
                    badgeBgColor = Color(0xFF86EFAC),
                    cardColor = cardColor
                )
            }

            // Card 3: Empty State / Explore Card ("Aún no tienes favoritos")
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFF12121A),
                    border = BorderStroke(1.dp, borderDark)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(28.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Heart Icon Circle
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF3B3355)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = FavHeartOutlineVector,
                                contentDescription = "Heart",
                                tint = primaryPurple,
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Aún no tienes favoritos",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = textColor,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Guarda los juegos que más te interesen y los encontrarás aquí.",
                            fontSize = 13.sp,
                            color = mutedTextColor,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // "Explorar juegos" Button
                        Surface(
                            shape = RoundedCornerShape(24.dp),
                            color = primaryPurple,
                            modifier = Modifier.wrapContentSize()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = FavGridViewVector,
                                    contentDescription = "Explorar",
                                    tint = Color(0xFF0F0F13),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Explorar juegos",
                                    color = Color(0xFF0F0F13),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun FavoriteGameCard(
    title: String,
    description: String,
    genre: String,
    platform: String,
    publisherTag: String,
    bannerColor: Color,
    badgeBgColor: Color,
    cardColor: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = cardColor
    ) {
        Column {
            // Banner area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(bannerColor)
            ) {
                // Heart button top-right
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.TopEnd)
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF5B4D82)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = FavHeartFilledVector,
                        contentDescription = "Favorito",
                        tint = Color(0xFFC4B5FD),
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Center Gamepad Box
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(64.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF242732).copy(alpha = 0.8f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = FavGamepadVector,
                        contentDescription = "Gamepad",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }

                // Bottom Left Badge: FREE TO PLAY
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.BottomStart)
                        .clip(RoundedCornerShape(6.dp))
                        .background(badgeBgColor)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "FREE TO PLAY",
                        color = Color(0xFF064E3B),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Bottom Right Tag Text
                Text(
                    text = publisherTag,
                    color = Color(0xFF9CA3AF),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.BottomEnd)
                )
            }

            // Card body
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Icon(
                        imageVector = FavChevronRightVector,
                        contentDescription = "Ver detalles",
                        tint = Color(0xFF9CA3AF),
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = description,
                    fontSize = 13.sp,
                    color = Color(0xFF9CA3AF),
                    lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Tags row
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Genre tag
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF242430))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = genre,
                            color = Color(0xFFE5E7EB),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Platform tag
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF3B3355))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = platform,
                            color = Color(0xFFC4B5FD),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
