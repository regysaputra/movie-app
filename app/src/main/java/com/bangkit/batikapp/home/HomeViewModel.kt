package com.bangkit.batikapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.batikapp.core.domain.usecase.BatikUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(batikUseCase: BatikUseCase) : ViewModel() {

    val batik = batikUseCase.getAllBatik().asLiveData()

}