package dev.geanbrandao.br.pokelist.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.geanbrandao.br.pokelist.R

val ChakrapetchFamily = FontFamily(
    Font(resId = R.font.chakrapetch_bold, weight = FontWeight.Bold),
    Font(
        resId = R.font.chakrapetch_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.chakrapetch_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resId = R.font.chakrapetch_light, weight = FontWeight.Light),
    Font(
        resId = R.font.chakrapetch_light_italic,
        weight = FontWeight.Light,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.chakrapetch_medium, weight = FontWeight.Medium),
    Font(
        resId = R.font.chakrapetch_medium_italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.chakrapetch_regular, weight = FontWeight.Normal),
    Font(resId = R.font.chakrapetch_semibold, weight = FontWeight.SemiBold),
    Font(
        resId = R.font.chakrapetch_semibold_italic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    ),
)