package com.mazeppa.graphqlcountriesapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.mazeppa.graphqlcountriesapp.presentation.ui.theme.GraphQLCountriesAppTheme
import com.mazeppa.graphqlcountriesapp.presentation.viewmodel.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQLCountriesAppTheme {
                val viewModel = hiltViewModel<CountriesViewModel>()
                val countryState = viewModel.state.collectAsState()

                CountriesScreen(
                    countryState = countryState.value,
                    onCountrySelected = viewModel::selectCountry,
                    onDismissCountry = viewModel::dismissSelectedCountry
                )
            }
        }
    }
}