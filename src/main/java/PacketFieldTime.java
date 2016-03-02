
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldTime extends AbstractPacketField implements PacketField {

    private final DateTimeFormatter timeFmft = DateTimeFormatter.ofPattern("Hmm");

    public PacketFieldTime() {
        this.fieldQuotes = true;
    }

    public PacketFieldTime setValue(String s) {
        if (s.length() > 0) { this.value = LocalTime.parse(s, timeFmft); }
        else { this.value = null; }
        return this;
    }
}
