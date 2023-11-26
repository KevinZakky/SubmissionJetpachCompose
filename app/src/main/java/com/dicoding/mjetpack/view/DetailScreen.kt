package com.dicoding.mjetpack.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.compose.rememberNavController
import com.dicoding.mjetpack.R
import com.dicoding.mjetpack.data.Hero
import com.dicoding.mjetpack.ui.theme.MJetpackTheme

@Composable
fun DetailApp(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val food = Hero("Bakpao", "Ini Bakpao", R.drawable.bakpao)

    Box(modifier = modifier){
        DetailScreen(hero = food, modifier = Modifier.fillMaxWidth(), navController)

    }

}

@Composable
fun DetailScreen(hero: Hero, modifier: Modifier = Modifier, navController: NavController) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, top = 36.dp)
        ) {
            Image(
                painter = painterResource(hero.photo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = hero.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            Text(
                text = hero.description,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailPreview(){
    val navController = rememberNavController()
    MJetpackTheme {
      DetailApp(navController = navController)
    }
}