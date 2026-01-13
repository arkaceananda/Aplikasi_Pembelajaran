package com.example.tugas_bu_dian.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tugas_bu_dian.utils.Bilangan

@Composable
fun ScreenSoal1(onBack: ()-> Unit) {
    var input by remember { mutableStateOf("") }
    var hasil by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .padding(
                    top = 6.dp,
                    start = 4.dp
                )
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = input,
            onValueChange = {input = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp
                ),
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp
            ),
            label = {
                Text("Masukkan angka: ")
            }
        )
        Spacer(modifier = Modifier.padding(6.dp))
        Button(
            onClick = {
                val angka = input.toIntOrNull()
                if (angka != null) {
                    val bilangan = Bilangan(angka)
                    hasil = bilangan.checkNumber()
                }
                else {
                    hasil = "Input tidak valid"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 8.dp,
                    start = 64.dp,
                    end = 64.dp
                )
        ) {
            Text("Check")
        }

        Spacer(modifier = Modifier.padding(8.dp))

        if (hasil.isNotEmpty()) {
            if (hasil == "Input tidak valid") {
                Text(
                    text = hasil,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 18.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Medium
                )
            } else {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.3f)
                    ),
                    border = androidx.compose.foundation.BorderStroke(2.dp, Color.Black),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.dp
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = hasil,
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}