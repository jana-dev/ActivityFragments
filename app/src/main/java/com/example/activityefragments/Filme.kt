package com.example.activityefragments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

//data class Filme(
//    val nome: String,
//    val descricao: String,
//    val avaliacoes: Double,
//    val diretor: String,
//    val distribidora: String,
//) : Serializable


@Parcelize
data class Filme(
    val nome: String,
    val descricao: String,
    val avaliacoes: Double,
    val diretor: String,
    val distribuidora: String,
) : Parcelable
