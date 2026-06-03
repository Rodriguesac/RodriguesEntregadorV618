package br.com.rodrigues.entregador.features.rides

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.*
import br.com.rodrigues.entregador.core.ui.*
import br.com.rodrigues.entregador.data.DemoData

@Composable
fun RideScreen() {
    val ride = DemoData.currentRide
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        BigTitle("Corrida atual", "Rota ${ride.shortCode} • ${ride.stage.name.replace('_',' ')}")
        AppCard {
            StatusPill("Indo para coleta")
            Spacer(Modifier.height(12.dp))
            Text(ride.store, fontWeight = FontWeight.ExtraBold)
            Text("${ride.neighborhood} • ${ride.distanceKm} km • ${ride.etaMin} min", color = Muted)
            Spacer(Modifier.height(12.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Metric("Taxa", "R$ ${"%.2f".format(ride.deliveryFee)}")
                Metric("Pedidos prontos", "${ride.readyCount}/${ride.totalOrders}")
                Metric("Pagamento", ride.payment.mode.name.lowercase().replaceFirstChar { it.uppercase() })
            }
        }
        MapPlaceholder(title = "Mapa da rota", subtitle = "Coleta → Entrega • sem cards por cima do mapa")
        AppCard {
            Text("Pagamento operacional", fontWeight = FontWeight.ExtraBold)
            Text("${ride.payment.status} • Receber R$ ${"%.2f".format(ride.payment.amountToCollect)}", color = Muted)
            Text("Troco para R$ ${"%.2f".format(ride.payment.changeFor ?: 0.0)}", color = Warn)
        }
        PrimaryAction("Cheguei na coleta")
        PrimaryAction("Problema na rota", danger = true)
    }
}

@Composable
fun MapPlaceholder(title: String, subtitle: String) {
    AppCard {
        Text(title, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(8.dp))
        Text("▦  •  •  •  ━━━━━━━━━  •  •  •  ▦", color = Green)
        Spacer(Modifier.height(8.dp))
        Text(subtitle, color = Muted)
    }
}
