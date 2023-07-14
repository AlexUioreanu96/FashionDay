package com.example.fashionday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.fashionday.ui.screen.main.MainScreen
import com.example.fashionday.ui.screen.main.MainViewModel
import com.example.fashionday.ui.theme.FashionDayTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.product_list)
//        recyclerView = findViewById(R.id.list_item)

//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.uiState.collectLatest {
//                    val adapter = ProductAdapter(it.productList)
//                    recyclerView.apply {
//                        this.adapter = adapter
//                        this.layoutManager =
//                            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
//                    }
//                }
//            }
//        }
        setContent {
            FashionDayTheme {
                MainScreen()
            }
        }

    }

    override fun onResume() {
        super.onResume()
    }
}
