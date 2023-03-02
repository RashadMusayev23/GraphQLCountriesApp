package com.mazeppa.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.mazeppa.graphqlcountriesapp.data.ApolloCountryClient
import com.mazeppa.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import com.mazeppa.graphqlcountriesapp.domain.usecase.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Rashad Musayev (https://github.com/RashadMusayev23) on 3/2/2023
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGetCountriesUseCase(apolloCountryClient: ApolloCountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(apolloCountryClient)
    }

    @Provides
    @Singleton
    fun providesGetCountryUseCase(apolloCountryClient: ApolloCountryClient): GetCountryUseCase {
        return GetCountryUseCase(apolloCountryClient)
    }



    @Provides
    @Singleton
    fun providesApolloCountriesClient() : ApolloCountryClient {
        return ApolloCountryClient(ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build())
    }

}