package tr.mfk.ecommerce.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tr.mfk.common.getCurrency
import tr.mfk.ecommerce.databinding.ItemRowProductBinding
import tr.mfk.networkmodule.model.Products

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    inner class ProductsViewHolder(val binding: ItemRowProductBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(
            ItemRowProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    var list = ArrayList<Products>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.apply {
            tvProductName.text = currentItem.title
            currentItem.price?.let {
                tvProductPrice.text = getCurrency(it)
            }
            Glide.with(holder.itemView.context)
                .load(currentItem.image)
                .fitCenter()
                .into(imgProduct)
        }
    }

    override fun getItemCount() = list.size

}