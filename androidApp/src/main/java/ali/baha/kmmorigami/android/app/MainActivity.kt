package ali.baha.kmmorigami.android.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ali.baha.kmmorigami.android.app.navigation.Navigation
import ali.baha.kmmorigami.android.viewmodel.MainViewModel
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(viewModel)
        }
    }
}
