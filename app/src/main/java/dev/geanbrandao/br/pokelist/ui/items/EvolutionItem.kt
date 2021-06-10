package dev.geanbrandao.br.pokelist.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import dev.geanbrandao.br.pokelist.R
import dev.geanbrandao.br.pokelist.getThreeDigitsNumberAsString
import dev.geanbrandao.br.pokelist.ui.styles.AllPokeNameTextStyle
import dev.geanbrandao.br.pokelist.ui.styles.AllPokeNumberTextStyle
import dev.geanbrandao.br.pokelist.ui.theme.AllMarginDefault
import dev.geanbrandao.br.pokelist.ui.theme.TypeEletric

@Preview(name = "Evolution")
@Composable
fun EvolutionItem(name: String = "Pikachu", id: Int = 1) {
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 8.dp,
            bottomEnd = 48.dp,
            bottomStart = 48.dp
        ),
        backgroundColor = TypeEletric,
        modifier = Modifier.padding(4.dp)
    ) {
        ConstraintLayout {
            val (imagePokeRef, imagePBRef, textNumber, textName) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.ic_pokeball),
                contentDescription = "pokeball",
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(ref = imagePBRef) {
                        top.linkTo(anchor = imagePokeRef.top)
                        end.linkTo(anchor = imagePokeRef.end)
                        start.linkTo(anchor = imagePokeRef.start)
                        bottom.linkTo(anchor = imagePokeRef.bottom)
                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.pikachu),
                contentDescription = "Image pokemom",
                modifier = Modifier
                    .size(100.dp)
                    .constrainAs(ref = imagePokeRef) {
                        top.linkTo(anchor = parent.top, margin = AllMarginDefault)
                        end.linkTo(anchor = parent.end, margin = AllMarginDefault)
                        start.linkTo(anchor = parent.start, margin = 20.dp)
                    }
            )
            // TODO extraxt this text into a component to reuse
            Text(
                text = id.getThreeDigitsNumberAsString(),
                style = AllPokeNumberTextStyle,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .constrainAs(ref = textNumber) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    })

            Text(text = name, style = AllPokeNameTextStyle, fontSize = 12.sp,
            modifier = Modifier.constrainAs(ref = textName) {
                top.linkTo(imagePokeRef.bottom)
                end.linkTo(anchor = parent.end)
                start.linkTo(anchor = parent.start)
                bottom.linkTo(anchor = parent.bottom, margin = 20.dp)
            })
        }

    }
}
