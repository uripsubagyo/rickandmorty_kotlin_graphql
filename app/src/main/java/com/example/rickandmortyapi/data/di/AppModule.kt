package com.example.rickandmortyapi.data.di

import com.apollographql.apollo3.ApolloClient
import com.example.rickandmortyapi.data.network.ApolloRickAndMortyClient
import com.example.rickandmortyapi.domain.network.RickAndMortyClient
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
            ApolloClient.builder().serverUrl("INPUT_HERE").build()


        @Provides
        @Singleton
        fun provideRickAndMortyClient(apolloClient: ApolloClient): RickAndMortyClient = ApolloRickAndMortyClient(apolloClient)
}