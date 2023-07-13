package com.example.fashionday.data.network.model

import com.example.fashionday.domain.model.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("products")
    val products: List<Product>
)
