package com.pes.adjudicat.presentation.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.*
import com.pes.adjudicat.presentation.freatures.licitacionsList.LicitacionList
import com.pes.adjudicat.presentation.freatures.licitacionsList.LicitacionsListViewModel
import com.pes.adjudicat.ui.theme.Teal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SearchView(state: MutableState<TextFieldValue>) {

    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(0.87f)
            .fillMaxHeight(0.075f),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("")
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 0.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.DarkGray,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
@Composable
fun buttonWithColor(): Boolean {

    var checked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.075f)
            .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 12.dp, bottomStart = 0.dp, bottomEnd = 12.dp))
            .background(Color.DarkGray),

        ) {
        IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
            if (checked) {

                Icon(
                    imageVector = Icons.Rounded.List,
                    contentDescription = null,
                    tint = Teal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()

                )
            } else {
                Icon(
                    imageVector = Icons.Rounded.List,
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }

    }
    return checked
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Search(
    licitacionsListViewModel: LicitacionsListViewModel,
    navigateToDetails: (Int) -> Unit
) {
    var apretat = false
    Column(verticalArrangement = Arrangement.spacedBy(3.dp)){
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            val textState = remember { mutableStateOf(TextFieldValue("")) }
            SearchView(textState)
            apretat = buttonWithColor()
        }
        LicitacionList(
            licitacionsListViewModel,
            apretat,
            navigateToDetails,
            "Search"
        )
    }
}