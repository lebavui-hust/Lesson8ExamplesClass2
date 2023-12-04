package vn.edu.hust.lesson8examples

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import vn.edu.hust.lesson8examples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var count = 456

    val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.count.observe(this){
            Log.v("TAG", "New count: $it")
        }

        viewModel.textA.observe(this) {

        }

        binding.buttonAdd.setOnClickListener {
            viewModel.increaseCount()
        }
    }
}