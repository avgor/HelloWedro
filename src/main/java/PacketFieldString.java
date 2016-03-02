/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldString extends AbstractPacketField implements PacketField {


    public  PacketFieldString() {
        this.fieldQuotes = true;
    }

    public PacketFieldString setValue(String s) {
        if (s.length() > 0) {
            //TODO Check string
            this.value = String.valueOf(s); }
        else { this.value = null; }
        return this;
    }
}
