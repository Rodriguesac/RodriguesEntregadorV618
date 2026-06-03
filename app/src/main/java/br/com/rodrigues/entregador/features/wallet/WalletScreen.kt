package br.com.rodrigues.entregador.features.wallet

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.*
import br.com.rodrigues.entregador.core.ui.*

@Composable
fun WalletScreen() {
    var visible by remember { mutableStateOf(true) }
    val hide = if (visible) "R$ 118,40" else "••••••"
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        BigTitle("Carteira", "Acerto financeiro do entregador")
        AppCard {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column { Text("Próximo repasse", color = Muted); Text(hide, fontWeight = FontWeight.ExtraBold) }
                StatusPill(if (visible) "Ocultar" else "Mostrar")
            }
            Spacer(Modifier.height(12.dp))
            PrimaryAction(if (visible) "Ocultar valores" else "Mostrar valores", onClick = { visible = !visible })
        }
        AppCard {
            Text("Resumo do dia", fontWeight = FontWeight.ExtraBold)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Metric("Dinheiro recebido", if (visible) "R$ 94,00" else "••••")
                Metric("Motoboy", if (visible) "R$ 42,50" else "••••")
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Metric("Taxas maquininha", if (visible) "R$ 3,20" else "••••")
                Metric("Repassar loja", if (visible) "R$ 118,40" else "••••")
            }
        }
    }
}
