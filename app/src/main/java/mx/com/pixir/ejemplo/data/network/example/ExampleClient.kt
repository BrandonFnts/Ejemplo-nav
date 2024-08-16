package mx.com.pixir.ejemplo.data.network.example

import mx.com.pixir.ejemplo.data.EntityResponse
import mx.com.pixir.ejemplo.data.network.example.response.ExampleResponse
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Body

interface ExampleClient {

    @GET("example")
    suspend fun getExample(@Body requestBody: ExampleResponse): Response<EntityResponse<ExampleResponse>>

}