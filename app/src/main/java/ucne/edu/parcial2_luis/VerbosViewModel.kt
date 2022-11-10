package ucne.edu.parcial2_luis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import ucne.edu.parcial2_luis.data.remote.dto.VerbosDTO
import ucne.edu.parcial2_luis.repository.VerbosRepository
import java.io.IOException
import javax.inject.Inject

data class VerbosListUIState(
    val verbos : List<VerbosDTO> = emptyList()
)

@HiltViewModel
class VerbosViewModel @Inject constructor(
   val repository: VerbosRepository
):ViewModel()
{
    private val _uiState = MutableStateFlow(VerbosListUIState())
    val uiState : StateFlow<VerbosListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                try {
                    it.copy(verbos = repository.getVerbos())
                }catch (IO : IOException)
                {
                    it.copy(verbos = emptyList())
                }
            }
        }


    }
}