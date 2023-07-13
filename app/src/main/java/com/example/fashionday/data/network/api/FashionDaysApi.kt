package com.example.fashionday.data.network.api

import com.example.fashionday.data.network.model.ProductResponse
import retrofit2.http.GET

interface FashionDaysApi {

    @GET("mobile/8/g/women/clothing/")
    suspend fun getProducts(): ProductResponse

}