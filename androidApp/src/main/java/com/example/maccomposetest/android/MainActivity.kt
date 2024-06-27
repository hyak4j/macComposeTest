package com.example.maccomposetest.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.maccomposetest.android.components.Content
import com.example.maccomposetest.android.components.Header
import com.example.maccomposetest.android.repository.CalendarDataSource
import com.jakewharton.threetenabp.AndroidThreeTen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalendarAppPreview()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun CalendarAppPreview() {
    CalendarApp(
        modifier = Modifier.padding(
            top = 2.dp,
            bottom = 2.dp,
            start = 16.dp,
            end = 0.dp
        )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarApp(modifier: Modifier = Modifier) {
    val dataSource = CalendarDataSource()
    // get CalendarUiModel from CalendarDataSource, and the lastSelectedDate is Today.
    val calendarUiModel = dataSource.getData(lastSelectedDate = dataSource.today)
    Column(modifier = modifier.fillMaxSize()) {
        Header(data = calendarUiModel)
        Content(data = calendarUiModel)
    }
}
