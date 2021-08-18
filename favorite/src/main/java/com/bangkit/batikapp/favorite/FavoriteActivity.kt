package com.bangkit.batikapp.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.batikapp.core.ui.BatikAdapter
import com.bangkit.batikapp.detail.DetailBatikActivity
import com.bangkit.batikapp.di.FavoriteModuleDependencies
import com.bangkit.batikapp.favorite.databinding.ActivityFavoriteBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Movie Favorite"

        getBatikData()
    }

    private fun getBatikData() {
        val batikAdapter = BatikAdapter()

        batikAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailBatikActivity::class.java)
            intent.putExtra(DetailBatikActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteBatik.observe(this, { batik ->
            batikAdapter.setData(batik)
            binding.viewEmpty.root.visibility = if (batik.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvBatik) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = batikAdapter
        }
    }
}