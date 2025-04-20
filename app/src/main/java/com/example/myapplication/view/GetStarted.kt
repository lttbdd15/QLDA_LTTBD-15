package com.example.myapplication.view
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.myapplication.ui.theme.ButtonColor
import com.example.myapplication.ui.theme.TextInButton
import com.example.myapplication.ui.theme.TextTitle
import com.example.myapplication.view.navigation.NavigationForAll




val navigationForAll = NavigationForAll()


@Composable
fun Title(title: String){
    Text(title,
        color = Color(TextTitle),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
        fontWeight = FontWeight(1000),
        fontSize = 25.sp)
}

@Composable

fun LogoUth(){
    Image(painter = painterResource(R.drawable.bg_logouth),
        contentDescription = "icon content",
        modifier = Modifier.
        height(200.dp).
        fillMaxWidth().
        padding(top = 118.dp))
}


@Composable
fun Content(titlecotent:String,content:String){
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()){

        Text(titlecotent, textAlign = TextAlign.Center,
            fontWeight = FontWeight(800),
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 34.dp,end=34.dp),)
        Text(content,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier.width(305.dp),)
    }
}



@Composable
fun ButtonGetStarted(navController: NavController,content:String){
    Button(onClick = {navigationForAll.getStartedToLogin(navController)}
        , modifier = Modifier.fillMaxWidth()
            .padding(top = 88.dp,start = 28.dp, end = 28.dp)
            .height(74.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(Color(ButtonColor), contentColor = Color(TextInButton))
    ){
        Text(content,
            fontWeight = FontWeight(800),
            fontSize = 20.sp)
    }
}



@Composable
fun  MainGetStartedScreen(modifier: Modifier = Modifier,navController: NavController){
    Column(
        modifier = modifier.fillMaxSize()

    )  {

        LogoUth()

        val titlecontent="World’s Safest And Largest Digital Notebook"
        val content="Notely is the world’s safest, largest and intelligent digital notebook. Join over 10M+ users already using Notely."
        Content(titlecontent,content)


        val contentbutton="GET STARTED"
        ButtonGetStarted(navController,contentbutton)
    }

}


@Composable
@Preview(showBackground = true)
fun PreviewMainGetStarted(){
    val navController = rememberNavController()
    MainGetStartedScreen(navController = navController)
}