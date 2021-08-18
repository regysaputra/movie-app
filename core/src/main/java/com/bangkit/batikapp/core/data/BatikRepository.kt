package com.bangkit.batikapp.core.data

import com.bangkit.batikapp.core.data.source.local.LocalDataSource
import com.bangkit.batikapp.core.data.source.remote.RemoteDataSource
import com.bangkit.batikapp.core.data.source.remote.network.ApiResponse
import com.bangkit.batikapp.core.data.source.remote.response.Item
import com.bangkit.batikapp.core.domain.model.Batik
import com.bangkit.batikapp.core.domain.repository.IBatikRepository
import com.bangkit.batikapp.core.utils.AppExecutors
import com.bangkit.batikapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BatikRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IBatikRepository {

    override fun getAllBatik(): Flow<Resource<List<Batik>>> =
        object : com.bangkit.batikapp.core.data.NetworkBoundResource<List<Batik>, List<Item>>() {
            override fun loadFromDB(): Flow<List<Batik>> {
                return localDataSource.getAllBatik().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Batik>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<Item>>> =
                remoteDataSource.getAllBatik()

            override suspend fun saveCallResult(data: List<Item>) {
                val batikList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertBatik(batikList)
            }
        }.asFlow()

    override fun getFavoriteBatik(): Flow<List<Batik>> {
        return localDataSource.getFavoriteBatik().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteBatik(batik: Batik, state: Boolean) {
        val batikEntity = DataMapper.mapDomainToEntity(batik)
        appExecutors.diskIO().execute { localDataSource.setFavoriteBatik(batikEntity, state) }
    }

}