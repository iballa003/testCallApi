package org.iesharia.testcallapi.network.product

import org.iesharia.testcallapi.network.product.model.ProductListResponse

class ProductRepository {
    val api = ProductService()

    suspend fun getAllProducts(): ProductListResponse {
        return api.getAllProducts()
    }
}