package ali.baha.kmmorigami.android.app.navigation

import ali.baha.kmmorigami.android.app.routers.Screen
import ali.baha.kmmorigami.android.view.detail.DetailScreen
import ali.baha.kmmorigami.android.view.home.HomeScreen
import ali.baha.kmmorigami.android.viewmodel.MainViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(
            route = Screen.DetailScreen.route + "/{name}/{image}/{description}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "name"
                    nullable = false
                },
                navArgument("image") {
                    type = NavType.StringType
                    defaultValue = "image"
                    nullable = false
                },
                navArgument("description") {
                    type = NavType.StringType
                    defaultValue = "description"
                    nullable = false
                }
            )
        ) { entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name"),
                image = entry.arguments?.getString("image"),
                description = entry.arguments?.getString("description")
            )
        }
    }
}