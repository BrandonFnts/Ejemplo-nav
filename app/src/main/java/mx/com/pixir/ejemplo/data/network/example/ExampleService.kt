package mx.com.pixir.ejemplo.data.network.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.com.pixir.ejemplo.data.EntityResponse
import mx.com.pixir.ejemplo.data.network.example.response.ExampleResponse
import javax.inject.Inject

class ExampleService @Inject constructor(
    private val exampleClient: ExampleClient
){
    suspend fun processGetExample(entity: ExampleResponse): EntityResponse<ExampleResponse> {
        return withContext(Dispatchers.IO) {
            val response = exampleClient.getExample(requestBody = entity)
            response.body()?.copy() ?: throw IllegalStateException("Response body was null.")
        }
    }
}