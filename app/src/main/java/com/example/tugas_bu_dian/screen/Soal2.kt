package com.example.tugas_bu_dian.screen

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugas_bu_dian.utils.Deret

@Composable
fun ScreenSoal2 (onBack: ()-> Unit) {
    var awal by remember { mutableStateOf("") }
    var beda by remember { mutableStateOf("") }
    var jumlah by remember { mutableStateOf("") }

    var hasilDeret by remember { mutableStateOf(listOf<Int>()) }
    var average by remember { mutableStateOf(0.0) }

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
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = awal,
            onValueChange = { awal = it },
            label = { Text("Nilai awal") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp
            ),
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp
            )
        )
        Spacer(
            modifier = Modifier.padding(6.dp)
        )
        TextField(
            value = beda,
            onValueChange = { beda = it },
            label = { Text("Beda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp
                ),
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp
            )
        )
        Spacer(
            modifier = Modifier.padding(6.dp)
        )
        TextField(
            value = jumlah,
            onValueChange = { jumlah = it },
            label = { Text("Jumlah Deret" ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp
                ),
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp
            )
        )
        Spacer(
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = {
                val a = awal.toIntOrNull()
                val b = beda.toIntOrNull()
                val j = jumlah.toIntOrNull()

                if (a != null && b != null && j != null) {
                    val deret = Deret(a, b, j)
                    hasilDeret = deret.generate()
                    average = deret.average()
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
            Text("Generate")
        }
        if (hasilDeret.isNotEmpty()) {
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 16.dp,
                        start = 8.dp,
                        end = 8.dp
                    ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Hasil Deret: ",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = hasilDeret.joinToString(", "),
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = "Rata-rata: ",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "$average",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}