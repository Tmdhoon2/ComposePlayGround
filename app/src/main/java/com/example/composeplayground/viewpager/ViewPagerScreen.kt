package com.example.composeplayground.viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.example.composeplayground.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerScreen(){
    Column(
        modifier = Modifier.fillMaxWidth()
            .height(200.dp)
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            count = 4,
        ) {page ->
            ViewPagerCard(page = page)
        }
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun ViewPagerCardPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = Modifier.height(200.dp),
        )
    }
}

@Composable
fun ViewPagerCard(
    page: Int,
){
    Column(
        modifier = Modifier
            .size(
                width = 200.dp,
                height = 300.dp,
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(4.dp)
            )
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(4.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "오늘의 급식"
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = page.toString(),
        )

    }
}