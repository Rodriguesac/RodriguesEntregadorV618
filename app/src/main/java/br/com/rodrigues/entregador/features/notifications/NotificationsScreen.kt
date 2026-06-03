package br.com.rodrigues.entregador.features.notifications

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.Muted
import br.com.rodrigues.entregador.core.ui.*
import br.com.rodrigues.entregador.data.DemoData

@Composable
fun NotificationsScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        BigTitle("Notificações", "Corridas, avisos e operação")
        DemoData.notifications.forEach { item ->
            AppCard {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.weight(1f)) {
                        Text(item.title, fontWeight = FontWeight.ExtraBold)
                        Text(item.body, color = Muted)
                    }
                    if (item.unread) StatusPill("Novo")
                }
            }
        }
    }
}
