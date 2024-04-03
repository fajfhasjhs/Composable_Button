@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tugas4

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugas4.ui.theme.Tugas4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tugas4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AplikasiSederhana()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AplikasiSederhana(modifier: Modifier = Modifier) {
    var panjangState by remember {
        mutableStateOf("")
    }
    var lebarState by remember {
        mutableStateOf("")
    }
    var hasilState by remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mencari Luas Persegi",
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Black
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 80.dp)
        ) {
            TextField(
                value = panjangState,
                label = {
                    Text(text = "Panjang")
                },
                onValueChange = {
                    panjangState = it
                },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = lebarState,
                label = {
                    Text(text = "Lebar")
                },
                onValueChange = {
                    lebarState = it
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Button(
                onClick = {
                    hasilState = panjangState.toInt() * lebarState.toInt()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Cek Hasil")
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = hasilState.toString(),
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Blue
                )
            )
        }
    }
    val image = painterResource(R.drawable.backg)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.4F,
            contentScale = ContentScale.Crop
        )
    }
    val hiasan = painterResource(R.drawable.angka)
    Column (
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = hiasan,
            contentDescription = null,
            alpha = 5F,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AplikasiSederhanaPreview () {
    AplikasiSederhana()
}