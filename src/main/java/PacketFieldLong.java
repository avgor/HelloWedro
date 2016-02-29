/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldLong implements PacketField {
    Long value;
    String name;


    public PacketFieldLong PacketFieldLong() {
        return this;
    }

    public PacketFieldLong setName(String name) {
        this.name = name;
        return this;
    }

    public PacketFieldLong setValue(String s) {
        if (s.length() > 0) {
            this.value = Long.valueOf(s);
        }
        else {
            this.value = null;
        }
        return this;
    }

    @Override
    public String toString(){
        return String.valueOf(this.value);
    }

    public String toStringSQL(){
        if ( this.value == null || this.name == null ) { return null; }
        else {
            return this.name + " = " + String.valueOf(this.value);
        }
    }

    public boolean isNull() {
        return this.value == null;
    }
}
