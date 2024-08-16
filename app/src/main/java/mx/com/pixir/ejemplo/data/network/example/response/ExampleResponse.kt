package mx.com.pixir.ejemplo.data.network.example.response

import com.google.gson.annotations.SerializedName

data class ExampleResponse(
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int
)
