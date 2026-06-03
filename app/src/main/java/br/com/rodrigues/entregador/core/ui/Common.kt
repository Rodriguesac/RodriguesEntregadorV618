package br.com.rodrigues.entregador.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.*

@Composable
fun AppCard(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(24.dp), spotColor = Color(0x22000000))
            .background(Color.White, RoundedCornerShape(24.dp))
            .padding(18.dp),
        content = content
    )
}

@Composable
fun BigTitle(text: String, sub: String? = null) {
    Text(text, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold, color = Dark)
    if (sub != null) Text(sub, color = Muted, modifier = Modifier.padding(top = 4.dp))
}

@Composable
fun PrimaryAction(text: String, danger: Boolean = false, enabled: Boolean = true, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        shape = RoundedCornerShape(18.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if (danger) Danger else Green)
    ) { Text(text, fontWeight = FontWeight.Bold) }
}

@Composable
fun Metric(label: String, value: String) {
    Column(Modifier.padding(vertical = 4.dp)) {
        Text(value, fontWeight = FontWeight.ExtraBold, color = Dark)
        Text(label, color = Muted, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun StatusPill(text: String, color: Color = Green) {
    Surface(color = color.copy(alpha = .12f), shape = RoundedCornerShape(50)) {
        Text(text, color = color, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp))
    }
}
