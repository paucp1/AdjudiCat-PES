package com.pes.adjudicat.presentation.screens

import androidx.compose.runtime.Composable
import com.pes.adjudicat.presentation.freatures.licitacioDetails.LicitacioDetailsComponent
import com.pes.adjudicat.presentation.freatures.licitacioDetails.LicitacioDetailsViewModel

@Composable
fun LicitacioDetails (
    id : Int
) {
    LicitacioDetailsComponent(LicitacioDetailsViewModel(id), modifier = null)
}