package ucne.edu.apiarticulosap2.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ucne.edu.apiarticulosap2.data.remote.dto.ArticulosDTO

interface ArticulosApi {
    @GET("api/Articulos")
    suspend fun GetArticulos(): Response<List<ArticulosDTO>>

    @POST("api/Articulos")
    suspend fun PostArticulo(@Body articulo: ArticulosDTO): Response<ArticulosDTO>

}