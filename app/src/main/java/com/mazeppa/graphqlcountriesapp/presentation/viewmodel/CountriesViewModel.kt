package com.mazeppa.graphqlcountriesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mazeppa.graphqlcountriesapp.domain.country.DetailedCountry
import com.mazeppa.graphqlcountriesapp.domain.country.SimpleCountry
import com.mazeppa.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import com.mazeppa.graphqlcountriesapp.domain.usecase.GetCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */
class CountriesViewModel(
    val getCountriesUseCase: GetCountriesUseCase,
    val getCountryUseCase: GetCountryUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<CountryState> = MutableStateFlow(CountryState())
    val state: StateFlow<CountryState> = _state.asStateFlow()

    data class CountryState(
        val countries: List<SimpleCountry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCountry: DetailedCountry? = null
    )

    init {
        viewModelScope.launch {
            getCountries()
        }
    }

    private suspend fun getCountries() {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
        _state.update {
            it.copy(
                countries = getCountriesUseCase.execute(),
                isLoading = false
            )
        }
    }

    fun dismissSelectedCountry() {
        _state.update {
            it.copy(
                selectedCountry = null
            )
        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedCountry = getCountryUseCase.execute(code),
                )
            }
        }
    }

}