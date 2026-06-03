package br.com.rodrigues.entregador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.rodrigues.entregador.core.theme.RodriguesTheme
import br.com.rodrigues.entregador.navigation.RodriguesApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { RodriguesTheme { RodriguesApp() } }
    }
}
