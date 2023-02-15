package com.example.composeplayground.navigationcomponent

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

val list = listOf(
    "Screen1",
    "Screen2",
    "Screen3",
    "Screen4",
)

@Composable
fun BottomNavigation(
    navController: NavController,
){

    val navBackStackEntity by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntity?.destination?.route

    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(color = 0xFF3F414E),
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = NavigationItem.Screen1.icon),
                    contentDescription = null,
                )
            },
            label = { Text(text = "Home") },
            selectedContentColor = Color.Cyan,
            unselectedContentColor = Color.Gray,
            selected = (currentRoute == NavigationItem.Screen1.screenRoute),
            alwaysShowLabel = false,
            onClick = {
                navController.navigate(NavigationItem.Screen1.screenRoute){
                    restoreState = true
                    launchSingleTop = true

                }
            }
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = NavigationItem.Screen2.icon),
                    contentDescription = null,
                )
            },
            label = { Text(text = "Calendar") },
            selectedContentColor = Color.Cyan,
            unselectedContentColor = Color.Gray,
            selected = (currentRoute == NavigationItem.Screen2.screenRoute),
            alwaysShowLabel = false,
            onClick = {
                navController.navigate(NavigationItem.Screen2.screenRoute){
                    restoreState = true
                    launchSingleTop = true

                }
            }
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = NavigationItem.Screen3.icon),
                    contentDescription = null,
                )
            },
            label = { Text(text = "Notice") },
            selectedContentColor = Color.Cyan,
            unselectedContentColor = Color.Gray,
            selected = (currentRoute == NavigationItem.Screen3.screenRoute),
            alwaysShowLabel = false,
            onClick = {
                navController.navigate(NavigationItem.Screen3.screenRoute){
                    restoreState = true
                    launchSingleTop = true

                }
            }
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = NavigationItem.Screen4.icon),
                    contentDescription = null,
                )
            },
            label = { Text(text = "MyPage") },
            selectedContentColor = Color.Cyan,
            unselectedContentColor = Color.Gray,
            selected = (currentRoute == NavigationItem.Screen4.screenRoute),
            alwaysShowLabel = false,
            onClick = {
                navController.navigate(NavigationItem.Screen4.screenRoute){
                    restoreState = true
                    launchSingleTop = true
                }
            }
        )
    }
}