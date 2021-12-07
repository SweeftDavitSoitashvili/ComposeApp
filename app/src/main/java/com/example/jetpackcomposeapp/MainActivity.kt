package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
fun MyScreen(names: List<String> = listOf("Android", "Developers"), mainViewModel: MainViewModel?) {

    var chooserState by remember {
        mutableStateOf("")
    }

    Column {
        for (name in names) {
            Greeting(name = name)
            Divider()
        }

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
    Text(
        text = "Hello $name!", modifier = Modifier
            .padding(20.dp)
            .background(Color.Green)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreen(mainViewModel = null)
    }
}

