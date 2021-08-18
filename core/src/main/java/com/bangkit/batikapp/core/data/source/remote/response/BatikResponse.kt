package com.bangkit.batikapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class BatikResponse(

	@field:SerializedName("results")
	val hasil: List<Item>

)

data class Item(

	@field:SerializedName("id")
	val id: Int = -1,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("original_title")
	val originalTitle: String? = null,

	@field:SerializedName("original_name")
	val originalName: String? = null,

	@field:SerializedName("first_air_date")
	val firstAirDate: String?= null,

	@field:SerializedName("release_date")
	val releaseDate: String?= null,

	@field:SerializedName("vote_average")
	val voteAverage: Double = 0.0,

	@field:SerializedName("popularity")
	val popularity: Double = 0.0,

	@field:SerializedName("overview")
	val overview: String? = null
)
