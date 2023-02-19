import java.util.*

class TicketService(private var tickets: MutableList<Ticket>) {
    fun generateTicket(spotNo: Int, entryDateAndTime: Date): Ticket {
        return Ticket(spotNo,entryDateAndTime,calculateTicketNo())
    }

    private fun calculateTicketNo(): Int {
      return tickets.size+1
    }
}