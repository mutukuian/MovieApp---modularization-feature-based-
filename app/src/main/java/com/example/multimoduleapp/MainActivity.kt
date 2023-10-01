package com.example.multimoduleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.multimoduleapp.navigation.AppNavGraph
import com.example.multimoduleapp.navigation.NavigationProvider
import com.example.multimoduleapp.ui.theme.MultiModuleAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                   val navController = rememberNavController()
                   App(navHostController = navController,navigationProvider)
                }
            }
        }
    }
}

@Composable
fun App(navHostController: NavHostController, navigationProvider: NavigationProvider){
    Surface(
        modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
    ) {
       AppNavGraph(navController = navHostController, navigationProvider = navigationProvider)
    }
}





