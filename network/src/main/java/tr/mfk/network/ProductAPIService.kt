package tr.mfk.network

import retrofit2.Response
import retrofit2.http.GET
import tr.mfk.network.data.Products

interface ProductAPIService {

    @GET("products/")
    suspend fun getAllProduct(): Response<List<Products>>

}