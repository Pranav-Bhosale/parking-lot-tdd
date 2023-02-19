
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TicketServiceTest {
    @Test
    fun `should generate a ticket`() {
        val tickets = mutableListOf<Ticket>()
        val entryDateAndTime =  LocalDateTime.now()

        val ticket = TicketService(tickets).generateTicket(99, entryDateAndTime)

        assertEquals(entryDateAndTime, ticket.entryDateTime)
        assertEquals(1, ticket.ticketNo)
        assertEquals(99, ticket.spotNo)
    }

    @Test
    fun `should save a ticket`() {
        val tickets = mutableListOf<Ticket>()
        val entryDateAndTime =  LocalDateTime.now()

        TicketService(tickets).generateTicket(99, entryDateAndTime)

        assertEquals(1, tickets.size)
    }
}