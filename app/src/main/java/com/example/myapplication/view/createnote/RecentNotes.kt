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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.view.Title


data class ContentData(val title: String, val content: String)

@Composable
fun Content(title: String, content: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(10.dp).fillMaxWidth()) {
        Text(text = title, style = androidx.compose.material.MaterialTheme.typography.h6,
            textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = content,
            textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
    }
}

fun rowData(): List<Pair<ContentData, ContentData>> {
    val rowDataList = listOf(
        Pair(
            ContentData("Meeting 1", "Review actions"),
            ContentData("Task A", "Do this now")
        ),
        Pair(
            ContentData("Report Update", "Progress summary"),
            ContentData("Idea B", "Consider this")
        ),
        Pair(
            ContentData("User Feedback", "New insights"),
            ContentData("Bug C", "Needs fixing")
        ),
        Pair(
            ContentData("Planning", "Next steps"),
            ContentData("Feature D", "Start development")
        ),
        Pair(
            ContentData("Coffee Break", "Recharge time"),
            ContentData("Learning", "Explore new tech")
        )
    )
    return rowDataList
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
fun FrameContent() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(rowData()) { item ->
            Column   {
            Content(title = item.first.title, content = item.first.content)
            Content(title = item.second.title, content = item.second.content)
            }
        }
    }
}

@Composable
fun MainRecentNotesScreen(modifier: Modifier=Modifier,navController: NavController){
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
     FrameContent()
    }
    AddButton(navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewRecentNote(){
    val navController= rememberNavController()
    MainRecentNotesScreen(navController=navController)
}