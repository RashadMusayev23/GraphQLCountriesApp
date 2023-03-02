package com.mazeppa.graphqlcountriesapp.domain.country

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */
data class SimpleCountry(
    val code: String,
    val name: String,
    val capital: String,
    val emoji: String
)