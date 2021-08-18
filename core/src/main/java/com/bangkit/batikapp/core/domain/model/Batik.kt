package com.bangkit.batikapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batik(
    var id: Int,
    var backdropPath: String? = null,
    var posterPath: String? = null,
    var originalTitle: String? = null,
    var releaseDate: String? = null,
    var overview: String? = null,
    var voteAverage: Double = 0.0,
    var popularity: Double = 0.0,
    var isFavorite: Boolean = false
) : Parcelable