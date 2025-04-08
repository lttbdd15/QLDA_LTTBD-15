package com.example.myapplication.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topic(topic:String){
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { newValue-> text=newValue},
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        shape = RoundedCornerShape(20.dp),
        label = { Text(topic) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        )
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(content:String){
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { newValue-> text=newValue},
        modifier = Modifier.padding(20.dp).fillMaxSize(),
        shape = RoundedCornerShape(20.dp),
        label = { Text(content) },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            )
        )
}


@Composable
fun MainEditNoteScreen(modifier: Modifier=Modifier,navController: NavController){
    Column (modifier=modifier.fillMaxSize()){
    Row {
        BackButton()
        val title="Edit Note"
        Title(title)
        }

        val topic = "Title"
        Topic(topic)

        val content="Content"
        Content(content)
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewEditNote(){
    val navController= rememberNavController()
    MainEditNoteScreen(navController=navController)
}
