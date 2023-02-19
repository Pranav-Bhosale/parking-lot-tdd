import java.time.LocalDateTime

data class Receipt(
    val receiptNo: Int,
    val spotNo: Int,
    val entryDateTime: LocalDateTime,
    val exitDateAndTime: LocalDateTime,
    val fee: Long
)
