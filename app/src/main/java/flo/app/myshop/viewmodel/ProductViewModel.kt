package flo.app.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import flo.app.myshop.model.Product
import flo.app.myshop.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel():ViewModel() {
    var productsRepo = ProductRepository()
    var productsLiveData = MutableLiveData<List<Product>>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchProducts(){
        viewModelScope.launch {
            val response = productsRepo.getProducts()
            if (response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}