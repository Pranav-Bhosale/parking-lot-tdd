import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ParkingLotTest {
    @Test
    fun `should return spot id of available spot in parkingLot`() {
        val parkingSpots = MutableList(PARKING_LOT_SIZE) { SpotStatus.FREE }

        val spotNo = ParkingLot(parkingSpots).getAvailableSpot()

        assertEquals(1, spotNo)
    }

    @Test
    fun `should return null if there is no availability of spot in parkingLot`() {
        val parkingSpots = MutableList(PARKING_LOT_SIZE) { SpotStatus.BOOKED }

        val spotNo = ParkingLot(parkingSpots).getAvailableSpot()

        assertEquals(null, spotNo)
    }

    @Test
    fun `should book a spot`() {
        val parkingSpots = MutableList(PARKING_LOT_SIZE) { SpotStatus.FREE }

        ParkingLot(parkingSpots).bookASpot(1)

        assertEquals(parkingSpots[0], SpotStatus.BOOKED)
    }

    @Test
    fun `should throw exception while booking if the spot does not exist`()
    {
        val parkingSpots = MutableList(PARKING_LOT_SIZE) { SpotStatus.FREE }

        assertThrows<CustomException> {  ParkingLot(parkingSpots).bookASpot(101)}

    }

    @Test
    fun `should throw exception while free the spot that does not exist`()
    {
        val parkingSpots = MutableList(PARKING_LOT_SIZE) { SpotStatus.FREE }

        assertThrows<CustomException> {  ParkingLot(parkingSpots).freeASpot(101)}

    }

    @Test
    fun `should free spot`() {
        val parkingSpots = MutableList(PARKING_LOT_SIZE) { SpotStatus.BOOKED }

        ParkingLot(parkingSpots).freeASpot(1)

        assertEquals(SpotStatus.FREE,parkingSpots[0] )
    }
}