import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(private val currentDate: LocalDateTime) {

    constructor(currentDate: LocalDate): this(currentDate.atStartOfDay())

    private val ONE_GIGASECOND: Long = 1000000000

    val date: LocalDateTime = this.currentDate.plusSeconds(ONE_GIGASECOND)
}
