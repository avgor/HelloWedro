import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldDate extends AbstractPacketField implements PacketField {

    private final DateTimeFormatter dateFmft = DateTimeFormatter.BASIC_ISO_DATE;

    public PacketFieldDate() {
        this.fieldQuotes = true;
    }

    public PacketFieldDate setValue(String s) {
        if (s.length() > 0) { this.value = LocalDate.parse(s, dateFmft); }
        else { this.value = null; }
        return this;
    }
}
