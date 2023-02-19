import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class TicketServiceTest {
    @Test
    fun `should generate a ticket`() {
        val tickets = mutableListOf<Ticket>()
        val entryDateAndTime = Date()

        val ticket = TicketService(tickets).generateTicket(99, entryDateAndTime)

        assertEquals(entryDateAndTime, ticket.entryDateTime)
        assertEquals(1, ticket.ticketNo)
        assertEquals(99, ticket.spotNo)
    }
}