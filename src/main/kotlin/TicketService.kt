import java.time.LocalDateTime


class TicketService(private var tickets: MutableList<Ticket>) {
    fun generateTicket(spotNo: Int, entryDateAndTime: LocalDateTime): Ticket {
        val ticket = Ticket(spotNo, entryDateAndTime, calculateTicketNo())
        saveTicket(ticket)
        return ticket
    }

    private fun saveTicket(ticket: Ticket) {
        tickets.add(ticket)
    }

    private fun calculateTicketNo(): Int {
        return tickets.size + 1
    }
}