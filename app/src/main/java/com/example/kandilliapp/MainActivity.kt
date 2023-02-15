package com.example.kandilliapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.kandilliapp.ui.theme.KandilliAppTheme
import com.example.kandilliapp.view.HomeScreen
import com.example.kandilliapp.viewModel.HomeScreenViewModel

class MainActivity : ComponentActivity() {

    private val homeScreenViewModel by viewModels<HomeScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KandilliAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    if (homeScreenViewModel.errorMessage) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Red), verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(modifier = Modifier, text = "Somethings go wrong..")
                        }
                    } else {
                        homeScreenViewModel.getEarthquakeList()

                        if (homeScreenViewModel.earthquakeListResponse.result.isNullOrEmpty()) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Yellow),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(modifier = Modifier, text = "Loading...")
                            }
                        } else {
                            HomeScreen(
                                earthquakeList = homeScreenViewModel.earthquakeListResponse.result,
                                homeScreenViewModel
                            )
                        }


                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KandilliAppTheme {

    }
}