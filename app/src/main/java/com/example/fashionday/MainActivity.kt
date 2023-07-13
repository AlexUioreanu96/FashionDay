package com.example.fashionday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fashionday.ui.adapter.ProductAdapter
import com.example.fashionday.ui.screen.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity :
    ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_list)
        recyclerView = findViewById(R.id.list_item)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest {
                    val adapter = ProductAdapter(it.productList)
                    recyclerView.apply {
                        this.adapter = adapter
                        this.layoutManager =
                            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                    }
                }
            }
        }
//            FashionDayTheme {
//                MainScreen()
//            }
    }

    override fun onResume() {
        super.onResume()
    }
}
