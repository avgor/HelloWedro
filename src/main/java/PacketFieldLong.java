/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldLong extends AbstractPacketField implements PacketField {

    public PacketFieldLong setValue(String s) {
        if (s.length() > 0) { this.value = Long.valueOf(s); }
        else { this.value = null; }
        return this;
    }
}
