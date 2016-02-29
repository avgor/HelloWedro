/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldLong implements PacketField {
    Long value;

    public PacketFieldLong PacketFieldInt() {
        return this;
    }

    public PacketFieldLong setValue(String s) {
        if (s.length() > 0) {
            this.value = Long.valueOf(s);
        }
        return this;
    }
    @Override
    public String toString(){
        return String.valueOf(this.value);
    }
}
