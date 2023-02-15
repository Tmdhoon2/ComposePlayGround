package com.example.composeplayground.navigationcomponent

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavigationGraph(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = "Screen1",
    ){
        composable(
            route = "Screen1"
        ){
            Screen1()
        }

        composable(
            route = "Screen2"
        ){
            Screen2()
        }

        composable(
            route = "Screen3"
        ){
            Screen3()
        }

        composable(
            route = "Screen4"
        ){
            Screen4()
        }
    }
}