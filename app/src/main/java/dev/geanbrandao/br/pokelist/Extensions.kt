package dev.geanbrandao.br.pokelist

fun Int.getThreeDigitsNumberAsString(): String {
    return when {
        this < 10 -> {
            "#00$this"
        }
        this < 100 -> {
            "#0$this"
        }
        else -> {
            "#$this"
        }
    }
}