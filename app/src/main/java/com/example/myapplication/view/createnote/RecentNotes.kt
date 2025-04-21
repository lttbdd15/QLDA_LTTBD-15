package com.example.myapplication.view.createnote

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.model.data.AppDatabase
import com.example.myapplication.model.data.Note
import com.example.myapplication.ui.theme.TextInButton
import com.example.myapplication.ui.theme.singleCardColor
import com.example.myapplication.view.Title
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



@Composable
fun Content(title: String, content: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(10.dp).fillMaxWidth()) {
        Text(text = title,
            textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = content,
            textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
    }
}


@Composable
fun AddButton(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(R.drawable.button_add),
            contentDescription = "AddButton",
            modifier = Modifier.size(100.dp).clickable { navController.navigate("EditNoteScreen") }
        )
    }
}

@Composable
fun FrameContent(notes: List<Note>) {
    Column(
        modifier = Modifier
            .fillMaxSize() // Column fills the screen
            .padding(16.dp) // Padding around the whole content
    ) {
        // "All Notes" Header
        Text(
            text = "All Notes",
            fontSize = 24.sp, // Kích thước chữ
            fontWeight = FontWeight.Bold, // Chữ đậm
            modifier = Modifier
                .padding(bottom = 16.dp) // Khoảng cách dưới tiêu đề
                .fillMaxWidth() // Chiếm toàn bộ chiều rộng
        )

        // Using LazyVerticalGrid for a 2-column grid layout
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 cột cố định
            modifier = Modifier.fillMaxSize(), // Grid fills the remaining space
            contentPadding = PaddingValues(8.dp), // Padding inside the grid
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Khoảng cách ngang giữa các item
            verticalArrangement = Arrangement.spacedBy(8.dp) // Khoảng cách dọc giữa các item
        ) {
            items(notes) { note ->
                // Use the single defined color for all cards
                NoteCardSimple(note = note, backgroundColor = singleCardColor)
            }
        }
    }
}
@Composable
fun NoteCardSimple(note: Note, backgroundColor: Color) {
    // Using Card composable for styling
    Card(
        modifier = Modifier
            .widthIn(min = 150.dp, max = 250.dp) // Adjust width as needed
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp), // Bo góc
        colors = CardDefaults.cardColors(containerColor = backgroundColor), // Màu nền của card
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // Thêm bóng nhẹ
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp) // Padding bên trong card
        ) {
            // Display the title
            Text(text = note.topic,
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                color = Color(TextInButton))
            Spacer(modifier = Modifier.height(4.dp)) // Khoảng cách giữa title và content

            // Display the content - Basic handling for list format
            val lines = note.content.split("\n").filter { it.isNotBlank() }
            if (lines.size > 1 && (lines.first().startsWith("1.") || lines.first().startsWith("-"))) {
                // Assuming list format if multiple lines and starts with "1." or "-"
                Column {
                    lines.forEach { line ->
                        Text(text = line, color = Color(TextInButton))
                    }
                }
            } else {
                // Otherwise, display as plain text
                Text(text = note.content,color = Color(TextInButton))
            }
        }
    }
}


@Composable

fun MainRecentNotesScreen(modifier: Modifier=Modifier,navController: NavController){
    var notes by remember { mutableStateOf(listOf<Note>()) }
    LaunchedEffect(Unit) {
        val db = AppDatabase.getDatabase(navController.context)
        CoroutineScope(Dispatchers.IO).launch {
            notes = db.noteDao().getAllNotes() // Lấy tất cả ghi chú từ cơ sở dữ liệu
        }
    }
    Column (modifier= modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (modifier= Modifier.fillMaxWidth()){
            OptionButton(navController)

            val title="All Notes"
            Title(title)
            Spacer(Modifier.weight(1f))
        }
        FrameContent(notes)
    }
    AddButton(navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewRecentNote(){
    val navController= rememberNavController()
    MainRecentNotesScreen(navController=navController)
}