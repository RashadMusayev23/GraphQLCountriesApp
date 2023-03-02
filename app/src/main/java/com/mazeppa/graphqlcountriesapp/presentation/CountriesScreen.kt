package com.mazeppa.graphqlcountriesapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mazeppa.graphqlcountriesapp.domain.country.SimpleCountry
import com.mazeppa.graphqlcountriesapp.presentation.viewmodel.CountriesViewModel

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */

@Composable
fun CountriesScreen(
    countryState: CountriesViewModel.CountryState,
    onCountrySelected: (code: String) -> Unit,
    onDismissCountry: () -> Unit
) {

    Box(Modifier.fillMaxSize()) {
        if (countryState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(countryState.countries) { country ->
                    CountryItem(
                        simpleCountry = country,
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .padding(6.dp)
                            .clickable {
                                onCountrySelected(country.code)
                            }
                    )
                }
            }
        }

        if (countryState.selectedCountry != null) {
            SelectedCountryDialog(
                country = countryState.selectedCountry,
                onDismissCountry = { onDismissCountry() },
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun CountryItem(
    simpleCountry: SimpleCountry,
    modifier: Modifier = Modifier
) {
    Card(
        modifier,
        elevation = 3.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(12.dp),
        ) {
            Text(text = simpleCountry.emoji, color = Color.Black, fontSize = 40.sp)

            Spacer(modifier = Modifier.size(10.dp))

            Column(Modifier.fillMaxHeight()) {
                Text(text = simpleCountry.name, color = Color.Black, fontSize = 24.sp)

                Spacer(modifier = Modifier.size(8.dp))

                Text(text = simpleCountry.capital, color = Color.Black, fontSize = 12.sp)
            }
        }
    }
}