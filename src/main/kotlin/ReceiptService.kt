import java.time.LocalDateTime

class ReceiptService(private var receipts: MutableList<Receipt>) {
    fun generateReceipt(ticket: Ticket, exitDateAndTime: LocalDateTime): Receipt {
        val fee = FeeCalculator().calculate(ticket.entryDateTime, exitDateAndTime)
        val receipt = Receipt(ticket.ticketNo, ticket.spotNo, ticket.entryDateTime, exitDateAndTime, fee)
        saveReceipt(receipt)
        return receipt
    }

    private fun saveReceipt(receipt: Receipt) {
        receipts.add(receipt)
    }

}
