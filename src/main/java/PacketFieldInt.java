/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldInt implements PacketField {
    Integer value;

    public PacketFieldInt PacketFieldInt() {
        return this;
    }

    public PacketFieldInt setValue(String s) {
        if (s.length() > 0) {
            this.value = Integer.valueOf(s);
        }
        return this;
    }
    @Override
    public String toString(){
        return String.valueOf(this.value);
    }
}
