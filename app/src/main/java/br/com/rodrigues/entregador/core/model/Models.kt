package br.com.rodrigues.entregador.core.model

enum class CourierStatus { INDISPONIVEL, DISPONIVEL, RESTRICAO, EM_CORRIDA }
enum class RideStage { OFERTADA, ACEITA, INDO_COLETA, NA_COLETA, AGUARDANDO_SAIDA_GESTOR, LIBERADA_PARA_ENTREGA, EM_ENTREGA, ENTREGADOR_NO_LOCAL, OCORRENCIA, FINALIZADA, CANCELADA }
enum class PaymentMode { ONLINE, PIX, DINHEIRO, CARTAO_MAQUININHA, NAO_INFORMADO }

data class PaymentInfo(
    val status: String,
    val mode: PaymentMode,
    val amountToCollect: Double = 0.0,
    val needsMachine: Boolean = false,
    val changeFor: Double? = null
)

data class Ride(
    val id: String,
    val shortCode: String,
    val store: String,
    val neighborhood: String,
    val addressHint: String,
    val distanceKm: Double,
    val etaMin: Int,
    val deliveryFee: Double,
    val stage: RideStage,
    val payment: PaymentInfo,
    val readyCount: Int = 1,
    val totalOrders: Int = 1
)

data class NotificationItem(val title: String, val body: String, val unread: Boolean = false)
