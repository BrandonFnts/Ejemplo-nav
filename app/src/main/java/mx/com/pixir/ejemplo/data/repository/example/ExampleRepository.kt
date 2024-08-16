package mx.com.pixir.ejemplo.data.repository.example

import mx.com.pixir.ejemplo.data.network.example.ExampleService
import mx.com.pixir.ejemplo.data.network.example.response.ExampleResponse
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val exampleService: ExampleService
) {
    suspend fun processGetExample(entity: ExampleResponse): ExampleResponse {
        return try {
            val response = exampleService.processGetExample(entity)
            response.entity
        } catch (e : Exception) {
            throw Exception()
        }
    }
}