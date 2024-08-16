package mx.com.pixir.ejemplo.domain.model

class Encoder {

    companion object {

        fun stringEncoder(data: String): String {

            val regex: String = buildString { append("[?=&#+%/.; ]") }

            return data.replace(Regex(regex)) { matchResult ->
                when (matchResult.value) {
                    "?" -> "%3F"
                    "=" -> "%3D"
                    "&" -> "%26"
                    "#" -> "%23"
                    "+" -> "%2B"
                    "%" -> "%25"
                    "/" -> "%2F"
                    "." -> "%2E"
                    ";" -> "%3B"
                    " " -> "%20"
                    else -> matchResult.value
                }
            }

        }

    }

}
