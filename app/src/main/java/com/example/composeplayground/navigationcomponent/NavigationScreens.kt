package com.example.composeplayground.navigationcomponent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.composeplayground.expandablecard.ExpandableCard
import com.example.composeplayground.model.SampleData
import com.example.composeplayground.view.Conversation
import com.example.composeplayground.view.MyApp
import com.example.composeplayground.viewpager.ViewPagerScreen

@Composable
fun Screen1(){
    MyApp(modifier = Modifier.fillMaxSize())
}

@Composable
fun Screen2(){
    Conversation(SampleData.conversationSample)
}

@Composable
fun Screen3(){
    ViewPagerScreen()
}

@Composable
fun Screen4(){
    ExpandableCard()
}