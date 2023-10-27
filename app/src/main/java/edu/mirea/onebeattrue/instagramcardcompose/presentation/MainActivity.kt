package edu.mirea.onebeattrue.instagramcardcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import edu.mirea.onebeattrue.instagramcardcompose.ui.theme.InstagramCardComposeTheme
import edu.mirea.onebeattrue.instagramcardcompose.ui.theme.InstagramProfileCard
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test(viewModel = viewModel)
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
            val models = viewModel.models.observeAsState(listOf())
            val lazyListState = rememberLazyListState()
            val scope = rememberCoroutineScope()
            LazyColumn(
                state = lazyListState
            ) {
                items(models.value) { model ->
                    InstagramProfileCard(
                        model = model,
                        onFollowedButtonClickListener = viewModel::changeFollowingStatus
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                FloatingActionButton(
                    modifier = Modifier.padding(8.dp),
                    onClick = {
                        scope.launch {
                            lazyListState.animateScrollToItem(0)
                        }
                    }
                ) {
                    Icon(Icons.Rounded.KeyboardArrowUp, contentDescription = null)
                }
            }
        }
    }
}