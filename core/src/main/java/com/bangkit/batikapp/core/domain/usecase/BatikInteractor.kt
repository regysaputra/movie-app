package com.bangkit.batikapp.core.domain.usecase

import com.bangkit.batikapp.core.domain.model.Batik
import com.bangkit.batikapp.core.domain.repository.IBatikRepository
import javax.inject.Inject

class BatikInteractor @Inject constructor(private val batikRepository: IBatikRepository): BatikUseCase {

    override fun getAllBatik() = batikRepository.getAllBatik()

    override fun getFavoriteBatik() = batikRepository.getFavoriteBatik()

    override fun setFavoriteBatik(batik: Batik, state: Boolean) = batikRepository.setFavoriteBatik(batik, state)
}