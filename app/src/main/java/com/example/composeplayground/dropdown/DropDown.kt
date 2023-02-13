package com.example.composeplayground.dropdown

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun DropDown() {
    var isExpanded by remember { mutableStateOf(false) }
    val list = listOf("Kotlin", "Java", "Dart", "Python")
    var selectedItem by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if(isExpanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(
        modifier = Modifier.padding(20.dp)
    ){
        OutlinedTextField(
            value = selectedItem,
            onValueChange = { selectedItem = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { layoutCoordinates ->
                    textFieldSize = layoutCoordinates.size.toSize()
                },
            label = {Text(text = "Select Item")},
            trailingIcon = {
                Icon(icon, "", Modifier.clickable { isExpanded = !isExpanded })
            }
        )

        DropdownMenuItem(
            onClick = { isExpanded = false },
            modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})
        ) {

            list.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem = label
                    isExpanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

}

@Preview(
    showSystemUi = true,
)
@Composable
fun Preview() {
    DropDown()
}