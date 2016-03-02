/**
 * Created by AGorbuntsov on 01.03.2016.
 */
public abstract class AbstractPacketField<T> implements PacketField{

    protected String name;
    protected T value;
    protected boolean fieldQuotes = false;

    public PacketField setName(String s) {
        this.name = s;
        return this;
    }

    public PacketField setValue(String s) {  return this; }

    public String toString(){
        if ( this.value==null ) { return null; }
        else if ( fieldQuotes ) {
            return String.valueOf(new StringBuilder().append("'").append(this.value).append("'"));
        }
        else { return String.valueOf(this.value); }
    }

    public String toStringSQL() {
        //System.out.print("val="); System.out.println(this.value);
        if ( this.value == null || this.name == null ) { return null; }
        else { return String.valueOf( new StringBuilder()
                .append(this.name)
                .append(" = ")
                .append(this.toString()));
        }
    }

    public boolean isNull() {
        return this.value==null;
    }
}
