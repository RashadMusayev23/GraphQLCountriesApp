package com.mazeppa.graphqlcountriesapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mazeppa.graphqlcountriesapp.domain.country.DetailedCountry

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */

@Composable
fun SelectedCountryDialog(
    country: DetailedCountry,
    onDismissCountry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { onDismissCountry() }
    ) {
        Column(modifier) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {
                Text(text = country.emoji, modifier = Modifier.padding(12.dp), fontSize = 30.sp)

                Text(text = country.name, fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Continent: ${country.continent}")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Currency: ${country.currency}")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Capital: ${country.capital}")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Language(s): ${country.languages.joinToString()}")
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}