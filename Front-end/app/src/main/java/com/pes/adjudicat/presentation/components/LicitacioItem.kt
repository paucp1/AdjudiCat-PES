package com.pes.adjudicat.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Icon
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pes.adjudicat.data.models.ShortLicitacio
import com.pes.adjudicat.ui.theme.LightGray
import com.pes.adjudicat.ui.theme.Teal


/**
 * Element que mostra una licitacio a la llista
 *
 * @param modifier Modificadors
 * @param licitacio objecte amb la info de la licitacio a mostrar
 * @param onToggleSave accio del boto de favorits TODO
 */
@Composable
fun LicitacioElement(
    modifier: Modifier = Modifier,
    licitacio: ShortLicitacio,
    onToggleSave: (Int) -> Unit,
    navigateToDetails: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.DarkGray)
            .clickable(onClick = { licitacio.id?.let { navigateToDetails(it) } })
    ) {
        Column {
            licitacio.denominacio?.let {
                Title(text = it)
            }
            licitacio.llocExecucio?.let {
                Location(text = it)
            }
            licitacio.tipusContracte?.let {
                Description(text = it)
            }
            licitacio.pressupost?.let {
                Budget(text = it)
            }
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
private fun Preview() {
    LicitacioElement(
        modifier = Modifier.fillMaxWidth(),
        licitacio = ShortLicitacio(
            denominacio = "Nom Licitacio",
            llocExecucio = "Barcelona",
            tipusContracte = "Lorem ipsum dolor sit amet, " +
                    "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
                    "Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, " +
                    "nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, " +
                    "pretium quis, sem. Nulla consequat mas",
            pressupost = "1240000",
        ),
        onToggleSave = {},
        navigateToDetails = {}
    )
}















