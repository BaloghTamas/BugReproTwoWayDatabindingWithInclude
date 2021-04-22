package dev.bata.twowaydatabindingincludebugrepro

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.bata.twowaydatabindingincludebugrepro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewData = ViewData()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.model = viewData

        logPendingBindings(binding, viewData)
    }


    private fun logPendingBindings(binding: ActivityMainBinding, viewData: ViewData) {
        Log.d("DataBinding", "has pending bindings: ${binding.hasPendingBindings()}")
        binding.root.postDelayed({ logPendingBindings(binding, viewData) }, 500L)
    }
}
