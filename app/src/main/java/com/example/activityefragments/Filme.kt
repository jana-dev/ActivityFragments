package com.example.activityefragments

import java.io.Serializable

data class Filme(
    val nome: String,
    val descricao: String,
    val avaliacoes: Double,
    val diretor: String,
    val distribidora: String,
) : Serializable
