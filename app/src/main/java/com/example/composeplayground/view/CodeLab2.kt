package com.example.composeplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.composeplayground.ui.theme.ComposePlayGroundTheme

class CodeLab2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlayGroundTheme {
                
            }
        }
    }
}

@Composable
private fun Greeting(
    name: String,
){
    Text(text = name)
}

