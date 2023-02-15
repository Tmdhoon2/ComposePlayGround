package com.example.composeplayground.navigationcomponent

import com.example.composeplayground.R

sealed class NavigationItem(
    val title: String,
    val icon: Int,
    val screenRoute: String,
){
    object Screen1: NavigationItem(
        title = "Screen1",
        icon = R.drawable.baseline_home_24,
        screenRoute = "Screen1",
    )

    object Screen2: NavigationItem(
        title = "Screen2",
        icon = R.drawable.baseline_calendar_today_24,
        screenRoute = "Screen2",
    )

    object Screen3: NavigationItem(
        title = "Screen3",
        icon = R.drawable.baseline_notifications_active_24,
        screenRoute = "Screen3",
    )

    object Screen4: NavigationItem(
        title = "Screen4",
        icon = R.drawable.baseline_person_24,
        screenRoute = "Screen4",
    )
}