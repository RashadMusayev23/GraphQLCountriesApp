package com.mazeppa.graphqlcountriesapp.data.mappers

import com.mazeppa.CountriesQuery
import com.mazeppa.CountryQuery
import com.mazeppa.graphqlcountriesapp.domain.country.DetailedCountry
import com.mazeppa.graphqlcountriesapp.domain.country.SimpleCountry

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry = DetailedCountry(
    code = code,
    name = name,
    capital = capital ?: "No capital",
    emoji = emoji,
    languages = languages.mapNotNull {
        it.name
    },
    continent = continent.name
)

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry = SimpleCountry(
    code = code,
    name = name,
    capital = capital ?: "No capital",
    emoji = emoji
)