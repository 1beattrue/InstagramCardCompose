package edu.mirea.onebeattrue.instagramcardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import edu.mirea.onebeattrue.instagramcardcompose.ui.theme.InstagramCardComposeTheme
import edu.mirea.onebeattrue.instagramcardcompose.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test(viewModel = viewModel)
//            InstagramCardComposeTheme {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(MaterialTheme.colorScheme.background)
//                ) {
//                    InstagramProfileCard(viewModel)
//                }
//            }
        }
    }
}

@Composable
private fun Test(viewModel: MainViewModel) {
    InstagramCardComposeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.ic_instagram),
                        contentDescription = null
                    )
                }
                repeat(5) {
                    item {
                        InstagramProfileCard(viewModel)
                    }
                }
                item {
                    Image(
                        painter = painterResource(id = R.drawable.ic_instagram),
                        contentDescription = null,

                    )
                }
                repeat(5) {
                    item {
                        InstagramProfileCard(viewModel)
                    }
                }
            }
        }
    }
}