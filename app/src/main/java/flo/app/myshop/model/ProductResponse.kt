package flo.app.myshop.model

import flo.app.myshop.model.Product

data class ProductResponse(
    var products: List<Product>,
    var total :Int,
    var skip: Int,
    var limit: Int
)
