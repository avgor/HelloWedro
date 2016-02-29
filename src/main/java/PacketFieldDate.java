import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldDate implements PacketField {
    LocalDate value;
    private final DateTimeFormatter dateFmft = DateTimeFormatter.BASIC_ISO_DATE;

    public PacketFieldDate PacketFieldInt() {
        return this;
    }

    public PacketFieldDate setValue(String s) {
        if (s.length() > 0) {
            this.value = LocalDate.parse(s, dateFmft);
        }
        return this;
    }
    @Override
    public String toString(){
        return String.valueOf(this.value);
    }
}
