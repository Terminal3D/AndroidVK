package com.example.hw2.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hw2.R
import com.example.hw2.ui.screens.HomeScreen
import com.example.hw2.ui.theme.BeerViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeerApp(
    modifier: Modifier = Modifier
) {
    val beerViewModel: BeerViewModel =
        viewModel(factory = BeerViewModel.Factory)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar (
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }

    ) {
        Surface(modifier = modifier
            .fillMaxSize()
            .padding(it),

        ) {
            HomeScreen(
                beerUiState = beerViewModel.beerUiState,
                retryAction = { beerViewModel.getBeer() },
                loadNextPage = { beerViewModel.loadNextPage()},
                modifier = modifier
            )
        }
    }
}