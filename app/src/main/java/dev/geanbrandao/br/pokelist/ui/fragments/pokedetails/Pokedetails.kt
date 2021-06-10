package dev.geanbrandao.br.pokelist.ui.fragments.pokedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import dev.geanbrandao.br.pokelist.R
import dev.geanbrandao.br.pokelist.getThreeDigitsNumberAsString
import dev.geanbrandao.br.pokelist.model.PokemonModel
import dev.geanbrandao.br.pokelist.model.PokemonStats
import dev.geanbrandao.br.pokelist.ui.items.CardTypeItem
import dev.geanbrandao.br.pokelist.ui.items.EvolutionItem
import dev.geanbrandao.br.pokelist.ui.items.StatsItem
import dev.geanbrandao.br.pokelist.ui.styles.AllPokeNameTextStyle
import dev.geanbrandao.br.pokelist.ui.styles.AllPokeNumberTextStyle
import dev.geanbrandao.br.pokelist.ui.styles.PokeDetailsPokeStatsTextStyle
import dev.geanbrandao.br.pokelist.ui.theme.AllIconWhite
import dev.geanbrandao.br.pokelist.ui.theme.AllMarginDefault
import dev.geanbrandao.br.pokelist.ui.theme.AllPaddingDefault
import dev.geanbrandao.br.pokelist.ui.theme.TypeEletric

@Preview(name = "Detalhes")
@Composable
fun Pokedetails(pokemonModel: PokemonModel = PokemonModel(1, "Pikachu")) {
    PokedetailsContent(pokemonModel = pokemonModel)
}

@Composable
fun PokedetailsContent(pokemonModel: PokemonModel, backgroundColor: Color = TypeEletric) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = TypeEletric)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = ScrollState(0))
                .background(color = TypeEletric)
        ) {

            val (
                rowText,
                rowType,
                icPokeballPartial,
                imagePokemom,
                cardHeader,
                cardFooter,
                columnStats
            ) = createRefs()

            Row(
                modifier = Modifier
                    .padding(start = AllPaddingDefault, top = 64.dp, end = AllPaddingDefault)
                    .fillMaxWidth()
                    .constrainAs(ref = rowText) {
                        top.linkTo(anchor = parent.top)
                        end.linkTo(anchor = parent.end)
                        start.linkTo(anchor = parent.start)
                    }
            ) {
                Text(
                    text = pokemonModel.name,
                    style = AllPokeNameTextStyle,
                    modifier = Modifier.weight(weight = 1f)
                )
                Text(
                    text = pokemonModel.id.getThreeDigitsNumberAsString(),
                    style = AllPokeNumberTextStyle,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }

            Row(
                modifier = Modifier
                    .padding()
                    .constrainAs(ref = rowType) {
                        top.linkTo(anchor = rowText.bottom, margin = AllMarginDefault)
                        start.linkTo(anchor = parent.start, margin = AllPaddingDefault)
                    }
            ) {
                CardTypeItem()
                Spacer(modifier = Modifier.size(size = 8.dp))
                CardTypeItem()
            }

            Card(
                shape = RoundedCornerShape(size = 15.dp),
                elevation = 0.dp,
                modifier = Modifier
                    .height(height = 100.dp)
                    .padding(start = AllPaddingDefault, end = AllPaddingDefault)
                    .constrainAs(ref = cardHeader) {
                        top.linkTo(anchor = imagePokemom.bottom)
                        bottom.linkTo(anchor = imagePokemom.bottom)
                        end.linkTo(anchor = rowText.end)
                        start.linkTo(anchor = rowText.start)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = AllIconWhite)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.pokeball_partial),
                contentDescription = "",
                modifier = Modifier.constrainAs(ref = icPokeballPartial) {
                    end.linkTo(anchor = parent.end)
                    bottom.linkTo(anchor = cardHeader.top)
                }
            )
            Image(
                painter = painterResource(id = R.drawable.pikachu), contentDescription = "",
                modifier = Modifier
                    .size(195.dp)
                    .padding(top = 8.dp)
                    .constrainAs(ref = imagePokemom) {
                        top.linkTo(anchor = rowType.bottom)
                        end.linkTo(anchor = parent.end)
                        with(start) { linkTo(anchor = parent.start) }
                    }
            )

            Card(
                shape = RoundedCornerShape(size = 15.dp),
                elevation = 0.dp,
                modifier = Modifier
                    .height(height = 100.dp)
                    .padding(start = AllPaddingDefault, end = AllPaddingDefault)
                    .constrainAs(ref = cardFooter) {
                        top.linkTo(anchor = columnStats.bottom)
                        bottom.linkTo(anchor = columnStats.bottom, 64.dp)
                        end.linkTo(anchor = columnStats.end)
                        start.linkTo(anchor = columnStats.start)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = AllIconWhite)
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = AllPaddingDefault, end = AllPaddingDefault)
                .background(color = AllIconWhite)
                .constrainAs(ref = columnStats) {
                    top.linkTo(anchor = imagePokemom.bottom)
                    end.linkTo(anchor = cardHeader.end)
                    start.linkTo(anchor = cardHeader.start)
                }
            ) {
                Text(
                    text = "Pokemon stats",
                    style = PokeDetailsPokeStatsTextStyle,
                    modifier = Modifier.fillMaxWidth()
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                ) {
                    val list = arrayListOf(
                        PokemonStats("HP", 39),
                        PokemonStats("Attack", 52),
                        PokemonStats("Defense", 43),
                        PokemonStats("Special-attack", 60),
                        PokemonStats("Special-defense", 50),
                        PokemonStats("Speed", 65),
                    )
                    list.forEach { item: PokemonStats ->
                        StatsItem(
                            name = item.name, value = item.value
                        )
                    }
                }

                Text(
                    text = "Cadeia de evolucao",
                    style = PokeDetailsPokeStatsTextStyle,
                    modifier = Modifier.fillMaxWidth()
                )

                LazyRow(contentPadding = PaddingValues(8.dp)) {
                    val list = arrayListOf(
                        "forca",
                        "forca",
                        "forca",
                    )
                    itemsIndexed(list) { index: Int, item: String ->
                        EvolutionItem(id = index + 1)
                    }
                }
            }
        }

        Row(
            modifier = Modifier.padding(
                start = AllPaddingDefault,
                end = AllPaddingDefault,
                top = AllPaddingDefault
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = stringResource(R.string.pokedetails_content_description_back_button),
                tint = AllIconWhite,
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Red)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_favorite_border),
                contentDescription = stringResource(R.string.pokedetails_content_description_favorite_button),
                tint = AllIconWhite,
            )
        }

    }
}