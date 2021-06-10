package dev.geanbrandao.br.pokelist.ui.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.geanbrandao.br.pokelist.ui.styles.StatsItemNameTextStyle
import dev.geanbrandao.br.pokelist.ui.theme.TypeEletric

@Preview(name = "StatsItem")
@Composable
fun StatsItem(name: String = "HP", value: Int = 22, colorType: Color = TypeEletric) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = name, style = StatsItemNameTextStyle, modifier = Modifier.width(125.dp))
        Text(
            text = value.toString(), style = StatsItemNameTextStyle, fontWeight = FontWeight.Light,
            modifier = Modifier.padding(start = 16.dp, end = 32.dp)
        )
        LinearProgressIndicator(
            color = colorType,
            modifier = Modifier.align(alignment = Alignment.CenterVertically),
            progress = (value / 100f),

            )
    }
}