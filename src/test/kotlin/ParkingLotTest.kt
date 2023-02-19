import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ParkingLotTest
{
    @Test
    fun `it should return true if there is availability of spot in parkingLot`(){
        val parkingSpots= mutableListOf(SpotStatus.FREE)

        val isSpotAvailable= ParkingLot(parkingSpots).isSpotAvailable()

        assertEquals(true,isSpotAvailable)
    }

    @Test
    fun `it should return false if there is no availability of spot in parkingLot`(){
        val parkingSpots= mutableListOf(SpotStatus.BOOKED)

        val isSpotAvailable= ParkingLot(parkingSpots).isSpotAvailable()

        assertEquals(false,isSpotAvailable)
    }
}