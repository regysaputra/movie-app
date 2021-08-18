package com.bangkit.batikapp.core.utils

import com.bangkit.batikapp.core.data.source.local.entity.BatikEntity
import com.bangkit.batikapp.core.data.source.remote.response.Item
import com.bangkit.batikapp.core.domain.model.Batik

object DataMapper {
    fun mapResponsesToEntities(input: List<Item>): List<BatikEntity> {
        val batikList = ArrayList<BatikEntity>()
        input.map {
            val batik = BatikEntity(
                id = it.id,
                backdropPath = it.backdropPath,
                posterPath = it.posterPath,
                originalTitle = it.originalTitle,
                releaseDate = it.releaseDate,
                overview = it.overview,
                voteAverage = it.voteAverage,
                popularity = it.popularity,
                isFavorite = false
            )
            batikList.add(batik)
        }
        return batikList
    }

    fun mapEntitiesToDomain(input: List<BatikEntity>): List<Batik> =
        input.map {
            Batik(
                id = it.id,
                backdropPath = it.backdropPath,
                posterPath = it.posterPath,
                originalTitle = it.originalTitle,
                releaseDate = it.releaseDate,
                overview = it.overview,
                voteAverage = it.voteAverage,
                popularity = it.popularity,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Batik) =
        BatikEntity(
            id = input.id,
            backdropPath = input.backdropPath,
            posterPath = input.posterPath,
            originalTitle = input.originalTitle,
            releaseDate = input.releaseDate,
            overview = input.overview,
            voteAverage = input.voteAverage,
            popularity = input.popularity,
            isFavorite = input.isFavorite
        )
}