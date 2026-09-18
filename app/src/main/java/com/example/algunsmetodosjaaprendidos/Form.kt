package com.example.algunsmetodosjaaprendidos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExemploFormulario() {
    var nome by remember { mutableStateOf("") }
    var mensagemSucesso by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nome,
            onValueChange = { novoTexto -> nome = novoTexto },
            label = { Text("Digite seu nome") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (nome.isNotBlank()) {
                    mensagemSucesso = "Olá, $nome!"
                }
            }
        ) {
            Text("Enviar")
        }

        if (mensagemSucesso.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = mensagemSucesso)
        }
    }
}