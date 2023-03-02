package com.mazeppa.graphqlcountriesapp.domain.country

import com.mazeppa.type.Continent
import java.util.Currency

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */
data class DetailedCountry(
    val code: String,
    val name: String,
    val capital: String,
    val emoji: String,
    val currency: String,
    val languages: List<String>,
    val continent: String
)
