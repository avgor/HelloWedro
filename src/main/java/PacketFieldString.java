/**
 * Created by nastik on 27.02.16.
 */
public class PacketFieldString implements PacketField {
    String value;
    String name;

    public PacketFieldString PacketFieldString() {
        return this;
    }

    public PacketFieldString setName(String name) {
        this.name = name;
        return this;
    }

    public PacketFieldString setValue(String s) {
        if (s.length() > 0) {
            this.value = String.valueOf(s);
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
