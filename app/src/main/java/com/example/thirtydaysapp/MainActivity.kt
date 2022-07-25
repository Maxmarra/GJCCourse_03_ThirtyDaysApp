package com.example.thirtydaysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysapp.model.Day
import com.example.thirtydaysapp.ui.theme.ThirtyDaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysApp()
                }
            }
        }
    }
}

@Composable
fun ThirtyDaysApp() {
    DayList(days = Repository.days)
}

@Composable
fun DayList(days: List<Day>, modifier: Modifier = Modifier) {
    LazyColumn(content = {
        items(days){
            DayItem(day = it)   
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayItem(day: Day, modifier: Modifier = Modifier) {
    Card(
        onClick = { /*TODO*/ }
    ) {
       Column() {
           Text(text =  "День ${day.day}")
           Text(text = stringResource(id = day.affirmation))
           Image(painter = painterResource(id = day.image), contentDescription = null)
           Text(text = stringResource(id = day.description))
       }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultDayPreview() {
    ThirtyDaysAppTheme {
        DayItem(
            Day(
                day = "1",
                affirmation = R.string.affirmation1,
                image = R.drawable.image1,
                description = R.string.description1
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultDayListPreview() {
    ThirtyDaysAppTheme {
        DayList(days = Repository.days)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThirtyDaysAppTheme {
        ThirtyDaysApp()
    }
}