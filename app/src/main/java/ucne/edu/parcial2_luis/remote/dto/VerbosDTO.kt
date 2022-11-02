package ucne.edu.parcial2_luis.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VerbosDTO(
    val Verbo : String,
    val Categoria : String,
    val Nivel : String,
    val Imagen : String

)
