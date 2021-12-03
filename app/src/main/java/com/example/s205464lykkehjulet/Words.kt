package com.example.s205464lykkehjulet

/**
 * A enum class of the 3 categories as string arrays, and the strings they contain
 */

enum class Words(val nameOfCategory: String, val listOf: List<String> ) {
    MADDRIKKE("Mad",listOf("FlæskeSteg", "Sandwich", "Lasagne", "Tomatsuppe")),
    STED ("Steder", listOf("Rusland", "Italien", "New York", "Lyngby")),
    FILMTITEL ("Filmtitler",listOf("Godfather", "Star Wars", "Lion King", "James Bond"))
}