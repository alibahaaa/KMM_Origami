package ali.baha.kmmorigami.android.view.home

import ali.baha.kmmorigami.android.R
import ali.baha.kmmorigami.android.app.routers.Screen
import ali.baha.kmmorigami.android.uikit.TextView
import ali.baha.kmmorigami.domain.entity.Entity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun HomeScreenDataView(navController: NavController, data: List<Entity>?) {
    LazyColumn {
        items(data!!) { data ->
            Card(
                modifier = Modifier
                    .padding(vertical = 6.dp, horizontal = 12.dp)
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(
                            Screen.DetailScreen.withArgs(
                                data.name,
                                data.image.replace("/","\\"),
                                data.description
                            )
                        )
                    },
                backgroundColor = Color(0xFFF8F8F8)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp, 16.dp, 24.dp, 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = data.image,
                                builder = {
                                    transformations(CircleCropTransformation())
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )
                        TextView(text = data.name)
                    }
                    Image(
                        modifier = Modifier
                            .rotate(180F)
                            .height(24.dp)
                            .width(24.dp),
                        painter = painterResource(
                            id = R.drawable.arrow

                        ),
                        contentDescription = "Home Screen Data Image",
                    )
                }
            }
        }
    }
}
