package com.mazeppa.graphqlcountriesapp.domain.usecase

import com.mazeppa.graphqlcountriesapp.domain.CountryClient
import javax.inject.Inject

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */
class GetCountriesUseCase @Inject constructor(
    private val countryClient: CountryClient
) {

    suspend fun execute() =
        countryClient.getCountries()
            .sortedBy {
                it.name
            }
}