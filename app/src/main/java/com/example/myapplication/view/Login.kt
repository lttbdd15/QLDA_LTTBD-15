package com.example.myapplication.view
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.ButtonColor
import com.example.myapplication.ui.theme.TextInButton
import com.example.test.googlesignin.GoogleAuthClient
import kotlinx.coroutines.launch




@Composable
fun LogoIcon(){
    Image(painter = painterResource(R.drawable.bg_logouth),
        contentDescription = "Logo uth",
        modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .padding(top = 106.dp, start = 30.dp,end = 30.dp))
}
@Composable

fun ButtonSignInWithGoogle(googleAuthClient: GoogleAuthClient, navController: NavController){
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Button(onClick = {
        scope.launch {
            val signedIn = googleAuthClient.signIn()
            if (signedIn) {
                navController.navigate("RecentNotesScreen")
                Toast.makeText(context, "Sign in successful", Toast.LENGTH_LONG).show()

                println("Google Sign-in successful from UI")
            } else {
                Toast.makeText(context, "Sign in failed", Toast.LENGTH_LONG).show()
                println("Google Sign-in failed from UI")
            }
        }
    },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.height(50.dp)
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp),
        colors = ButtonDefaults.buttonColors(Color(ButtonColor),
            contentColor = Color(TextInButton)
        )
    ) {
        Row {

            Image(
                painter = painterResource(R.drawable.ic_google),
                contentDescription = "logo google",
                modifier = Modifier.width(16.dp).height(20.dp)
            )

            Text("Sign in with Google",
                Modifier.padding(start = 5.dp))

        }
    }
}



@Composable
fun MainLoginScreen(modifier: Modifier=Modifier,navController: NavController){
    val context = LocalContext.current
    val googleAuthClient = remember { GoogleAuthClient(context) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier){
        LogoIcon()


        Spacer(Modifier.weight(1f))
        val titlecontent="Welcome"
        val content="Ready to explore? Log in to get started."
        Content(titlecontent,content)
        ButtonSignInWithGoogle(googleAuthClient = googleAuthClient, navController = navController)
        Spacer(Modifier.weight(1f))
        // Giới thiệu project
        Text("© UTHNoteProject")
    }
}


@Composable
@Preview(showBackground = true  )
fun PreviewMainLoginScreen(){
    val navController = rememberNavController()
    MainLoginScreen(navController = navController)
}