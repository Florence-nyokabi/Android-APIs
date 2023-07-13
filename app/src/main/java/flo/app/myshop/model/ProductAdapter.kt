package flo.app.myshop.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import flo.app.myshop.databinding.ProductListBinding



class ProductAdapter(var products: List<Product>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductListBinding.inflate(LayoutInflater.from(parent.context))
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var myProduct = products.get(position)
        var binding = holder.binding.apply {

            tvProductId.text = "${myProduct.id}."
            tvProductTitle.text = "${myProduct.title}"
            tvProductDescription.text = "${myProduct.description}"
            tvCategory.text = "${myProduct.category}"
            tvProductStock.text = "${myProduct.stock}"
            tvProductPrice.text ="${myProduct.price}/-"
            tvRatings.text ="${myProduct.rating}"

            Picasso.get().load(myProduct.thumbnail).into(ivThumbnail)

        }



//        binding.tvProductId.text = myProduct.id.toString()
//        binding.tvProductPrice.text = myProduct.price.toString()
//        binding.tvProductTitle.text = myProduct.title.toString()
//        binding.tvProductDescription.text = myProduct.description.toString()
//        binding.tvProductStock.text = myProduct.stock.toString()
//        binding.tvCategory.text = myProduct.category.toString()
//        binding.tvRatings.text = myProduct.rating.toString()
//
//        Picasso
//            .get()
//            .load(myProduct.thumbnail)
//            .into(binding.ivThumbnail)
//
//

    }

    override fun getItemCount(): Int {
        return products.size
    }
}

//class ProductViewHolder(var binding: ProductItemBinding):RecyclerView.ViewHolder(binding.root)
class ProductViewHolder(var binding: ProductListBinding):RecyclerView.ViewHolder(binding.root)