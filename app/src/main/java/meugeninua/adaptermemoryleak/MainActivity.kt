package meugeninua.adaptermemoryleak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContent { greeting(name = "meugen") }
    }

    @Composable
    fun greeting(name: String) {
        Text(text = "Hello, $name!")
    }

    @Preview
    @Composable
    fun previewGreeting() {
        greeting(name = "meugen")
    }
}