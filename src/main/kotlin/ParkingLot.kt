class ParkingLot(private val parkingSpots: MutableList<SpotStatus>) {
    fun getAvailableSpot(): Int? {
        for (iterator in 0 until parkingSpots.size) {
            if (parkingSpots[iterator] == SpotStatus.FREE) {
                return iterator + 1
            }
        }
        return null
    }

    fun bookASpot(spotNo: Int) {
        if(spotNo>parkingSpots.size)
        {
            throw CustomException("Spot does not exist")
        }
        parkingSpots[spotNo - 1] = SpotStatus.BOOKED
    }

    fun freeASpot(spotNo: Int) {
        if(spotNo>parkingSpots.size)
        {
          throw CustomException("Spot does not exist")
        }
        parkingSpots[spotNo - 1] = SpotStatus.FREE
    }

}