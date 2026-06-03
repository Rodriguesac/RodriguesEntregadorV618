package br.com.rodrigues.entregador.features.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.*
import br.com.rodrigues.entregador.core.ui.*

@Composable
fun ProfileScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        BigTitle("Perfil", "Conta, Pix, preferências e permissões")
        AppCard {
            Text("Diego", fontWeight = FontWeight.ExtraBold)
            Text("Entregador verificado • Rodrigues Açaí e Cia", color = Muted)
            Spacer(Modifier.height(12.dp))
            StatusPill("Disponível")
        }
        AppCard {
            Text("Preferências de operação", fontWeight = FontWeight.ExtraBold)
            Text("Maquininha: sim • Débito/crédito • Troco informado pelo entregador", color = Muted)
            Text("Essas regras devem entrar no despacho do gestor para evitar corrida incompatível.", color = Muted)
        }
        AppCard {
            Text("Permissões críticas", fontWeight = FontWeight.ExtraBold)
            Text("Notificações, localização, tela cheia urgente e bateria sem restrição.", color = Muted)
        }
        PrimaryAction("Destravar operação")
    }
}
