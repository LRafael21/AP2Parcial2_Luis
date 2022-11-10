package ucne.edu.parcial2_luis.data.remote

import retrofit2.Response
import retrofit2.http.GET
import ucne.edu.parcial2_luis.data.remote.dto.VerbosDTO

interface VerbosApi {

    @GET("/verbos")
    suspend fun getVerbos(): Response<List<VerbosDTO>>
}