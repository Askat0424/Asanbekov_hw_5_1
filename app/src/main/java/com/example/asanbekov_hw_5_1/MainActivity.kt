package com.example.asanbekov_hw_5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.asanbekov_hw_5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),CounterView{

    lateinit var binding: ActivityMainBinding
    var presenter = Injector.fillPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.incrementCount()
            }

            decrementBtn.setOnClickListener {
                presenter.decrementCount()
            }
        }
    }

    override fun updateText(count: String) {
        binding.tvResult.text = count
    }

    override fun changeColor(color: Int) {
        binding.tvResult.setTextColor(color)
    }

    override fun showToast() {
        Toast.makeText(this,"Поздравляем!!!", Toast.LENGTH_SHORT).show()
    }
}
