package com.example.hw2.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hw2.ui.theme.BeerUiState


@Composable
fun HomeScreen(
    beerUiState: BeerUiState,
    retryAction: () -> Unit,
    modifier: Modifier
) {
    when (beerUiState) {
        is BeerUiState.Loading -> LoadingScreen(modifier)
        is BeerUiState.Success -> BeerGridScreen(
            beers = beerUiState.beerSearch,
            modifier = modifier
        )
        else -> ErrorScreen(retryAction = retryAction, modifier)
    }
}