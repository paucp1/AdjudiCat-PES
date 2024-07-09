package com.pes.adjudicat.presentation.freatures.filterBox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Euro
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pes.adjudicat.data.models.Filtres
import com.pes.adjudicat.ui.theme.Teal
import com.pes.adjudicat.ui.theme.LightGray

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterElement(
    modifier: Modifier,
    filtres: Filtres,
) {
    
    Box(
        modifier = modifier

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .padding(6.dp)
        ) {
            Ambit(Modifier.weight(weight = 1f).fillMaxWidth(), filtres = filtres)
            RowContentTipusLicitacio(Modifier.weight(weight = 1f).fillMaxWidth(), filtres = filtres)
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(weight = 1f).fillMaxWidth(),
            )
            {
                Text(
                    text = "Tipus de contracte",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
            Tipos_contrato(filtres = filtres)
            Pressupost(Modifier.weight(weight = 1f).fillMaxWidth(), filtres = filtres)
            RowContentDuracioContracte(Modifier.weight(weight = 1f).fillMaxWidth(), filtres = filtres)
            RowContentLocalitzacio(filtres = filtres)
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(weight = 1f).fillMaxWidth(),
            )
            {
                Text(
                    text = "Data",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(weight = 1f).fillMaxWidth(),
            )
            {
                Text(
                    text = "Fi presentació",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(weight = 1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Button(
                    onClick = { print(filtres)},
                    modifier = Modifier.padding(end = 16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Teal)
                ) {
                    Text(text = "Aplicar")
                }
            }
        }
    }

}

@Composable
fun RowContentTipusLicitacio(modifier: Modifier, filtres: Filtres) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    )
    {
        Text(
            text = "Tipus licitació: ",
            color = Color.White,
            fontSize = 15.sp
        )
    }
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    )
    {
        var isCheckedPublica by remember { mutableStateOf(false) }
        Text(
            text = ("   Pública:"),
            color = Color.White,
            fontSize = 15.sp
        )
        Checkbox(
            checked = isCheckedPublica,
            onCheckedChange = { isCheckedPublica = it

                              },

            colors = CheckboxDefaults.colors(
                checkedColor = Teal,
                uncheckedColor = Color.White,
                checkmarkColor = Color.White,
                disabledColor = Color.Gray,

                )
        )
        filtres.tipus_licitacio_publica = isCheckedPublica
    }
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    )
    {
        var isCheckedPrivada by remember { mutableStateOf(false) }
        Text(
            text = ("   Privada:"),
            color = Color.White,
            fontSize = 15.sp
        )
        Checkbox(
            checked = isCheckedPrivada,
            onCheckedChange = { isCheckedPrivada = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Teal,
                uncheckedColor = Color.White,
                checkmarkColor = Color.White,
                disabledColor = Color.Gray,
            )
        )
        filtres.tipus_licitacio_privada = isCheckedPrivada
    }
}

@Composable
fun RowContentDuracioContracte(modifier: Modifier, filtres: Filtres) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    )
    {
        Text(
            text = "Duració del contracte:",
            color = Color.White,
            fontSize = 15.sp
        )
    }
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    )
    {
        Text(text = "Anys")
        var intAny by remember { mutableStateOf(0) }
        TextField(
            value = intAny.toString(),
            onValueChange = { newValue ->
                val filteredValue = newValue.filter { it.isDigit() }
                intAny = filteredValue.toIntOrNull() ?: 0
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 8.dp)

        )
        Text(text = "Mesos")
        var intMes by remember { mutableStateOf(0) }
        TextField(
            value = intMes.toString(),
            onValueChange = { newValue ->
                val filteredValue = newValue.filter { it.isDigit() }
                intMes = filteredValue.toIntOrNull() ?: 0
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 8.dp)
        )
        Text(text = "Dies")
        var intDies by remember { mutableStateOf(0) }
        TextField(
            value = intDies.toString(),
            onValueChange = { newValue ->
                val filteredValue = newValue.filter { it.isDigit() }
                intDies = filteredValue.toIntOrNull() ?: 0
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 8.dp)
        )
        filtres.duracio_en_dies =  calcularDies(intAny, intMes, intDies)

    }
}

fun calcularDies(intAny: Int, intMes: Int, intDies: Int): Int {
    val totalMesos = intAny * 12 + intMes
    val totalDies = intDies + totalMesos * 30
    return totalDies
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RowContentLocalitzacio(filtres: Filtres) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Text(
            text = "Localització",
            modifier = Modifier
                .padding(vertical = 5.dp)
                .weight(1f),
            color = Color.White,
            fontSize = 15.sp
        )
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val blackArrowIcon = Icons.Filled.ArrowDropDown

        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { it ->
                text = it

            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp),
            textStyle = TextStyle(fontSize = 13.sp, textAlign = TextAlign.Start),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        )
        filtres.localitzacio = text

        val ciudades = listOf("Barcelona", "Girona", "Lleida", "Tarragona", "Reus")
        var expanded by remember { mutableStateOf(false) }
        var ciudadSeleccionada by remember { mutableStateOf<String?>(null) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .clip(RoundedCornerShape(30.dp))
        ) {
            TextField(
                readOnly = true,
                value = ciudadSeleccionada ?: "",
                onValueChange = { },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    backgroundColor = Color.White,
                ),
                textStyle = TextStyle(fontSize = 10.sp),
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        color = Color.White
                    ),
            ) {
                ciudades.forEach { selectionOption ->
                    if (text.isBlank() || selectionOption.startsWith(text, ignoreCase = true)) {
                        DropdownMenuItem(
                            onClick = {
                                ciudadSeleccionada = selectionOption
                                expanded = false
                                text = selectionOption // actualizar TextField con la opción seleccionada
                            }
                        ) {
                            Text(
                                text = selectionOption,
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Ambit(
    modifier: Modifier,
    filtres: Filtres
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Text(
            text = "Àmbit",
            modifier = Modifier.padding(end = 6.dp),
            color = LightGray,
            fontSize = 15.sp
        )
        Spacer(Modifier.weight(1f))
        val types = listOf(
            "",
            "Altres Ens",
            "Departaments i sector public de la generalitat de Catalunya",
            "Entitats de l'administració local",
            "Universitats",
            "Institucions i òrgans estatuaris"
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            val default = 0

            var expanded by remember { mutableStateOf(false) }
            var selectedType by remember { mutableStateOf(types[default]) } // (1)
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded // (2)
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp)),
            )
            {
                TextField(
                    readOnly = true, // (3)
                    value = selectedType, // (4)
                    onValueChange = { },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon( // (5)
                            expanded = expanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        backgroundColor = LightGray,
                    ),
                    textStyle = TextStyle(fontSize = 10.sp),
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(
                            color = LightGray
                        ),

                    ) {
                    types.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                selectedType = selectionOption
                                expanded = false
                            }
                        ) {
                            Text(
                                text = selectionOption,
                            )
                        }
                    }

                }

            }
            filtres.ambit = selectedType
        }
    }
}


@Composable
fun Pressupost(
    modifier: Modifier,
    filtres: Filtres
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    )
    {
        Text(
            text = "Pressupost",
            modifier = Modifier.padding(end = 6.dp),
            color = LightGray,
            fontSize = 15.sp
        )
        Spacer(Modifier.weight(1f))
        val x = 10000000
        var t = 1

        var pressupost by remember { mutableStateOf(0) }
        TextField(
            value = pressupost.toString(),
            onValueChange = { newValue ->
                val filteredValue = newValue.filter {it.isDigit()}
                pressupost = filteredValue.toIntOrNull() ?: 0

            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Euro,
                    contentDescription = "En Euros",
                    )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            ),

            textStyle = TextStyle(fontSize = 12.sp),

            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = LightGray,
            ),
        )
        filtres.pressupost = pressupost
    }
}

/*@Preview
@Composable
fun PreviewFiltre() {
    FilterElement(
        Modifier
        .fillMaxWidth()
        .padding(
            top = 12.dp,
            start = 12.dp,
            end = 12.dp,
            bottom = 0.dp,
        )
        .clip(RoundedCornerShape(12.dp))
        .background(Color.DarkGray))
}
*/
@Composable
fun Tipos_contrato(filtres: Filtres) {
    val types_contract = listOf(
        "Servicio",
        "Suministro",
        "Administracion",
        "Obras",
        "Algo mas",
        "No debe mostrarse"
    )
    // checkbox  de tipos de contracto
    CheckboxList(stringsList = types_contract, filtres = filtres)
}

@Composable
fun StringCheckbox(stringValue: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit, filtres: Filtres) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        // modifier = Modifier.padding(16.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.White
            )

        )
        if (checked && !filtres.tipus_contracte.contains(stringValue))
            filtres.tipus_contracte.add(stringValue)
        else if (!checked && !filtres.tipus_contracte.contains(stringValue))
            filtres.tipus_contracte.remove(stringValue)
        Text(text = stringValue, color = Color.White)
    }
}


@Composable
fun CheckboxList(stringsList: List<String>, filtres: Filtres) {
    val checkedState = remember { mutableStateListOf<Boolean>() }
    stringsList.forEach { checkedState.add(false) }

    var showFullList by remember { mutableStateOf(false) }


    Column {
        getVisibleList(stringsList, showFullList).forEachIndexed { index, stringValue ->
            StringCheckbox(
                stringValue = stringValue,
                checked = checkedState[index],
                onCheckedChange = { isChecked ->
                    checkedState[index] = isChecked

                },
            filtres = filtres)
        }

        if (!showFullList) {
            TextButton(
                onClick = { showFullList = true },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    "Mostrar más",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        } else {
            TextButton(
                onClick = { showFullList = false },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    "Mostrar menos",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

fun getVisibleList(list: List<String>, showFullList: Boolean): List<String> {
    return if (showFullList) {
        list
    } else {
        list.take(3)
    }
}