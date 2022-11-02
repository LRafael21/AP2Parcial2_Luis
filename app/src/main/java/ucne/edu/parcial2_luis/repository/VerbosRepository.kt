package ucne.edu.parcial2_luis.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ucne.edu.parcial2_luis.remote.VerbosApi
import ucne.edu.parcial2_luis.remote.dto.VerbosDTO
import javax.inject.Inject

class VerbosRepository @Inject constructor(
    private val api: VerbosApi
) {

    suspend fun getVerbos(): List<VerbosDTO> {
        return withContext(Dispatchers.IO) {
            val response = api.GetVerbos()
            response.body() ?: emptyList()
        }
    }
}