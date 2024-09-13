package com.example.slidertest

import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.slidertest.ui.theme.SlidertestTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlidertestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    .padding(16.dp)) { innerPadding ->
                    Column {
                        SliderFarenheit()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun SliderFarenheit() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var secondSliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Text(
            "Farenheit"
        )
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it
                            secondSliderPosition = (5f/9f)*(it-32f)
                            if (sliderPosition <32) {
                                sliderPosition = 32f
                            }
                            if (secondSliderPosition <0){
                            secondSliderPosition = 0f
                }},
            steps = 211,
        valueRange = 0f..212f

        )

        Text(
            text = ("%.1f".format(sliderPosition))
        )

        Text("Celcius")

        Slider(
            value = secondSliderPosition,
            onValueChange = { secondSliderPosition = it
                            sliderPosition = (9f/5f)*it+32f
                            },
            steps = 99,
            valueRange = 0f..100f
        )
        Text(
            text = ("%.1f".format(secondSliderPosition))
        )
            if(secondSliderPosition <= 20 ) {
                Text (
            text = "I wish it were warmer." ) }
                    else {
                Text(
                    text = "I wish it were colder."
                )
            }
        }
}


@Preview
@Composable
fun SliderCelcius() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 99,
            valueRange = 0f..100f
        )

        Text(text = (sliderPosition).toInt().toString())
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlidertestTheme {
        Greeting("Android")
    }
}