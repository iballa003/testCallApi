package org.iesharia.testcallapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.iesharia.testcallapi.network.product.ProductRepository
import org.iesharia.testcallapi.network.product.model.ProductResponse
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val productListRepository = ProductRepository()

    private val _productList = MutableLiveData<List<ProductResponse>>(emptyList())
    val productList: LiveData<List<ProductResponse>> = _productList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getAllProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            _productList.postValue(productListRepository.getAllProducts().productList)
            _isLoading.value = false
        }
    }
}