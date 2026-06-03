package br.com.rodrigues.entregador.features.map

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.*
import br.com.rodrigues.entregador.core.ui.*

@Composable
fun MapScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        BigTitle("Mapa", "Localização do motoboy e rota ativa")
        AppCard {
            StatusPill("((•)) Disponível")
            Spacer(Modifier.height(14.dp))
            Text("╭────────────────────╮", color = Muted)
            Text("│      ● Motoboy      │", color = Green, fontWeight = FontWeight.Bold)
            Text("│   mapa nativo aqui  │", color = Muted)
            Text("╰────────────────────╯", color = Muted)
            Spacer(Modifier.height(12.dp))
            Text("Pronto para substituir por Google Maps/MapLibre nativo sem alterar as telas.", color = Muted)
        }
        PrimaryAction("Abrir navegação")
    }
}
