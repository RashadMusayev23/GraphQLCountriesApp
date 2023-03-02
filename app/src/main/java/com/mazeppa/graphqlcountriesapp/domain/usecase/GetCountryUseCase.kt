package com.mazeppa.graphqlcountriesapp.domain.usecase

import com.mazeppa.graphqlcountriesapp.domain.CountryClient

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */
class GetCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String) = countryClient.getCountry(code)
}