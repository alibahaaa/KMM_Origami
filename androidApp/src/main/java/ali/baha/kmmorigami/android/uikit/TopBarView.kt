package ali.baha.kmmorigami.android.uikit

import ali.baha.kmmorigami.android.R
import ali.baha.kmmorigami.android.app.routers.Screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TopBarView(title: String, topBarType: TopBarType, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(12.dp, 0.dp, 12.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (topBarType == TopBarType.Detail) {
            Image(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                painter = painterResource(
                    id = R.drawable.arrow
                ),
                contentDescription = "Top Bar Image",
            )
        } else {
            Spacer(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }

        TextView(text = title)

        Spacer(
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
    }
}

enum class TopBarType {
    Home, Detail
}