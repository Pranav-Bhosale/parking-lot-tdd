import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class FeeCalculator {
    fun calculate(entryDateTime: LocalDateTime, exitDateAndTime: LocalDateTime): Long {
        return (entryDateTime.until(exitDateAndTime, ChronoUnit.HOURS)) * FEES_PER_HOUR
    }

}
