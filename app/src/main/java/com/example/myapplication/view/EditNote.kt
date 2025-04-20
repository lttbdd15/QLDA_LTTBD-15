package com.example.myapplication.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.model.data.AppDatabase
import com.example.myapplication.model.data.Note
import com.example.myapplication.ui.theme.ButtonColor
import com.example.myapplication.ui.theme.TextInButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topic(topic: String, onValueChange: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { newValue ->
            text = newValue
            onValueChange(newValue) // Gọi hàm callback
        },
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        shape = RoundedCornerShape(20.dp),
        label = { Text(topic) },
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(content: String, onValueChange: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { newValue ->
            text = newValue
            onValueChange(newValue) // Gọi hàm callback
        },
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 100.dp).fillMaxSize(),
        shape = RoundedCornerShape(20.dp),
        label = { Text(content) },
        colors = TextFieldDefaults.textFieldColors(unfocusedIndicatorColor = Color.Transparent)
    )
}


@Composable
fun MainEditNoteScreen(modifier: Modifier=Modifier,navController: NavController){
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column (modifier=modifier.fillMaxSize()){
        Row {
            BackButton(
                navController
            )
            val titlemain="Edit Note"
            Title(titlemain)
        }

        val topic = "Title"
        Topic(topic){ newTitle -> title = newTitle }

        val contentbox="Content"
        Content(contentbox){ newContent -> content = newContent }

    }
    Box(modifier= modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter){
        Button(onClick = { saveToLocalDatabase(context, title, content)
                            Toast.makeText(context,"Saved", Toast.LENGTH_LONG).show()
                         navController.navigate("RecentNotesScreen")
                         },
            colors = ButtonDefaults.buttonColors(Color(ButtonColor)),
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, bottom = 20.dp)) {

            Text("Save", color = Color(TextInButton))
        }
    }
}
fun saveToLocalDatabase(context: Context, title: String, content: String) {
    val note = Note(topic = title, content = content)
    val db = AppDatabase.getDatabase(context)

    CoroutineScope(Dispatchers.IO).launch {
        db.noteDao().insert(note)
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewEditNote(){
    val navController= rememberNavController()
    MainEditNoteScreen(navController=navController)
}