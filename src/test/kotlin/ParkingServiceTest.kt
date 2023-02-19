
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

class ParkingServiceTest {
    @Test
    fun `should park a vehicle`() {
        val parkingSpots = MutableList(100) { SpotStatus.FREE }
        val tickets = mutableListOf<Ticket>()
        val receipts = mutableListOf<Receipt>()

        val ticket = ParkingService(parkingSpots, tickets, receipts).park()

        assertEquals(SpotStatus.BOOKED, parkingSpots[0])
        assertEquals(1, tickets.size)
    }

    @Test
    fun `should unPark a vehicle`() {
        val parkingSpots = MutableList(100) { SpotStatus.BOOKED }
        val tickets = mutableListOf<Ticket>()
        val receipts = mutableListOf<Receipt>()
        val ticket = Ticket(1,  LocalDateTime.of(2023, 2, 19, 20, 51), 1)

        val receipt = ParkingService(parkingSpots, tickets, receipts).unPark(ticket)

        assertEquals(20, receipt.fee)
    }

}