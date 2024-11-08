package com.example.a5month_1hw

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a5month_1hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val presenter = CounterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachCounterView(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrementCount()
            }
            btnDecrement.setOnClickListener {
                presenter.onDecrementCount()
            }


        }

    }
    override fun showResult(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun showToast(toast: String) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
    }

    override fun textColor(color: Int) {
        binding.tvCount.setTextColor(color)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachCounterView()
    }
}