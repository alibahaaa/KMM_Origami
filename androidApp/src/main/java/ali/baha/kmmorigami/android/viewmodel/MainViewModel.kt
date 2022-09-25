package ali.baha.kmmorigami.android.viewmodel

import ali.baha.kmmorigami.android.base.BaseViewModel
import ali.baha.kmmorigami.domain.usecase.GetOrigamiUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val getOrigamiUseCase: GetOrigamiUseCase
) : BaseViewModel<Intent,State>() {

    override fun createInitialState(): State = State.Idle

    override fun handleIntent(intent: Intent) {
        when(intent){
            Intent.FetchOrigamiData -> getOrigami()
        }
    }

    private fun getOrigami() = viewModelScope.launch {
        setState { State.Loading }
        val res = getOrigamiUseCase.invoke()
        if (res.isEmpty())
            setState { State.Error }
        else
            setState { State.Origami(res) }
    }
}