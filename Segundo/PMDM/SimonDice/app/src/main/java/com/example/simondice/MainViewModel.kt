import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simondice.RexistroDatos
import com.example.simondice.RepositorioRexistro
import com.example.simondice.ui.theme.Blue
import com.example.simondice.ui.theme.Green
import com.example.simondice.ui.theme.Yellow
import com.example.simondice.ui.theme.Red
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * ViewModel principal para o xogo de Simon Dice.
 * @param repositorio Instancia do repositorio para rexistrar datos.
 */
class MainViewModel(private val repositorio: RepositorioRexistro) : ViewModel() {
    // Estado do rexistro de datos
    private val _rexistro = MutableStateFlow(RexistroDatos(0))
    val rexistro: StateFlow<RexistroDatos> get() = _rexistro

    // Estado da secuencia de cores do xogo
    private val _secuencia = MutableStateFlow<List<Color>>(emptyList())
    val secuencia: StateFlow<List<Color>> get() = _secuencia

    // Estado da secuencia de cores introducida polo usuario
    private val _secuenciaUsuario = MutableStateFlow<List<Color>>(emptyList())
    val secuenciaUsuario: StateFlow<List<Color>> get() = _secuenciaUsuario

    // Estado da cor actual mostrada
    private val _corActual = MutableStateFlow<Color?>(null)
    val corActual: StateFlow<Color?> get() = _corActual

    // Estado da mensaxe de erro
    private val _mensaxeErro = MutableStateFlow<String?>(null)
    val mensaxeErro: StateFlow<String?> get() = _mensaxeErro

    // Lista de cores dispoñibles no xogo
    private val cores = listOf(
        Green,
        Red,
        Blue,
        Yellow
    )

    // Inicializa un novo xogo ao crear a instancia do ViewModel
    init {
        iniciarNovoXogo()
    }

    /**
     * Inicia un novo xogo, reiniciando as secuencias e engadindo a primeira cor.
     */
    fun iniciarNovoXogo() {
        _secuencia.value = emptyList()
        _secuenciaUsuario.value = emptyList()
        engadirCorASecuencia()
    }

    /**
     * Engade unha nova cor aleatoria á secuencia do xogo.
     */
    fun engadirCorASecuencia() {
        val novaCor = cores[Random.nextInt(cores.size)]
        _secuencia.value = _secuencia.value + novaCor
        mostrarSecuencia()
    }

    /**
     * Mostra a secuencia de cores ao usuario cunha pausa entre cada cor.
     */
    fun mostrarSecuencia() {
        viewModelScope.launch {
            _secuencia.value.forEach { cor ->
                _corActual.value = cor
                delay(1000)
                _corActual.value = null
                delay(500)
            }
        }
    }

    /**
     * Procesa a entrada de cor do usuario e comproba se a secuencia está completa.
     * @param cor A cor introducida polo usuario.
     */
    fun entradaUsuario(cor: Color) {
        _secuenciaUsuario.value += cor
        Log.d("MainViewModel", "Entrada de usuario cor: $cor")
        if (_secuenciaUsuario.value.size == _secuencia.value.size) {
            comprobarSecuenciaUsuario()
        }
    }

    /**
     * Comproba se a secuencia introducida polo usuario coincide coa secuencia do xogo.
     * Se coincide, engade unha nova cor á secuencia. Se non, reinicia o xogo.
     */
    fun comprobarSecuenciaUsuario() {
        if (_secuenciaUsuario.value == _secuencia.value) {
            _rexistro.value = RexistroDatos(_rexistro.value.rexistro + 1)
            _secuenciaUsuario.value = emptyList()
            engadirCorASecuencia()
        } else {
            Log.e("MainViewModel", "A secuencia do usuario non coincide coa secuencia do xogo")
            _mensaxeErro.value = "¡Perdiches! Inténtao de novo."
            iniciarNovoXogo()
        }
    }

    /**
     * Limpa a mensaxe de erro.
     */
    fun limparMensaxeErro() {
        _mensaxeErro.value = null
    }
}