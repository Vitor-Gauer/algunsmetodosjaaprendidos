package com.example.algunsmetodosjaaprendidos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContadorViewModel : ViewModel() {
    private val _contador = MutableStateFlow(0)
    val contador: StateFlow<Int> = _contador.asStateFlow()

    fun incrementar() {
        _contador.value++
    }
}

@Composable
fun ExemploViewModel(viewModel: ContadorViewModel = viewModel()) {
    val contadorState by viewModel.contador.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Contagem: $contadorState")
        Button(onClick = { viewModel.incrementar() }) {
            Text("Incrementar")
        }
    }
}