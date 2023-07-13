package com.example.fashionday.ui.screen.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fashionday.domain.model.Product
import com.example.fashionday.domain.usecase.FetchAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProductUiState(
    val isLoading: Boolean = false,
    val products: LinkedHashMap<Int, Product> = linkedMapOf()
) {
    val productList: List<Product>
        get() = products.values.toList()
}

@HiltViewModel
class MainViewModel @Inject constructor(
    val fetchProductsUseCase: FetchAllProductsUseCase
) : ViewModel() {

    var uiState = MutableStateFlow(ProductUiState())
        private set

    init {
        fetchProducts()
    }

    fun deleteItemOnLongPressed(productId: Int) {
//        uiState = uiState.value.copy(
//            products = LinkedHashMap(uiState.products.filterKeys { it != productId })
//        )
    }

    fun fetchProducts() {
        uiState.value = uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            fetchProductsUseCase().onSuccess { list ->
                val newProducts =
                    list.products.filterNot { it.productId in uiState.value.products.keys }
                uiState.value = uiState.value.copy(
                    products = uiState.value.products.apply {
                        newProducts.forEach {
                            put(
                                it.productId,
                                it
                            )
                        }
                    },
                    isLoading = false
                )
            }.onFailure { exception ->
                Log.e("MainViewModel", "Error fetching products: ", exception)
                uiState.value = uiState.value.copy(isLoading = false)
            }
        }
    }
}


