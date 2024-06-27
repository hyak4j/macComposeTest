package com.example.maccomposetest.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.maccomposetest.Greeting
import com.example.maccomposetest.android.components.Content
import com.example.maccomposetest.android.components.Header

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

@Composable
fun CalendarApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Header()
        Content()
    }
}
