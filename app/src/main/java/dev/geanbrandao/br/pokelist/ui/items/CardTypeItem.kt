package dev.geanbrandao.br.pokelist.ui.items

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.geanbrandao.br.pokelist.R
import dev.geanbrandao.br.pokelist.ui.styles.CardTypeTextStyle
import dev.geanbrandao.br.pokelist.ui.theme.AllCardCornerRadius
import dev.geanbrandao.br.pokelist.ui.theme.WhiteTransparent

@Preview(name = "Tipo do pokemon")
@Composable
fun CardTypeItem(
    @StringRes pokeTypeStringId: Int = R.string.all_poketype_eletric,
    @DrawableRes poketypeIconId: Int = R.drawable.ic_electric,
) {
    val cardTypeImageTypeSize = dimensionResource(id = R.dimen.card_type_image_type_size)
    val cardTypePadding = dimensionResource(id = R.dimen.card_type_padding)
    val pokeTypeIcon = painterResource(id = poketypeIconId)
    Card(
        shape = RoundedCornerShape(size = AllCardCornerRadius),
        backgroundColor = WhiteTransparent,
        elevation = 0.dp,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = cardTypePadding, vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = pokeTypeIcon,
                contentDescription = stringResource(id = R.string.card_type_content_description_image_pokemon_type),
                modifier = Modifier.size(size = cardTypeImageTypeSize),
            )
            Text(
                text = stringResource(id = pokeTypeStringId),
                style = CardTypeTextStyle
            )
        }
    }
}