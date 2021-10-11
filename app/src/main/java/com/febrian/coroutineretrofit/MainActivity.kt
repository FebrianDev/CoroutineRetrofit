package com.febrian.coroutineretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.febrian.coroutineretrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isLoading(true)
        CoroutineScope(Dispatchers.IO).launch {
            getRecipe()
        }

    }

    private fun isLoading(state: Boolean) {
        binding.loading.isVisible = state
    }

    private suspend fun getRecipe() {
        val response = ApiConfig.getService().getRecipe()
        val results = response.results

        runOnUiThread {
            showRecipe(results)
        }
    }

    private fun showRecipe(results: List<Responses>) {
        val adapter = ListAdapter(results as ArrayList)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter
        isLoading(false)
    }
}