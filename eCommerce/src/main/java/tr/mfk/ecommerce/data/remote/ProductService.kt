package tr.mfk.ecommerce.data.remote

import retrofit2.Response
import retrofit2.http.GET
import tr.mfk.ecommerce.data.model.Products

interface ProductService {

    @GET("products/")
    suspend fun getAllProducts(): Response<List<Products>>

}