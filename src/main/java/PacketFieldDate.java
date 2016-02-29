import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldDate implements PacketField {
    LocalDate value;
    String name;
    private final DateTimeFormatter dateFmft = DateTimeFormatter.BASIC_ISO_DATE;

    public PacketFieldDate PacketFieldDate() {
        return this;
    }

    public PacketFieldDate setName(String name) {
        this.name = name;
        return this;
    }

    public PacketFieldDate setValue(String s) {
        if (s.length() > 0) {
            this.value = LocalDate.parse(s, dateFmft);
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
            return "'"+String.valueOf(this.value)+"'";
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
