package com.pes.adjudicat.presentation.freatures.licitacioDetails


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pes.adjudicat.ui.theme.LightGray
import com.pes.adjudicat.ui.theme.Teal

@Composable
fun LicitacioDetailsComponent (
    viewModel: LicitacioDetailsViewModel,
    modifier: Modifier?,
) {
    val licitacio = viewModel.licitacio.observeAsState()

    if (! viewModel.errorMessage.isEmpty())  Text(text = viewModel.errorMessage)

    Column {
        licitacio.value?.denominacio?.let {
            Title(text = it)
        }
        licitacio.value?.llocExecucio?.let {
            Location(text = it)
        }
        licitacio.value?.enllaç?.let {
            Description(text = it)
        }
        licitacio.value?.pressupost?.let {
            Budget(text = it)
        }
    }
}

@Composable
private fun Title(
    text : String
) {
    Row(
        Modifier.padding(6.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            color = Color.LightGray
        )
    }
}

@Composable
private fun Location(
    text : String
) {
    Row() {
        Icon(imageVector = Icons.Filled.LocationOn, tint = Teal, contentDescription = null)
        Text(
            text = text,
            color = LightGray
        )
    }
}

@Composable
private fun Budget(
    text : String
) {
    Row(
        modifier = Modifier.padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(imageVector = Icons.Outlined.MonetizationOn, tint = Teal, contentDescription = null)
        Text(
            text = text,
            color = Color.LightGray
        )
    }
}

@Composable
private fun Description(
    text : String
) {
    Row(
        Modifier.padding(6.dp)
    ) {
        Text(
            text = text,
            color = Color.LightGray
        )
    }
}



@Preview
@Composable
private fun PreviewLicitacioDetails() {
    LicitacioDetailsComponent(
        modifier = Modifier.fillMaxWidth(),
        viewModel = LicitacioDetailsViewModel(1)
    )
}