package com.example.algunsmetodosjaaprendidos

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.currentStateAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun ExemploNavegacao() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val lifecycleState
        by
            navBackStackEntry
                ?.lifecycle
                ?.currentStateAsState()
            ?:
            androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(Lifecycle.State.INITIALIZED) }

    val isReadyToClick = lifecycleState.isAtLeast(Lifecycle.State.RESUMED)

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            TelaHome(
                onNavegar = { navController.navigate("detalhes") },
                isReadyToClick = isReadyToClick
            )
        }
        composable("detalhes") {
            TelaDetalhes(
                onVoltar = { navController.popBackStack() },
                isReadyToClick = isReadyToClick
            )
        }
    }
}

@Composable
fun TelaHome(onNavegar: () -> Unit, isReadyToClick: Boolean) {
    Column(modifier = Modifier.padding(50.dp)) {
        Text("Tela Inicial")
        Button(
            onClick = onNavegar,
            enabled = isReadyToClick
        ) {
            Text("Ir para Detalhes")
        }
    }
}

@Composable
fun TelaDetalhes(onVoltar: () -> Unit, isReadyToClick: Boolean) {
    Column(modifier = Modifier.padding(50.dp)) {
        Text("Tela de Detalhes")
        Button(
            onClick = onVoltar,
            enabled = isReadyToClick
        ) {
            Text("Voltar")
        }
    }
}