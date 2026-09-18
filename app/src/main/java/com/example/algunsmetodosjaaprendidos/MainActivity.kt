package com.example.algunsmetodosjaaprendidos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.algunsmetodosjaaprendidos.ui.theme.AlgunsmetodosjaaprendidosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlgunsmetodosjaaprendidosTheme {
                Scaffold() { inner ->
                    Column(modifier = Modifier.padding(inner)){
                        //ExemploFormulario()
                        //ExemploLayouts()
                        //ExemploNavegacao()
                        ExemploViewModel()
                        /* as
                        val algo = remember{
                            listOf(
                            ItemData(1,"algo","feito para alguem"),
                            ItemData(2,"algo","feito por algum motivo"),
                            ItemData(3,"algo","feito para ensinar")
                            )
                        }
                        ExemploLazyColumn(algo)
                        */
                    }
                   }

            }
        }
    }
}