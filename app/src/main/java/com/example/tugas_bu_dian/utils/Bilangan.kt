package com.example.tugas_bu_dian.utils

class Bilangan(val angka: Int) {

    fun checkNumber(): String {
        return when {
            angka > 0 && angka % 2 == 0 -> "$angka adalah bilangan positif genap"
            angka < 0 && angka % 2 == 0 -> "$angka adalah bilangan negatif genap"
            angka > 0 && angka % 2 != 0 -> "$angka adalah bilangan positif ganjil"
            angka < 0 && angka % 2 != 0 -> "$angka adalah bilangan negatif ganjil"
            else -> "nol"
        }
    }
}

// Untuk mengerjakan nomor 1