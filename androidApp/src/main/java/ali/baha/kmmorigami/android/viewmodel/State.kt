package ali.baha.kmmorigami.android.viewmodel

import ali.baha.kmmorigami.android.base.UiState
import ali.baha.kmmorigami.domain.entity.Entity

sealed class State : UiState {
    object Idle : State()
    object Error : State()
    object Loading : State()
    data class Origami(val origami: List<Entity>) : State()
}