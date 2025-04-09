package com.example.myapplication.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
val loginscreen="LoginScreen"
val editnotescreen="EditNoteScreen"
val userprofilescreen="UserProfileScreen"

val getstartedscreen="GetStartedScreen"
val createfirstscreen="CreateFirstNoteScreen"
val recentnotesscreen="RecentNotesScree"
class NavigationForAll {
    fun getStartedToLogin(navController: NavController){ // Đã sửa tên hàm
        navController.navigate(loginscreen)
    }
    @Composable
    fun CreateFirstNote_To_EditNote(navController: NavController) { // Truyền navController vào
        navController.navigate(editnotescreen)
    }
    @Composable
    fun CreateFirstNote_To_UserProfile(navController: NavController) { // Truyền navController vào
        navController.navigate(userprofilescreen)
    }
    @Composable
    fun RecentNote_To_EditNote(navController: NavController) { // Truyền navController vào
        navController.navigate(editnotescreen)
    }

    @Composable
    fun RecentNote_To_UserProfile(navController: NavController) { // Truyền navController vào
        navController.navigate(userprofilescreen)
    }
    @Composable
    fun BackButton(navController: NavController){ // Truyền navController vào
        navController.popBackStack()
    }
}