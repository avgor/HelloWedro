
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldTime implements PacketField {
    LocalTime value;
    String name;
    private final DateTimeFormatter timeFmft = DateTimeFormatter.ofPattern("Hmm");

    public PacketFieldTime PacketFieldTime() {
        return this;
    }

    public PacketFieldTime setName(String name) {
        this.name = name;
        return this;
    }

    public PacketFieldTime setValue(String s) {
        if (s.length() > 0) {
            this.value = LocalTime.parse(s, timeFmft);
        }
        else {
            this.value = null;
        }
        return this;
    }

    @Override
    public String toString(){
        if (isNull()) { return null; }
        else {
            return "'"+ String.valueOf(this.value) + "'";
        }
    }
    public String toStringSQL(){
        if ( this.value == null || this.name == null ) { return null; }
        else {
            return this.name + " = '" + String.valueOf(this.value) + "'";
        }
    }

    public boolean isNull() {
        return this.value == null;
    }
}
