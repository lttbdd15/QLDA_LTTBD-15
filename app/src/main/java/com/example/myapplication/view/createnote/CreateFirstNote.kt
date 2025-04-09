package com.example.myapplication.view.createnote

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
//import com.example.myapplication.R
import com.example.myapplication.ui.theme.ButtonColor
import com.example.myapplication.ui.theme.TextInButton
import com.example.myapplication.view.Title

@Composable
fun OptionButton(navController: NavController){
    Image(
        painter = painterResource(R.drawable.ic_option),
        contentDescription = "option button",
        modifier = Modifier.
        padding(15.dp).
        height(20.dp).
        width(20.dp).
        clickable { navController.navigate("UserProfileScreen") }
    )
}

@Composable
fun IconBackground(){
    Image(
        painter = painterResource(R.drawable.createfirstnotebackgroundicon),
        contentDescription = "icon background",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ButtonCreateNote(navController: NavController){
    Button(onClick = {navController.navigate("EditNoteScreen")},
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 28.dp,
                end=28.dp, bottom = 80.dp).height(74.dp),
        shape = RoundedCornerShape(12),
        colors = ButtonDefaults.buttonColors(Color(ButtonColor)),
    ) {
        Text("Create A Note", color = Color(TextInButton))
    }
}


@Composable
fun MainCreateFirstNoteScreen(modifier: Modifier=Modifier,navController: NavController){
    Column (modifier= modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        Row (modifier=Modifier.fillMaxWidth()){
            OptionButton(navController)

            val title="All Notes"
            Title(title)
        }
        Spacer(modifier=Modifier.weight(1f))
        IconBackground()
        val title = "Create Your First Note"
        val content= "Add a note about anything (your thoughts on climate change, or your history essay) and share it with the world."
        Content(title, content)
        Spacer(modifier=Modifier.weight(1f))
        ButtonCreateNote(navController)
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewCreateFirstNote(){
    val navController = rememberNavController()
    MainCreateFirstNoteScreen(navController=navController)
}