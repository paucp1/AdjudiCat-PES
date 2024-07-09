package com.pes.adjudicat.presentation.components

import android.widget.RemoteViews.RemoteCollectionItems
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pes.adjudicat.navigation.Destinations
import com.pes.adjudicat.ui.theme.TopGray

/**
 * Function that compose the BottomNavigation and the items in it with the routes
 *
 * @param navController NavHostController decelerated in the Main
 * @param items List of the items to be shown in the bottom bar
 */
@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Destinations>
) {
    val currentRoute = currentRoute(navController = navController)


    BottomNavigation() {
        items.forEach { screen ->
            BottomNavigationItem(
                unselectedContentColor = TopGray,
                icon = { screen.icon?.let { Icon(imageVector = it, contentDescription = screen.title) } },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true //navigate only if it's not already in the destination
                    }
                }
            )
        }

    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}