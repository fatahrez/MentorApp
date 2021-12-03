package com.fatah.leadershipapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatah.leadershipapp.ui.theme.*

@Composable
fun HomeScreen() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val greenPoint1 = Offset(width.toFloat(), height*0.65f)
        val greenPoint2 = Offset(-width.toFloat(), height * 0.65f)

        val greenColoredPath = Path().apply {
            moveTo(greenPoint1.x, greenPoint1.y)
            standardQuadFromTo(greenPoint1, greenPoint2)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat())
            close()
        }
        
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                color = SecondaryGreen,
                topLeft = greenPoint2
            )
        }

        Column (
            modifier = Modifier.padding(16.dp)
        ){
            TopMenuSection()
            Spacer(modifier = Modifier.padding(16.dp))
            SearchSection()
            Spacer(modifier = Modifier.padding(16.dp))
            ContentSection(
                listOf(
                    Content(
                        "Evaluation of your skills",
                        "Alfred Neal",
                        R.drawable.woman,
                        "8 min",
                        false,
                        "https://images.unsplash.com/photo-1600880292203-757bb62b4baf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80"
                    ),
                    Content(
                        "Track your Progress",
                        "Amstronge",
                        R.drawable.female_doctor,
                        "5 min",
                        true,
                        "https://images.unsplash.com/photo-1531482615713-2afd69097998?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80"
                    )
                )
            )
        }
    }
}

@Composable
fun TopMenuSection() {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ){
        Box (
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(50))
                .background(ButtonBlue)
                .padding(8.dp)

        ){
            val painter = painterResource(id = R.drawable.menu)
            Icon(
                painter = painter,
                contentDescription = "menu"
            )
        }
        Text(
            text = "Home",
            style = MaterialTheme.typography.h2
        )
        Row (
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){
            val bellPainter = painterResource(id = R.drawable.bell)
            val profilePainter = painterResource(id = R.drawable.woman)
            Box(
                modifier = Modifier
                    .size(25.dp)
            ) {
                Icon(painter = bellPainter, contentDescription = "Notifications")
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(50))
            ) {
                Image(
                    painter = profilePainter,
                    contentDescription = "Profile",
                    Modifier
                        .background(SecondaryGreen)
                        .padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun SearchSection() {
    Column {
        Text(
            text = "Hallo Fatah",
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Row {
            Text(
                text = "Learn Leadership Training ",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Now",
                style = MaterialTheme.typography.subtitle1
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Searchbar()
    }
    
}

@Composable
fun Searchbar() {
    var textFieldState by remember {
        mutableStateOf("")
    }
    Row {
        Row (
            modifier = Modifier.clip(RoundedCornerShape(12.dp))
        ){
            Button(
                onClick = {},
                shape = RoundedCornerShape(20, topEndPercent = 0, bottomEndPercent = 0, 20),
                border = BorderStroke(0.75.dp, color = Color.Black),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, backgroundColor = GreyText),
                modifier = Modifier
                    .size(56.dp)
            ) {
                val searchPainter = painterResource(id = R.drawable.search)
                Icon(painter = searchPainter, contentDescription = "search")
            }
            TextField(
                value = textFieldState,
                onValueChange = {
                    textFieldState = it
                },
                label = {
                        Text(text = "Search")
                },
                shape = RoundedCornerShape(0, 20, 20, 0),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                ),
                modifier = Modifier
                    .width(230.dp)
                    .border(0.75.dp, color = Color.Black)
            )
        Spacer(modifier = Modifier.padding(5.dp))

        }
        
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(20),
            border = BorderStroke(0.75.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(contentColor = Color.White, backgroundColor = ButtonBlue),
            modifier = Modifier
                .size(56.dp)
        ) {
            val filterPainter = painterResource(id = R.drawable.outline_filter_list_24)
            Icon(painter = filterPainter, contentDescription = "painter")
        }

    }
}

@Composable
fun ContentSection(
    contents: List<Content>
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "Latest Content",
            style = MaterialTheme.typography.subtitle1
        )

        Box(modifier = Modifier.size(32.dp)) {
            val morePainter = painterResource(id = R.drawable.more)
            Icon(painter = morePainter, contentDescription = "more content")
        }
    }

    LazyColumn() {
        items(contents.size) {
            ContentBox(content = contents[it])
        }
    }
}

@Composable
fun ContentBox(
    content: Content
) {
    Box(
        modifier = Modifier
            .size(250.dp, 80.dp)
            .clip(RoundedCornerShape(20))
            .border(1.dp, Color.Black)
    ) {
        Column {
            Text(
                text = content.title,
                style = MaterialTheme.typography.subtitle1
            )
            
            Row {
                Box(modifier = Modifier.size(20.dp)) {
                    val publisherIcon = painterResource(id = content.publisherIcon)
                    Image(painter = publisherIcon, contentDescription = content.publisher)
                }

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = content.publisher,
                    style = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Box(modifier = Modifier.size(18.dp)) {
                    val timeIcon = painterResource(id = R.drawable.chronometer)
                    Image(painter = timeIcon, contentDescription = content.time)
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = content.time,
                    style = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.padding(8.dp))
                Box(modifier = Modifier.size(18.dp)) {
                    val heartIcon = painterResource(id = R.drawable.heart_black)
                    Image(painter = heartIcon, contentDescription = content.time)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
//    HomeScreen()
}