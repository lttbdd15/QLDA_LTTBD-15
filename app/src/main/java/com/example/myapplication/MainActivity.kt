package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.view.createnote.MainCreateFirstNoteScreen
import com.example.myapplication.view.MainEditNoteScreen
import com.example.myapplication.view.MainGetStartedScreen
import com.example.myapplication.view.MainLoginScreen
import com.example.myapplication.view.createnote.MainRecentNotesScreen
import com.example.myapplication.view.MainUserProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val modifier = Modifier.padding(innerPadding)
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "GetStartedScreen") {
                        composable("GetStartedScreen") { MainGetStartedScreen(modifier = modifier, navController =navController) }
                        composable("LoginScreen") { MainLoginScreen(modifier = modifier, navController = navController) }
                        composable("CreateFirstNoteScreen") { MainCreateFirstNoteScreen(modifier = modifier, navController = navController) }
                        composable("EditNoteScreen") { MainEditNoteScreen(modifier = modifier, navController = navController) }
                        composable("RecentNotesScreen") { MainRecentNotesScreen(modifier = modifier, navController = navController) }
                        composable("UserProfileScreen") { MainUserProfileScreen(modifier = modifier, navController = navController) }
                    }

                }
            }
        }
    }
}