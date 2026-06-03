package br.com.rodrigues.entregador.data

import br.com.rodrigues.entregador.core.model.*

object DemoData {
    val currentRide = Ride(
        id = "rota_621",
        shortCode = "R621",
        store = "Rodrigues Açaí e Cia",
        neighborhood = "Jardim Paulista",
        addressHint = "Entrega liberada após saída do gestor",
        distanceKm = 3.4,
        etaMin = 14,
        deliveryFee = 7.00,
        stage = RideStage.INDO_COLETA,
        payment = PaymentInfo(
            status = "Receber na entrega",
            mode = PaymentMode.DINHEIRO,
            amountToCollect = 42.90,
            changeFor = 50.00
        ),
        readyCount = 1,
        totalOrders = 2
    )

    val history = listOf(
        currentRide.copy(shortCode = "R620", stage = RideStage.FINALIZADA, deliveryFee = 8.0, neighborhood = "Centro"),
        currentRide.copy(shortCode = "R619", stage = RideStage.CANCELADA, deliveryFee = 0.0, neighborhood = "Aero Rancho"),
        currentRide.copy(shortCode = "R618", stage = RideStage.OCORRENCIA, deliveryFee = 6.5, neighborhood = "Tiradentes")
    )

    val notifications = listOf(
        NotificationItem("Nova rota disponível", "Confira valor, distância, pagamento e aceite somente se puder realizar.", true),
        NotificationItem("Repasse atualizado", "Seu acerto do dia foi recalculado com base nos pagamentos."),
        NotificationItem("Aviso do gestor", "Mantenha o app aberto durante a operação para receber corridas." )
    )
}
