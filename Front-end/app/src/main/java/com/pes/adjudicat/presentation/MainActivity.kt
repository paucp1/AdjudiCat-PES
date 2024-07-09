package com.pes.adjudicat.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.pes.adjudicat.navigation.Destinations
import com.pes.adjudicat.presentation.components.BottomNavigationBar
import com.pes.adjudicat.ui.theme.AdjudiCatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdjudiCatTheme {
                MainScreen()
            }

        }
    }
}

/**
 * Main Screen Component
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    //Create a NavController to navigate through screens
    //Use it with navController.navigate(Destination.route)
    val navController = rememberNavController()

    //Create the list of routes in the bottom bar
    val navigationItems = listOf(
        Destinations.Home,
        Destinations.Search,
        Destinations.Post,
        Destinations.Notifications,
        Destinations.Account
    )

    Scaffold(
        //Set the bottom navigation bar with the controller and the items in it
        bottomBar = { BottomNavigationBar(navController = navController, items = navigationItems)}
    ) { paddingValues ->
        NavigationHost(
            navController = navController,
            //TODO arreglar el padding
            contentPadding = paddingValues,
        ) //Set the NavigationHost of the app
    }
}

