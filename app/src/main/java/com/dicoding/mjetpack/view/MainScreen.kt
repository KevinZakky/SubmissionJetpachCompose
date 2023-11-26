package com.dicoding.mjetpack.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicoding.mjetpack.data.HeroesData
import com.dicoding.mjetpack.ui.theme.MJetpackTheme


// Import statements ...

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainApp(
    modifier: Modifier = Modifier,

) {

    val navController = rememberNavController()
    val detailNavController = rememberNavController()
    val profileNavController = rememberNavController()

    NavHost(navController, startDestination = "main") {
        composable("main") {
            Box(modifier = modifier) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Dicoding") },
                            actions = {
                                // Icon for switching to profile screen
                                IconButton(onClick = {
                                    // Handle click on profile icon
                                    navController.navigate("profile")
                                }) {
                                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                                }
                            }
                        )
                    },
                    content = {
                        LazyColumn(
                            modifier = Modifier
                                .padding(top = 70.dp)
                        ) {
                            items(HeroesData.heroes) { hero ->
                                MainScreen(
                                    name = hero.name,
                                    photo = hero.photo,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate("detail/${hero.name}") }
                                ) {
                                    navController.navigate("detail/${hero.name}")
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                )
            }
        }
        composable("detail/{heroName}") { backStackEntry ->
            val heroName = backStackEntry.arguments?.getString("heroName")
            val food = HeroesData.heroes.firstOrNull { it.name == heroName }
            if (food != null) {
                DetailScreen(hero = food, modifier = Modifier.fillMaxWidth(), navController = detailNavController)
            } else {
                // Handle if the hero is not found
            }
        }
        composable("profile") {
                ProfileScreen(navController = profileNavController)
        }
    }
}

// Rest of the code...


@Composable
fun MainScreen(name: String, photo: Int, modifier: Modifier, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Image(painter = painterResource(photo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(text = name,
            fontWeight = FontWeight.Medium, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun RecyclePreview(){
    val navController = rememberNavController()
    MJetpackTheme {
        MainApp()
    }
}