package com.example.algunsmetodosjaaprendidos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ItemData(
    val id: Int,
    val titulo: String,
    val descricao: String
)

@Composable
fun ExemploLazyColumn(itens: List<ItemData>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(itens, key = { item -> item.id }) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = item.titulo)
                    Text(text = item.descricao)
                }
            }
        }
    }
}