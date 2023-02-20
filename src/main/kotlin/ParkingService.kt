import java.time.LocalDateTime

class ParkingService(
    private val parkingSpots: MutableList<SpotStatus>,
    private val tickets: MutableList<Ticket>,
    private val receipts: MutableList<Receipt>
) {
    fun park(): Ticket? {
        val spotNo = ParkingLot(parkingSpots).getAvailableSpot()
        return if (spotNo != null) {
            try {
                ParkingLot(parkingSpots).bookASpot(spotNo)
            } catch (e: CustomException) {
                println(e)
            }
            TicketService(tickets).generateTicket(spotNo, LocalDateTime.now())
        } else {
            null
        }
    }

    fun unPark(ticket: Ticket): Receipt {
        try {
            ParkingLot(parkingSpots).freeASpot(ticket.spotNo)
        } catch (e: CustomException) {
            println(e)
        }
        return ReceiptService(receipts).generateReceipt(ticket, LocalDateTime.now())

    }

}