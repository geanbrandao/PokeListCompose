package dev.geanbrandao.br.pokelist.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.geanbrandao.br.pokelist.R
import dev.geanbrandao.br.pokelist.ui.styles.PokeItemTextStyle
import dev.geanbrandao.br.pokelist.ui.theme.AllCardCornerRadius
import dev.geanbrandao.br.pokelist.ui.theme.AllMarginDefault
import dev.geanbrandao.br.pokelist.ui.theme.AllPaddingDefault
import dev.geanbrandao.br.pokelist.ui.theme.AllPaddingHalf
import dev.geanbrandao.br.pokelist.ui.theme.PokeItemImagePokeSize
import dev.geanbrandao.br.pokelist.ui.theme.TypeEletric

@Preview(name = "PokeItem")
@Composable
fun PokeItem(name: String = "PokeName", onClick: () -> Unit = {}) {
    Card(
        backgroundColor = TypeEletric,
        elevation = 0.dp,
        shape = RoundedCornerShape(AllCardCornerRadius),
        modifier = Modifier
            .padding(AllPaddingHalf),
    ) {
        Column(
            modifier = Modifier.padding(
                start = AllPaddingDefault,
                top = AllPaddingDefault
            ).clickable(onClick = { onClick() })
        ) {
            Text(text = name, style = PokeItemTextStyle) // TODO extrair textView em outro arquivo
            CardTypeItem()
            Spacer(modifier = Modifier.size(size = AllMarginDefault))
            CardTypeItem()
            Box(
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(size = PokeItemImagePokeSize)
                    .align(alignment = Alignment.End),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pokeball),
                    contentDescription = "",
                    modifier = Modifier
                        .requiredSize(size = PokeItemImagePokeSize)
                        .offset(x = 10.dp, y = 30.dp)
                        .alpha(0.8f),
                )
                Image(
                    painter = painterResource(id = R.drawable.pikachu),
                    contentDescription = "",
                    modifier = Modifier.size(size = PokeItemImagePokeSize),
                )
            }
        }
    }
}