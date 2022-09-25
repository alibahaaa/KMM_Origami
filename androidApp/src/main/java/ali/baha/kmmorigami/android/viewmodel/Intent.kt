package ali.baha.kmmorigami.android.viewmodel

import ali.baha.kmmorigami.android.base.UiIntent

sealed class Intent : UiIntent {
    object FetchOrigamiData : Intent()
}