package com.example.tugas_bu_dian.utils

class Deret (
    private val nilaiAwal: Int,
    private val beda: Int,
    private val jumlah: Int
){
    fun generate(): List<Int> {
        val hasil = mutableListOf<Int>()
        var nilai = nilaiAwal

        repeat(jumlah) {
            hasil.add(nilai)
            nilai += beda
        }
        return hasil
    }

    fun average(): Double {
        val deret = generate()
        return deret.average()
    }
}