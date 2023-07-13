package com.example.fashionday.data.repository

import com.example.fashionday.data.network.model.ProductResponse

interface PlaceRepository {

    suspend fun fetchProducts(): Result<ProductResponse>

}