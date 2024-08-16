package mx.com.pixir.ejemplo.domain.model.example

import com.google.gson.Gson
import mx.com.pixir.ejemplo.domain.model.Encoder

data class ExampleModel(
    val name: String,
    val age: String
) {
    fun toJson(): String = Gson().toJson(this.toEncoded())

    private fun toEncoded(): ExampleModel = this.let { data ->
        data.copy(
            name = Encoder.stringEncoder(data.name),
            age = Encoder.stringEncoder(data.age),
        )
    }

    companion object {
        fun fromJson(data: String): ExampleModel =
            Gson().fromJson(data, ExampleModel::class.java)
    }
}
