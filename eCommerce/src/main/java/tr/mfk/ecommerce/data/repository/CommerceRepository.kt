package tr.mfk.ecommerce.data.repository

import tr.mfk.ecommerce.data.remote.ProductService
import javax.inject.Inject

class CommerceRepository @Inject constructor(private val productService: ProductService) {


    suspend fun getAllProducts() = productService.getAllProducts()


}