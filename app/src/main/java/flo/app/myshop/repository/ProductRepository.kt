package flo.app.myshop.repository

import flo.app.myshop.api.ApiClient
import flo.app.myshop.api.ApiInterface
import flo.app.myshop.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
//val apiClient = ApiClient.buildApiCLient(ApiInterface::class.java)
    suspend fun getProducts():Response<ProductResponse>{
         return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }
    }


}