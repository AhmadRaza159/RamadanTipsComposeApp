package com.example.learningramadantipscomposeapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningramadantipscomposeapp.data.models.RamadanDay
import com.example.learningramadantipscomposeapp.ui.theme.LearningRamadanTipsComposeAppTheme

@Composable
fun RamadanItem(ramadanDay: RamadanDay, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier=modifier, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
        Column(modifier=Modifier.padding(8.dp).animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            )
        )) {
            TopBar(expanded = expanded, ramadanDayNum = ramadanDay.dayNumTitle, ramadanQuoteTitle = ramadanDay.dayQuoteTitle, {
                expanded=!expanded
            })
            if (expanded){
                RamadanImage(ramadanImage = ramadanDay.dayImage)
                RamadanQuote(text = ramadanDay.dayQuoteDesc)
            }

        }
    }

}

@Composable
fun TopBar(expanded:Boolean, @StringRes ramadanDayNum:Int, @StringRes ramadanQuoteTitle:Int, onBClick:()->Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DayContainer(ramadanDayNum)
        Text(
            text = stringResource(ramadanQuoteTitle),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier
                .padding(8.dp, 4.dp)
                .weight(1f)
        )
        IconButton(onClick = {
            onBClick.invoke()
        }) {
            Icon(
                imageVector =if (!expanded) ImageVector.vectorResource(R.drawable.ic_arrow_down) else ImageVector.vectorResource(R.drawable.ic_arrow_up),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = modifier.border(
                    width = 1.dp,
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    }

}

@Composable
fun DayContainer(@StringRes dayText: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.primary
            )
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = MaterialTheme.shapes.large
            )
            .padding(8.dp, 4.dp)
    ) {
        Text(
            text = stringResource(dayText),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun RamadanImage(@DrawableRes ramadanImage: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.secondary
            )
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(ramadanImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.clip(MaterialTheme.shapes.medium).fillMaxWidth().height(220.dp)
        )
    }
}

@Composable
fun RamadanQuote(@StringRes text:Int,modifier: Modifier = Modifier) {
    Text(
        text= stringResource(text),
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        modifier = modifier.padding(4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun RamadanItemPreview() {
    LearningRamadanTipsComposeAppTheme {
        RamadanItem(RamadanDay(dayNumTitle = R.string.day_text_1, dayQuoteTitle = R.string.quote_title_1, dayImage = R.drawable.ramadan_1, dayQuoteDesc = R.string.quote_description_1))
    }
}