package dev.geanbrandao.br.pokelist.ui.styles

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.geanbrandao.br.pokelist.ui.theme.AllTextColor
import dev.geanbrandao.br.pokelist.ui.theme.AllTextColorInverse
import dev.geanbrandao.br.pokelist.ui.theme.ChakrapetchFamily

val CardTypeTextStyle = TextStyle(
    fontFamily = ChakrapetchFamily,
    fontSize = 12.sp,
    fontWeight = FontWeight.Light,
    fontStyle = FontStyle.Normal,
    color = AllTextColor
)

val PokeItemTextStyle = TextStyle(
    fontFamily = ChakrapetchFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    fontStyle = FontStyle.Normal,
    color = AllTextColor,
)

val AllPokeNameTextStyle = TextStyle(
    fontFamily = ChakrapetchFamily,
    fontSize = 22.sp,
    fontWeight = FontWeight.Bold,
    fontStyle = FontStyle.Normal,
    color = AllTextColor
)

val AllPokeNumberTextStyle = TextStyle(
    fontFamily = ChakrapetchFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    fontStyle = FontStyle.Normal,
    color = AllTextColor
)

val PokeDetailsPokeStatsTextStyle = TextStyle(
    fontFamily = ChakrapetchFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    fontStyle = FontStyle.Normal,
    color = AllTextColorInverse,
    textAlign = TextAlign.Center
)

val StatsItemNameTextStyle = TextStyle(
    fontFamily = ChakrapetchFamily,
    fontSize = 14.sp,
    fontWeight = FontWeight.Bold,
    fontStyle = FontStyle.Normal,
    color = AllTextColorInverse,
)