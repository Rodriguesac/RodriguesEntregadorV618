package br.com.rodrigues.entregador.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.*
import br.com.rodrigues.entregador.core.ui.*
import br.com.rodrigues.entregador.data.DemoData

@Composable
fun HomeScreen(openRide: () -> Unit, openNotifications: () -> Unit) {
    val ride = DemoData.currentRide
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            BigTitle("Olá, Diego", "Rodrigues Açaí e Cia")
            BadgedBox(badge = { Badge { Text("1") } }) {
                IconButton(onClick = openNotifications) { Icon(Icons.Outlined.Notifications, contentDescription = "Notificações") }
            }
        }
        AppCard {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column { Text("Status operacional", color = Muted); Text("Disponível", fontWeight = FontWeight.ExtraBold, color = Green) }
                StatusPill("((•)) Disponível")
            }
            Spacer(Modifier.height(14.dp))
            PrimaryAction("Ficar indisponível")
        }
        AppCard {
            Text("Ganhos de hoje", color = Muted)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Metric("Disponível", "R$ 42,50")
                Metric("Corridas", "6")
                Metric("Finalizadas", "5")
            }
        }
        AppCard {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.weight(1f)) {
                    Text("Corrida em andamento", fontWeight = FontWeight.ExtraBold)
                    Text("${ride.shortCode} • ${ride.neighborhood} • R$ ${"%.2f".format(ride.deliveryFee)}", color = Muted)
                }
                StatusPill("Abrir")
            }
            Spacer(Modifier.height(12.dp))
            PrimaryAction("Ver próxima ação", onClick = openRide)
        }
        AppCard {
            Text("Avisos da operação", fontWeight = FontWeight.ExtraBold)
            Text("Mantenha localização, notificações e bateria liberadas durante o turno.", color = Muted)
        }
    }
}
