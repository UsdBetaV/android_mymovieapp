package app.beta.myanimeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.beta.myanimeapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}