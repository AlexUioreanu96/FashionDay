package com.example.fashionday.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stamp(
    @SerialName("cluster_id") val clusterId: Int,
    @SerialName("text_color") val textColor: String,
    @SerialName("background_color") val backgroundColor: String,
    @SerialName("opacity") val opacity: Int,
    @SerialName("template") val template: String,
    @SerialName("label") val label: String
)

@Serializable
data class ProductImages(
    @SerialName("listing") val listing: List<String>,
    @SerialName("detail") val detail: List<String>,
    @SerialName("zoom") val zoom: List<String>?,
    @SerialName("thumb") val thumb: List<String>?
)

@Serializable
data class Product(
    @SerialName("stamps") val stamps: List<Stamp>? = listOf(),
    @SerialName("product_id") val productId: Int,
    @SerialName("product_name") val productName: String,
    @SerialName("product_images") val productImages: ProductImages,
    @SerialName("product_price") val productPrice: Double,
    @SerialName("product_original_price") val productOriginalPrice: Double,
    @SerialName("product_type") val productType: String,
    @SerialName("product_stock_state") val productStockState: String,
    @SerialName("product_brand") val productBrand: String,
    @SerialName("product_brand_id") val productBrandId: Int,
    @SerialName("product_tag_id") val productTagId: Int,
    @SerialName("sku") val sku: String,
    @SerialName("discount_type") val discountType: String,
    @SerialName("hv") val hv: Int,
    @SerialName("has_vrs") val hasVrs: Int,
    @SerialName("classification_name") val classificationName: String,
    @SerialName("classification") val classification: String,
    @SerialName("classification_id") val classificationId: String,
    @SerialName("sub_classification") val subClassification: String,
    @SerialName("sub_classification_id") val subClassificationId: String,
    @SerialName("tag_name") val tagName: String,
    @SerialName("product_is_new") val productIsNew: Int,
    @SerialName("product_discount") val productDiscount: Int,
    @SerialName("screen_title") val screenTitle: String,
    @SerialName("subclassification_name") val subclassificationName: String? = null
)
