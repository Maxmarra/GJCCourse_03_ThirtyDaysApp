package com.example.thirtydaysapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysapp.model.Day
import com.example.thirtydaysapp.ui.theme.Cyan700
import com.example.thirtydaysapp.ui.theme.ThirtyDaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysAppTheme {
                ThirtyDaysApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysApp() {
    Scaffold(
        topBar = {
            DayTopBar()
        }
    ) {
        DayList(days = Repository.days)
    }
}

@Composable
fun DayTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth(),//sizeIn(maxHeight = 68.dp)
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_woof_logo),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp),
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Composable
fun DayList(days: List<Day>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 85.dp),//!!!!отодвигаемся от TopAppBar!
        content = {
            items(days) {
                DayItem(day = it)
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayItem(day: Day, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue =
        if (expanded) Cyan700
        else MaterialTheme.colorScheme.surface,
    )

    ElevatedCard(

        onClick = { expanded = !expanded },

        elevation = CardDefaults.cardElevation(15.dp),
        shape = Shapes().extraLarge,
        modifier = Modifier.padding(16.dp),
    ) {
        Column(
            modifier = Modifier
            .fillMaxWidth()
                .background(color = color)

                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )

            //.background(MaterialTheme.colorScheme.surface)
        ) {
            Text(
                text = "День ${day.day}",
                modifier = Modifier.padding(end = 16.dp, start = 16.dp, bottom = 1.dp, top = 1.dp),
                style = MaterialTheme.typography.headlineLarge

            )
            Text(
                text = stringResource(id = day.affirmation),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(end = 16.dp, start = 16.dp, bottom = 16.dp, top = 1.dp)

            )
            Image(

                painter = painterResource(id = day.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(
                        RoundedCornerShape(8)
                    )
            )
            Text(
                text = stringResource(id = day.description),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )

            if(expanded){
                Text(
                    text = stringResource(id = R.string.additional),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
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

@Preview
@Composable
fun DarkThemePreview() {
    ThirtyDaysAppTheme(darkTheme = true) {
        ThirtyDaysApp()
    }
}
