package com.example.librarytimer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNav(){

    val navController = rememberNavController()
    val isOnOff = remember{ mutableStateOf(false) }

    val libHourTen = remember{ mutableStateOf(0) }
    val libHourOne = remember{ mutableStateOf(0) }
    val libMinTen = remember{ mutableStateOf(0) }
    val libMinOne = remember{ mutableStateOf(0) }

    val expendHourTen = remember{ mutableStateOf(0) }
    val expendHourOne = remember{ mutableStateOf(0) }
    val expendMinTen = remember{ mutableStateOf(0) }
    val expendMinOne = remember{ mutableStateOf(0) }

    NavHost(
        modifier = Modifier.fillMaxSize(),
        startDestination = "home",
        navController = navController
    ) {
        composable("home"){
            Home(
                isOnOff = isOnOff,
                navController = navController
            )
        }

        composable("setting"){
            Setting(
                navController = navController,
                libHourTen,
                libHourOne,
                libMinTen,
                libMinOne,
                expendHourTen,
                expendHourOne,
                expendMinTen,
                expendMinOne
            )
        }
    }
}