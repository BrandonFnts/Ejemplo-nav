package mx.com.pixir.ejemplo.presentation.screens.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mx.com.pixir.ejemplo.data.network.example.response.ExampleResponse
import mx.com.pixir.ejemplo.domain.usecase.example.ExampleUseCases
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val exampleUseCases: ExampleUseCases
) : ViewModel() {
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _age = MutableLiveData(0)
    val age: LiveData<Int> = _age

    private  val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private fun getEntity(): ExampleResponse {
        return ExampleResponse(
            name = _name.value!!,
            age = _age.value!!
        )
    }

    fun getExample() = viewModelScope.launch {
        val example = getEntity()
        exampleUseCases.getExample(example)
    }

    fun onNameChanged(name: String) {
        _name.value = name
    }

    fun onAgeChanged(age: Int) {
        _age.value = age
    }


}