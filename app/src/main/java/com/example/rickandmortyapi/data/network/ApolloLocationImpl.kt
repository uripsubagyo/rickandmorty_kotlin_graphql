package com.example.rickandmortyapi.data.network

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.example.rickandmortyapi.LocationQuery
import com.example.rickandmortyapi.LocationsQuery
import com.example.rickandmortyapi.domain.model.Location.DetailLocation
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation
import com.example.rickandmortyapi.domain.network.LocationClient
import toDetailLocation
import toLocationList
import javax.inject.Inject

class ApolloLocationImpl  @Inject constructor(
    private val apolloClient: ApolloClient
) : LocationClient {
    override suspend fun getLocations(page: Int): List<SimpleLocation> {
        return try {
            apolloClient.query(LocationsQuery(page))
                .execute()
                .data
                ?.locations
                ?.toLocationList()
                .orEmpty()
        }catch (err: ApolloException){
            Log.e("ERROR_APOLLO", err.toString())
            emptyList<SimpleLocation>()
        }
    }

    override suspend fun getDetailLocation(id: String): DetailLocation? {
        return try {
            apolloClient.query(LocationQuery(id))
                .execute()
                .data
                ?.location
                ?.toDetailLocation()
        } catch (err: ApolloException){
            Log.e("ERROR_APOLLO", err.toString())
            null
        }
    }
}