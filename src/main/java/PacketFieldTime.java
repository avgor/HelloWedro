
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldTime implements PacketField {
    LocalTime value;
    private final DateTimeFormatter timeFmft = DateTimeFormatter.ofPattern("Hmm");

    public PacketFieldTime PacketFieldInt() {
        return this;
    }

    public PacketFieldTime setValue(String s) {
        if (s.length() > 0) {
            this.value = LocalTime.parse(s, timeFmft);
        }
        return this;
    }
    @Override
    public String toString(){
        return String.valueOf(this.value);
    }
}
