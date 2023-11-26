package com.dicoding.mjetpack.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dicoding.mjetpack.R
import com.dicoding.mjetpack.ui.theme.MJetpackTheme


@Composable
fun ProfileScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 36.dp)
    ){
        Column {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Kevin Zakky",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text ="Email       :  kevinzakky9gmailcom@webmail.umm.ac.id",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp, start = 36.dp)
            )
            Text(
                text = "Github      :  kevinZakky",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp, top = 16.dp, end = 250.dp)
            )
        }

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ProfilePreview(){
    val navController = rememberNavController()
    MJetpackTheme {
        ProfileScreen(navController = navController)
    }
}