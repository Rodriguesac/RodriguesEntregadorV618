package br.com.rodrigues.entregador.features.history

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.Muted
import br.com.rodrigues.entregador.core.ui.*
import br.com.rodrigues.entregador.data.DemoData

@Composable
fun HistoryScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        BigTitle("Histórico", "Uma corrida por linha, sem repetir cada etapa")
        DemoData.history.forEach { ride ->
            AppCard {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text("Rota ${ride.shortCode}", fontWeight = FontWeight.ExtraBold)
                        Text("${ride.neighborhood} • Hoje", color = Muted)
                    }
                    Metric(ride.stage.name.replace('_',' '), "R$ ${"%.2f".format(ride.deliveryFee)}")
                }
            }
        }
    }
}
