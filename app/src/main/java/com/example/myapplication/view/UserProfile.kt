package com.example.myapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R


@Composable
fun BackButton(navController: NavController){
    Image(painter = painterResource(R.drawable.button_back),
        contentDescription = "Backbutton",
        modifier = Modifier.height(40.dp).width(40.dp).clickable { navController.navigate("RecentNotesScreen") })
}

@Composable
fun Avata(painter: Painter ){
    Box(contentAlignment = Alignment.TopStart, modifier = Modifier.padding(top = 40.dp)){
    Image(
        painter = painterResource(id = R.drawable.ic_avata),
        contentDescription = "Avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(140.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Blue, CircleShape)
    )
    Box(
        modifier = Modifier
            .size(50.dp)
            .offset(x = 100.dp, y = 100.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = "icon camera",
            modifier = Modifier.size(24.dp,24.dp)
        )

        }
    }
}


@Composable
fun ContentInfo(content:String,fontsize:Int){
    Text(content, modifier = Modifier.
        fillMaxWidth().padding(start = 10.dp),
        textAlign = TextAlign.Center,
        fontSize = fontsize.sp,
        fontWeight = FontWeight(700)
    )
}

@Composable
fun optionList(): List<Pair<Painter, String>> {
    val options = listOf(
        Pair(painterResource(R.drawable.ic_buypremium), "Buy Premium"),
        Pair(painterResource(R.drawable.ic_editprofile), "Edit Profile"),
        Pair(painterResource(R.drawable.ic_changetheme), "App Theme")
    )
    return options
    }
@Composable
fun Content_Userscreen(painter: Painter,content: String){
    Row (modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, top = 20.dp)){
        Image(painter = painter,
            contentDescription = "buy premium", modifier = Modifier.size(30.dp))
        Text(content, fontSize = 30.sp, modifier = Modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(R.drawable.ic_moveon),
            contentDescription = "move on", modifier = Modifier.size(30.dp))
    }

}




@Composable
fun OptionUserProfile(){
    Column(modifier = Modifier.padding(20.dp)) {
        optionList().forEach{
            option-> Content_Userscreen(option.first,option.second)
        }
    }
}


@Composable
fun MainUserProfileScreen(modifier: Modifier=Modifier,navController: NavController){
    Column  (modifier=modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
    Row (modifier=Modifier.fillMaxWidth()) {
        Spacer(modifier.weight(1f))
        BackButton(navController)
        Spacer(modifier.weight(1f))
        val title = "Profile"
        Title(title)
        }
        Avata(painterResource(R.drawable.ic_camera))


        val name = "Name"
        val fonsize=32
        ContentInfo(name,fonsize)

        val currentresidence="Current Residence"
        val fontsize=18
        ContentInfo(currentresidence,fontsize)


        OptionUserProfile()
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainUserProfile(){
    val navController = rememberNavController()
    MainUserProfileScreen(navController = navController)

}