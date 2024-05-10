package com.example.rickandmortyapi.data.di

import com.apollographql.apollo3.ApolloClient
import com.example.rickandmortyapi.data.network.ApolloCharacterImpl
import com.example.rickandmortyapi.data.network.ApolloLocationImpl
import com.example.rickandmortyapi.domain.network.CharacterClient
import com.example.rickandmortyapi.domain.network.LocationClient
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
        fun provideCharacterClient(apolloClient: ApolloClient): CharacterClient = ApolloCharacterImpl(apolloClient)

        @Provides
        @Singleton
        fun provideLocationClient(apolloClient: ApolloClient): LocationClient = ApolloLocationImpl(apolloClient)

        @Provides
        @Singleton
        fun provideGetCharacterUseCase(countryClient: CharacterClient): GetCharacterUseCase {
                return GetCharacterUseCase(countryClient)
        }

        @Provides
        @Singleton
        fun provideGetCharactersUserCase(countryClient: CharacterClient): GetCharactersUseCase {
                return GetCharactersUseCase(countryClient)
        }

        @Provides
        @Singleton
        fun providesGetLocationsUseCase(countryClient: LocationClient): GetLocationsUseCase{
                return GetLocationsUseCase(countryClient)
        }

        @Provides
        @Singleton
        fun provideGetDetailLocationUseCase(countryClient: LocationClient): GetLocationDetailUseCase{
                return GetLocationDetailUseCase(countryClient)
        }
}