package com.example.tugas_bu_dian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.tugas_bu_dian.screen.ScreenSoal1
import com.example.tugas_bu_dian.screen.ScreenSoal2
import com.example.tugas_bu_dian.ui.theme.Tugas_Bu_DianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas_Bu_DianTheme {
                MainApp()
            }
        }
    }
}


@Composable
fun MainApp() {
    var screenAktif by remember { mutableStateOf("menu") }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.entry_point))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    when (screenAktif) {
        "menu" -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                    modifier = Modifier
                        .size(250.dp)
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = "Pilih Tugas",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Button(
                    onClick = { screenAktif = "soal1" },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp)
                ) {
                    Text("Buka Soal 1", fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { screenAktif = "soal2" },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp)
                ) {
                    Text("Buka Soal 2", fontSize = 16.sp)
                }
            }
        }
        "soal1" -> ScreenSoal1( onBack = { screenAktif = "menu" })
        "soal2" -> ScreenSoal2( onBack = { screenAktif = "menu"} )
    }
}