package ucne.edu.parcial2_luis.remote

import retrofit2.Response
import retrofit2.http.GET
import ucne.edu.parcial2_luis.remote.dto.VerbosDTO

interface VerbosApi {
    @GET("verbos")
    suspend fun GetVerbos(): Response<List<VerbosDTO>>


}
