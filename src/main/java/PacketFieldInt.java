/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldInt extends AbstractPacketField implements PacketField {

    public PacketFieldInt setValue(String s) {
        if (s.length() > 0) { this.value = Integer.valueOf(s); }
        else { this.value = null; }
        return this;
    }
}
