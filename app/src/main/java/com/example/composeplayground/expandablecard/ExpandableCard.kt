package com.example.composeplayground.expandablecard

import android.graphics.drawable.Icon
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard() {
    var expandableState by remember { mutableStateOf(false) }
    val roationState by animateFloatAsState(
        targetValue = if(expandableState) 180f else 0f
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            expandableState = !expandableState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = "Title",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(roationState),
                    onClick = { expandableState = !expandableState },

                    ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                    )
                }
            }
            AnimatedVisibility(visible = expandableState) {
                Text(
                    text = "Hello my name is Seung hoon Jung, I am working at Daedeok Software\n" +
                            "high school I 'm best android developer apple is dead",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Composable
@Preview(
    showSystemUi = true,
)
fun Preview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        ExpandableCard()
    }
}