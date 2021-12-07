package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreen()
            }
        }
    }
}

@Composable
fun MyScreen(names : List<String> = listOf("Android", "Developers")) {

    var counter by remember {
        mutableStateOf(0)
    }

    Column {
        for (name in names) {
            Greeting(name = name)
            Divider()
        }

        Counter(counter) { newCount ->
            counter = newCount
        }

        if (counter > 5) {
            Text(text = "Counter is more tha 5")
        } else {
            Text(text = "Counter is less than five")
        }
    }
}

@Composable
fun Counter(count : Int, updateCount : (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "The button has been click $count times")
    }
}

@Composable
fun MyApp(content : @Composable () -> Unit) {
    JetpackComposeAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier
        .padding(20.dp)
        .background(Color.Green))

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreen()
    }
}