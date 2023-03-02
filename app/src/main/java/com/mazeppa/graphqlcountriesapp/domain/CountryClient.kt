package com.mazeppa.graphqlcountriesapp.domain

import com.mazeppa.graphqlcountriesapp.domain.country.DetailedCountry
import com.mazeppa.graphqlcountriesapp.domain.country.SimpleCountry

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */
interface CountryClient {

    suspend fun getCountries() : List<SimpleCountry>?

    suspend fun getCountry(code: String) : DetailedCountry?

}