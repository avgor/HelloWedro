/**
 * Created by nastik on 27.02.16.
 */
public interface PacketField<T> {
    PacketField setName(String s);
    PacketField setValue(String s);
    String toString();
    String toStringSQL();
    boolean isNull();
}
