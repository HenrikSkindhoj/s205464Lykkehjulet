package com.example.s205464lykkehjulet

enum class Words(val nameOfCategory: String, val listOf: List<String> ) {
    MADDRIKKE("Mad og Drikke",listOf("FlæskeSteg", "Sandwich", "Lasagne", "Tomatsuppe")),
    STED ("Steder", listOf("Rusland", "Italien", "New York", "Lyngby")),
    FILMTITEL ("Filmtitler",listOf("Godfather", "Star Wars", "Lion King", "James Bond"))
}