package com.example.fashionday.domain.usecase

import com.example.fashionday.data.network.model.ProductResponse
import com.example.fashionday.data.repository.PlaceRepository
import javax.inject.Inject

class FetchAllProductsUseCase @Inject constructor(private val repository: PlaceRepository) {
    suspend operator fun invoke(): Result<ProductResponse> = repository.fetchProducts()
}