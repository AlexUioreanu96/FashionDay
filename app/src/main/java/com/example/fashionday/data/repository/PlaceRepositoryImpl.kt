package com.example.fashionday.data.repository

import com.example.fashionday.data.network.api.FashionDaysApi
import com.example.fashionday.data.network.model.ProductResponse
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(
    private val endpoints: FashionDaysApi,
) : PlaceRepository {
    override suspend fun fetchProducts(): Result<ProductResponse> =
        try {
            val response = endpoints.getProducts()
            Result.success(response)
        } catch (e: Throwable) {
            Result.failure(e)
        }
}