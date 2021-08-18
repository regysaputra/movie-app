package com.bangkit.batikapp.detail

import androidx.lifecycle.ViewModel
import com.bangkit.batikapp.core.domain.model.Batik
import com.bangkit.batikapp.core.domain.usecase.BatikUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailBatikViewModel @Inject constructor(private val batikUseCase: BatikUseCase) : ViewModel() {
    fun setFavoriteBatik(batik: Batik, newStatus:Boolean) = batikUseCase.setFavoriteBatik(batik, newStatus)
}