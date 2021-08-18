package com.bangkit.batikapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bangkit.batikapp.R
import com.bangkit.batikapp.core.domain.model.Batik
import com.bangkit.batikapp.databinding.ActivityDetailBatikBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailBatikActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBatikBinding

    private val detailBatikViewModel: DetailBatikViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBatikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailBatik = intent.getParcelableExtra<Batik>(EXTRA_DATA)

        if (detailBatik != null) {
            showDetailBatik(detailBatik)
        }
    }

    private fun showDetailBatik(detailBatik: Batik) {
        supportActionBar?.title = detailBatik.originalTitle
        binding.content.tvDetailDescription.text = detailBatik.overview

        val posterUrl = "https://image.tmdb.org/t/p/original/${detailBatik.posterPath}"

        Glide.with(this@DetailBatikActivity)
            .load(posterUrl)
            .into(binding.ivDetailImage)

        var statusFavorite = detailBatik.isFavorite
        setStatusFavorite(statusFavorite)
        binding.fab.setOnClickListener {
            statusFavorite = !statusFavorite
            detailBatikViewModel.setFavoriteBatik(detailBatik, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}