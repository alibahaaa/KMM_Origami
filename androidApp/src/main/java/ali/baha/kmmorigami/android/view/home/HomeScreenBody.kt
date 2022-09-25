package ali.baha.kmmorigami.android.view.home

import ali.baha.kmmorigami.android.uikit.TopBarType
import ali.baha.kmmorigami.android.uikit.TopBarView
import ali.baha.kmmorigami.domain.entity.Entity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreenBody(navController: NavController, data: List<Entity>?) {
    Scaffold(
        topBar = {
            TopBarView(
                title = "KMM Origami",
                topBarType = TopBarType.Home,
                navController = navController
            )
        },
    ) {
        HomeScreenDataView(navController = navController, data = data)
    }
}

