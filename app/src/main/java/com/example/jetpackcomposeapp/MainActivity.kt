package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import com.example.jetpackcomposeapp.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val versionOne = "VersionOne"
private const val versionTwo = "VersionTwo"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreen(mainViewModel = mainViewModel)
            }
        }
       
    }
    
}


@Composable
fun MyScreen(mainViewModel: MainViewModel?) {
    var chooserState by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxHeight()) {
        NamedList(names = List(1000) { "Android Development" }, modifier = Modifier.weight(1f))
        Chooser {
            chooserState = it
        }

        if (chooserState == versionOne) {
            mainViewModel!!.printVersionOne()
        } else if (chooserState == versionTwo) {
            mainViewModel!!.printVersionTwo()
        }
        chooserState = ""
    }
}

@Composable
fun NamedList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(items = names) {
            Greeting(name = it)
            Divider()
        }
    }
}

@Composable
fun Chooser(updateChoice: (String) -> Unit) {
    Button(onClick = { updateChoice(versionOne) }) {
        Text(text = "Version One")
    }

    Button(onClick = { updateChoice(versionTwo) }) {
        Text(text = "Version Two")
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackComposeAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }

    val targetColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colors.primary else Color.White,
        tween(durationMillis = 4000)
    )

    Text(
        text = "Hello $name!", modifier = Modifier
            .padding(20.dp)
            .background(color = targetColor)
            .clickable {
                isSelected = !isSelected
            }
            .height(30.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreen(mainViewModel = null)
    }
}

