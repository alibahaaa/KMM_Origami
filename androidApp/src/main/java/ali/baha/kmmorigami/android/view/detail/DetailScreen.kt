package ali.baha.kmmorigami.android.view.detail

import ali.baha.kmmorigami.android.uikit.BigTextView
import ali.baha.kmmorigami.android.uikit.TopBarType
import ali.baha.kmmorigami.android.uikit.TopBarView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun DetailScreen(
    navController: NavController,
    name: String?,
    image: String?,
    description: String?
) {
    Scaffold(
        topBar = {
            TopBarView(
                title = name ?: "null",
                topBarType = TopBarType.Detail,
                navController = navController
            )
        },
    ) {
        LazyColumn {
            item {
                Image(
                    painter = rememberImagePainter(
                        data = image ?: "null",
                        builder = {
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(251.dp)
                        .padding(12.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                        .fillMaxWidth()
                        .background(Color(0xFFF8F8F8))
                )
                BigTextView(text = description ?: "null")
                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                        .fillMaxWidth()
                        .background(Color(0xFFF8F8F8))
                )
            }
        }
    }
}