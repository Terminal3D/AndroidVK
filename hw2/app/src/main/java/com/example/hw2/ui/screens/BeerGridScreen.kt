package com.example.hw2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.hw2.R
import com.example.hw2.data.Beer


@Composable
fun BeerGridScreen(
    beers: List<Beer>,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        itemsIndexed(beers) { _, beer ->
            BeerCard(beer = beer, modifier)

        }
    }
}


@Composable
fun BeerCard(
    beer: Beer,
    modifier: Modifier
) {
    var retryHash by remember { mutableStateOf(0) }
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(beer.linkToPic)
            .setParameter("retry_hash", retryHash, memoryCacheKey = null)
            .build()
    )
    val state = painter.state

    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(296.dp)
            .clickable { retryHash++ }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()) {
            beer.name?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(top = 4.dp, bottom = 8.dp)
                )
            }
            if (state is AsyncImagePainter.State.Error) {
                Box(
                    contentAlignment = Alignment.Center, // Выравнивание содержимого Box по центру
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Reload Image",
                        modifier = modifier.fillMaxWidth(),
                        )
                }
            } else {
                Image(
                    modifier = modifier.fillMaxWidth(),
                    painter = painter,
                    contentDescription = stringResource(id = R.string.content_description),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}
