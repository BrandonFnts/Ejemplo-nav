package mx.com.pixir.ejemplo.domain.usecase.example

import mx.com.pixir.ejemplo.data.network.example.response.ExampleResponse
import mx.com.pixir.ejemplo.data.repository.example.ExampleRepository
import javax.inject.Inject

class GetExample @Inject constructor(
    private val _exampleRepository: ExampleRepository
){
    suspend operator fun invoke(entity: ExampleResponse): ExampleResponse =
        _exampleRepository.processGetExample(entity)
}