package mx.com.pixir.ejemplo.data

import com.google.gson.annotations.SerializedName

data class EntityResponse<T>(
    @SerializedName("entity") val entity: T,
    @SerializedName("entityList") val entityList: List<T>? = null,
    @SerializedName("message") val message: Any? = null,
    @SerializedName("statusCode") val statusCode: Long
)