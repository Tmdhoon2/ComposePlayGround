package com.example.composeplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.ComposePlayGroundTheme

class CodeLab1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlayGroundTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
) {
    var shouldShowOboarding by remember {
        mutableStateOf(true)
    }

    Surface(modifier) {
        if (shouldShowOboarding) {
            OnboardingScreen(
                onContinueClicked = { shouldShowOboarding = false }
            )
        } else {
            Greetings()
        }
    }
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit,
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked,
        ){
            Text("Continue")
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose"),
){
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Preview(
    showBackground = true,
    name = "Text Preview",
    showSystemUi = false,
    widthDp = 320,
)
@Composable
private fun DefaultPreview() {
    ComposePlayGroundTheme {
        MyApp()
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320,
)
@Composable
fun OnboardingPreview(){
    ComposePlayGroundTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Composable
private fun Greeting(
    name: String,
) {
    val expanded = remember { mutableStateOf(false) }

    val extraPadding = if(expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.error,
        modifier = Modifier.padding(
            vertical = 4.dp,
            horizontal = 8.dp,
        )
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello,")
                Text(text = "$name")

            }
            Button(
                onClick = { expanded.value = !expanded.value },
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
)
@Composable
private fun GreetingsPreview(){
    ComposePlayGroundTheme() {
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview(){
    ComposePlayGroundTheme {
        MyApp(Modifier.fillMaxSize())
    }
}