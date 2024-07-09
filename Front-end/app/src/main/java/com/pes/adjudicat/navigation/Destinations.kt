package com.pes.adjudicat.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Class that defines all the destinations of the bottom bar
 *
 */
sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector?
    ) {
    object Home: Destinations("home", "Home", Icons.Filled.Home)
    object Search: Destinations("search", "Search", Icons.Filled.Search)
    object Post: Destinations("post", "Post", Icons.Filled.AddCircle)
    object Notifications: Destinations("notifications", "Notifications", Icons.Filled.Notifications)
    object Account: Destinations("account", "Account", Icons.Filled.AccountCircle)

    object LicitacioDetails: Destinations("licitacioDetails", "LicitacioDetails", null)
}