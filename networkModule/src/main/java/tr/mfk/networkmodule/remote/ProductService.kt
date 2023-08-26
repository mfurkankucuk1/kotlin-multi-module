package tr.mfk.networkmodule.remote

import retrofit2.Response
import retrofit2.http.GET
import tr.mfk.networkmodule.model.Products

interface ProductService {

    @GET("products/")
    suspend fun getAllProducts(): Response<List<Products>>

}