package com.example.myapplication.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

public class NavigationForAll {
    fun getStartedToLogin(navController: NavController){ // Đã sửa tên hàm
        navController.navigate("LoginScreen")
    }
    @Composable
    fun CreateFirstNote_To_EditNote(navController: NavController) { // Truyền navController vào
        navController.navigate("EditNoteScreen")
    }
    @Composable
    fun CreateFirstNote_To_UserProfile(navController: NavController) { // Truyền navController vào
        navController.navigate("UserProfileScreen")
    }
    @Composable
    fun RecentNote_To_EditNote(navController: NavController) { // Truyền navController vào
        navController.navigate("EditNoteScreen")
    }

    @Composable
    fun RecentNote_To_UserProfile(navController: NavController) { // Truyền navController vào
        navController.navigate("UserProfileScreen")
    }
    @Composable
    fun BackButton(navController: NavController){ // Truyền navController vào
        navController.popBackStack()
    }

    @Composable
    fun Login_To_CreateFirstNote(navController: NavController){
        navController.navigate("RecentNotesScreen")
    }
}