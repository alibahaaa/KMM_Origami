package ali.baha.kmmorigami.android.view.home

import ali.baha.kmmorigami.android.uikit.ErrorBody
import ali.baha.kmmorigami.android.uikit.LoadingBody
import ali.baha.kmmorigami.android.viewmodel.Intent
import ali.baha.kmmorigami.android.viewmodel.MainViewModel
import ali.baha.kmmorigami.android.viewmodel.State
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = viewModel()
) {
    val uiState = viewModel
        .uiState
        .collectAsState()
        .value

    when (uiState) {
        State.Error -> ErrorBody()
        State.Idle -> viewModel.sendIntent(Intent.FetchOrigamiData)
        State.Loading -> LoadingBody()
        is State.Origami -> HomeScreenBody(
            navController = navController,
            data = uiState.origami
        )
    }
}



