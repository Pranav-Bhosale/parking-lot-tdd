class ParkingLot(private val parkingSpots: MutableList<SpotStatus>) {
    fun isSpotAvailable(): Boolean {
        for (parkingSpot in parkingSpots) {
            if (parkingSpot == SpotStatus.FREE) {
                return true
            }
        }
        return false
    }

}