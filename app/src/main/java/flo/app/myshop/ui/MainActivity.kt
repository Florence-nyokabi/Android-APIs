package flo.app.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import flo.app.myshop.api.ApiClient
import flo.app.myshop.api.ApiInterface
import flo.app.myshop.databinding.ActivityMainBinding
import flo.app.myshop.model.Product
import flo.app.myshop.model.ProductAdapter
import flo.app.myshop.model.ProductResponse
import flo.app.myshop.viewmodel.ProductViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val productViewModel: ProductViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

//    var products: List<Product> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
//        getProducts()
        productViewModel.fetchProducts()

        productViewModel.productsLiveData.observe(this, Observer { productsList ->
            var adapter = ProductAdapter(productsList ?: emptyList())
                    binding.rvProductList.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvProductList.adapter = adapter
            Toast.makeText(baseContext, "fetched ${productsList?.size} products", Toast.LENGTH_LONG).show()
        })
        productViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }






//    fun getProducts(){
//        val ApiClient = ApiClient.buildClient(ApiInterface::class.java)
//        val request = ApiClient.getProducts()
//        request.enqueue(object : Callback<ProductResponse>{
//            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
//                if(response.isSuccessful){
//                    var products = response.body()?.products
//                    var adapter = ProductAdapter(products ?: emptyList())
//                    binding.rvProductList.layoutManager = LinearLayoutManager(this@MainActivity)
//                    binding.rvProductList.adapter = adapter
//
//                    Toast.makeText(baseContext, "fetched ${products?.size} products", Toast.LENGTH_LONG).show()
//                }
//                else{
//                    Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
//                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//            }
//        })
//    }
}