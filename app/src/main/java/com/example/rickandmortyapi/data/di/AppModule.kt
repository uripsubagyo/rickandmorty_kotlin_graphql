package com.example.rickandmortyapi.data.di

import com.apollographql.apollo3.ApolloClient
import com.example.rickandmortyapi.data.network.ApolloRickAndMortyClient
import com.example.rickandmortyapi.domain.network.RickAndMortyClient
import com.example.rickandmortyapi.domain.use_case.character.GetCharacterUseCase
import com.example.rickandmortyapi.domain.use_case.character.GetCharactersUseCase
import com.example.rickandmortyapi.domain.use_case.location.GetLocationDetailUseCase
import com.example.rickandmortyapi.domain.use_case.location.GetLocationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

        @Provides
        @Singleton
        fun provideApolloClient(): ApolloClient =
            ApolloClient.Builder()
                    .serverUrl("https://rickandmortyapi.com/graphql")
                    .build()


        @Provides
        @Singleton
        fun provideRickAndMortyClient(apolloClient: ApolloClient): RickAndMortyClient = ApolloRickAndMortyClient(apolloClient)

        @Provides
        @Singleton
        fun provideGetCharacterUseCase(countryClient: RickAndMortyClient): GetCharacterUseCase {
                return GetCharacterUseCase(countryClient)
        }

        @Provides
        @Singleton
        fun provideGetCharactersUserCase(countryClient: RickAndMortyClient): GetCharactersUseCase {
                return GetCharactersUseCase(countryClient)
        }

        @Provides
        @Singleton
        fun providesGetLocationsUseCase(countryClient: RickAndMortyClient): GetLocationsUseCase{
                return GetLocationsUseCase(countryClient)
        }

        @Provides
        @Singleton
        fun provideGetDetailLocationUseCase(countryClient: RickAndMortyClient): GetLocationDetailUseCase{
                return GetLocationDetailUseCase(countryClient)
        }
}