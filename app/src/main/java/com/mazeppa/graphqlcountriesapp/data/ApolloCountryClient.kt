package com.mazeppa.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.mazeppa.CountriesQuery
import com.mazeppa.CountryQuery
import com.mazeppa.graphqlcountriesapp.data.mappers.toDetailedCountry
import com.mazeppa.graphqlcountriesapp.data.mappers.toSimpleCountry
import com.mazeppa.graphqlcountriesapp.domain.CountryClient
import com.mazeppa.graphqlcountriesapp.domain.country.DetailedCountry
import com.mazeppa.graphqlcountriesapp.domain.country.SimpleCountry
import javax.inject.Inject

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */
class ApolloCountryClient @Inject constructor(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { country ->
                country.toSimpleCountry()
            }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country?.toDetailedCountry()
    }

}