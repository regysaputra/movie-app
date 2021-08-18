package com.bangkit.batikapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.batikapp.core.domain.usecase.BatikUseCase

class FavoriteViewModel(batikUseCase: BatikUseCase) : ViewModel() {

    val favoriteBatik = batikUseCase.getFavoriteBatik().asLiveData()

}