package com.dreamteam2.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.dreamteam2.weatherapp.ui.theme.WeatherAppTheme


class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel = MainViewModel()
    val secondView: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(viewModel)
                    currTemperature(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: MainViewModel) {
//    Check for status of API
//    val status by viewModel.status.collectAsState()
//    status?.let{
//        Text(text = it.status)
//    }?: Text(text = "Loading...")
/*
    val gridPointEndpoints by viewModel.gridPointEndpoints.collectAsState()
    gridPointEndpoints?.let{
        Text(text = it.properties.radarStation.toString())
    }?: Text(text = "Loading...")
*/




}

@Composable
fun currTemperature(viewModel: MainViewModel) {
    //for (i in 0..13){
    val foreCastPointEndpointTemperature by viewModel.forecastEndPoints.collectAsState()
    Column() {
        foreCastPointEndpointTemperature?.let {
            for (i in 0..13) {
                Text(text = "Day " + i + ": " + it.propertiesInForecast?.period?.get(i)?.temperature.toString() + "°F")
            }
        } ?: Text(text = "Loading...")
    }
}

