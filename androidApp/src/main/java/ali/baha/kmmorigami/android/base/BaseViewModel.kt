package ali.baha.kmmorigami.android.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * SPECIAL Thanks to @author Yusuf Ceylan.
 * https://proandroiddev.com/mvi-architecture-with-kotlin-flows-and-channels-d36820b2028d
 */

/**
 * Base class for [ViewModel] instances
 */
abstract class BaseViewModel<Intent : UiIntent, State : UiState, /*Effect : UiEffect*/> : ViewModel() {

    private val initialState : State by lazy { createInitialState() }
    abstract fun createInitialState() : State

    val currentState: State
        get() = uiState.value

    private val _uiState : MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _intent : MutableSharedFlow<Intent> = MutableSharedFlow()
    val intent = _intent.asSharedFlow()

    init {
        subscribeIntent()
    }

    /**
     * Start listening to Event
     */
    private fun subscribeIntent() {
        viewModelScope.launch {
            intent.collect {
                handleIntent(it)
            }
        }
    }

    /**
     * Handle each event
     */
    abstract fun handleIntent(intent : Intent)

    /**
     * Set new Event
     */
    fun sendIntent(intent : Intent) {
        val newIntent = intent
        viewModelScope.launch { _intent.emit(newIntent) }
    }

    /**
     * Set new Ui State
     */
    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }
}

interface UiIntent

interface UiState