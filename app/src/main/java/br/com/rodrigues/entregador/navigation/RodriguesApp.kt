package br.com.rodrigues.entregador.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import br.com.rodrigues.entregador.core.theme.Soft
import br.com.rodrigues.entregador.features.history.HistoryScreen
import br.com.rodrigues.entregador.features.home.HomeScreen
import br.com.rodrigues.entregador.features.map.MapScreen
import br.com.rodrigues.entregador.features.notifications.NotificationsScreen
import br.com.rodrigues.entregador.features.profile.ProfileScreen
import br.com.rodrigues.entregador.features.rides.RideScreen
import br.com.rodrigues.entregador.features.wallet.WalletScreen

enum class Tab(val label: String, val icon: ImageVector) {
    Home("Home", Icons.Outlined.Home),
    Ride("Corrida", Icons.Outlined.Route),
    Map("Mapa", Icons.Outlined.Map),
    Wallet("Carteira", Icons.Outlined.AccountBalanceWallet),
    History("Histórico", Icons.Outlined.History),
    Notifications("Avisos", Icons.Outlined.Notifications),
    Profile("Perfil", Icons.Outlined.Person)
}

@Composable
fun RodriguesApp() {
    var tab by remember { mutableStateOf(Tab.Home) }
    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface, tonalElevation = 8.dp) {
                Tab.entries.forEach { item ->
                    NavigationBarItem(
                        selected = tab == item,
                        onClick = { tab = item },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { padding ->
        Box(Modifier.fillMaxSize().background(Soft).padding(padding).padding(horizontal = 16.dp, vertical = 14.dp)) {
            when (tab) {
                Tab.Home -> HomeScreen(openRide = { tab = Tab.Ride }, openNotifications = { tab = Tab.Notifications })
                Tab.Ride -> RideScreen()
                Tab.Map -> MapScreen()
                Tab.Wallet -> WalletScreen()
                Tab.History -> HistoryScreen()
                Tab.Notifications -> NotificationsScreen()
                Tab.Profile -> ProfileScreen()
            }
        }
    }
}
