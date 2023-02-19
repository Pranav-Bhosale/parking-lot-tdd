import java.time.LocalDateTime

class ParkingService(
    private val parkingSpots: MutableList<SpotStatus>,
    private val tickets: MutableList<Ticket>,
    private val receipts: MutableList<Receipt>
) {
    fun park(): Ticket? {
        val spotNo = ParkingLot(parkingSpots).getAvailableSpot()
        return if (spotNo != null) {
            ParkingLot(parkingSpots).bookASpot(spotNo)
            TicketService(tickets).generateTicket(spotNo, LocalDateTime.now())
        } else {
            null// TODO:  error
        }
    }

    fun unPark(ticket: Ticket): Receipt {
        ParkingLot(parkingSpots).freeASpot(ticket.spotNo)
        return ReceiptService(receipts).generateReceipt(ticket, LocalDateTime.now())

    }

}