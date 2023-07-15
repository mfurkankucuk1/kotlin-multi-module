package tr.mfk.ecommerce.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tr.mfk.ecommerce.data.model.Products
import tr.mfk.ecommerce.data.repository.CommerceRepository
import javax.inject.Inject

@HiltViewModel
class CommerceViewModel @Inject constructor(
    application: Application,
    private val commerceRepository: CommerceRepository
) : AndroidViewModel(application) {

    private var _productsResponse: MutableLiveData<List<Products>> = MutableLiveData()
    val productsResponse: LiveData<List<Products>> get() = _productsResponse

    fun getAllProducts() = viewModelScope.launch {
        getAllProductsSafeCall()
    }

    private suspend fun getAllProductsSafeCall() {
        _productsResponse.value = commerceRepository.getAllProducts().body()
    }

}