package tr.mfk.ecommerce.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import tr.mfk.ecommerce.data.model.Products
import tr.mfk.ecommerce.databinding.ActivityEcommerceBinding
import tr.mfk.ecommerce.ui.adapter.ProductsAdapter
import tr.mfk.ecommerce.ui.viewModel.CommerceViewModel

@AndroidEntryPoint
class ECommerceActivity : AppCompatActivity() {

    private var _binding: ActivityEcommerceBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CommerceViewModel
    private val productsAdapter = ProductsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityEcommerceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeViewModel()
        setupAdapter()
        getProducts()
        subscribeObserve()
    }

    private fun subscribeObserve() {
        viewModel.productsResponse.observe(this) { response ->
            val mList = ArrayList<Products>()
            mList.addAll(response)
            productsAdapter.list = mList
        }
    }

    private fun getProducts() {
        viewModel.getAllProducts()
    }

    private fun setupAdapter() {
        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(this@ECommerceActivity, 2)
            adapter = productsAdapter
        }
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this)[CommerceViewModel::class.java]
    }
}