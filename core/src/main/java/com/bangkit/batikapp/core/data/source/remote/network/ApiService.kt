package com.bangkit.batikapp.core.data.source.remote.network

import com.bangkit.batikapp.core.data.source.remote.response.BatikResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getList(@Query("api_key") apiKey: String): BatikResponse

}