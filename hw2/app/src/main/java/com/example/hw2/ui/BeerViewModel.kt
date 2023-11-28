package com.example.hw2.ui.theme

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.hw2.BeerApplication

import com.example.hw2.data.Beer
import com.example.hw2.data.BeerRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BeerUiState {
    data class Success(val beerSearch: List<Beer>) : BeerUiState
    object Error : BeerUiState
    object Loading : BeerUiState
}

class BeerViewModel(
    private val beerRepository: BeerRepository
) : ViewModel() {

    var beerUiState: BeerUiState by mutableStateOf(BeerUiState.Loading)
        private set

    private var page by mutableStateOf(1)
    private var currentBeers = mutableListOf<Beer>()

    init {
        getBeer()
    }

    fun getBeer(maxResults: Int = 40) {
        viewModelScope.launch {
            beerUiState = BeerUiState.Loading
            beerUiState = try {
                val newBeers = beerRepository.getBeer(page, maxResults)
                currentBeers.addAll(newBeers)
                BeerUiState.Success(currentBeers.toList())
            } catch (e: IOException) {
                BeerUiState.Error
            } catch (e: HttpException) {
                BeerUiState.Error
            }
        }
    }



    fun loadNextPage() {
        if (beerUiState is BeerUiState.Loading) return
        page++
        getBeer()
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BeerApplication)
                val beerRepository = application.container.beerRepository
                BeerViewModel(beerRepository = beerRepository)
            }
        }
    }
}
