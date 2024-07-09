package com.pes.adjudicat.presentation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.pes.adjudicat.presentation.screens.*

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pes.adjudicat.navigation.Destinations.*
import com.pes.adjudicat.presentation.freatures.licitacionsList.LicitacionsListViewModel
import com.pes.adjudicat.ui.theme.AdjudiCatTheme

/**
 * Assign Screens to Routes
 *
 * Function that uses the NavHost to assign a route to a screen.
 *
 *
 * Add a composable with the route and the screen composable to print to add a screen
 *
 * @param navController NavHostController decelerated in the Main
 */
@Composable
fun NavigationHost(
    navController: NavHostController,
    contentPadding : PaddingValues
) {
    val homeLicitacionsListViewModel: LicitacionsListViewModel = viewModel()
    val searchLicitacionsListViewModel: LicitacionsListViewModel = viewModel()
    AdjudiCatTheme() {


        NavHost(
            navController = navController, startDestination = Home.route,
            modifier = Modifier.padding(contentPadding),
        ) {
            composable(Home.route) {
                Home(
                    licitacionsListViewModel = homeLicitacionsListViewModel,
                    navigateToDetails = {id ->
                    navController.navigate(LicitacioDetails.route + "/$id")
                })
            }

            composable(Search.route) {
                Search(
                    licitacionsListViewModel = searchLicitacionsListViewModel,
                    navigateToDetails = {id ->
                    navController.navigate(LicitacioDetails.route + "/$id")
                })
            }

            composable(Post.route) {
                Post()
            }

            composable(Notifications.route) {
                Notifications()
            }

            composable(Account.route) {
                Account()
            }

            composable(
                 route =  LicitacioDetails.route + "/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { entry ->
                //val id = backStackEntry.arguments!!.getInt("id")!!
                LicitacioDetails(id = entry.arguments!!.getInt("id")!!)
            }
        }
    }
}