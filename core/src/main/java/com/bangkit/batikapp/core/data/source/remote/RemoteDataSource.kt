package com.bangkit.batikapp.core.data.source.remote

import android.util.Log
import com.bangkit.batikapp.core.BuildConfig
import com.bangkit.batikapp.core.data.source.remote.network.ApiResponse
import com.bangkit.batikapp.core.data.source.remote.network.ApiService
import com.bangkit.batikapp.core.data.source.remote.response.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    private val apiKey = BuildConfig.API_KEY

    suspend fun getAllBatik(): Flow<ApiResponse<List<Item>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getList(apiKey)
                val dataArray = response.hasil
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.hasil))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch(e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}