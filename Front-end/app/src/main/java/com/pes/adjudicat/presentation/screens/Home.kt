package com.pes.adjudicat.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.stringResource
import com.pes.adjudicat.R
import com.pes.adjudicat.navigation.Destinations
import com.pes.adjudicat.presentation.freatures.licitacionsList.LicitacionList
import com.pes.adjudicat.presentation.freatures.licitacionsList.LicitacionsListViewModel
import com.pes.adjudicat.ui.theme.LightGray

/**
 * Composable que mostre la pantalla del home
 */
@Composable
fun Home(
    navigateToDetails: (Int) -> Unit,
    licitacionsListViewModel: LicitacionsListViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        Text(
            text = stringResource(R.string.app_name),
            color = LightGray
        )
        LicitacionList(viewModel = licitacionsListViewModel,false, navigateToDetails, "Home")
    }
}


@Preview
@Composable
fun PreviewHome() {
    Surface {
        Home(
            licitacionsListViewModel = LicitacionsListViewModel(),
            navigateToDetails = {}
        )
    }
}