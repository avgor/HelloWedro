/**
 * Created by AGorbuntsov on 29.02.2016.
 */
public interface Packet {
    boolean checkControlSum(String msg);
    String getSQLScriptUpdate();
    String getPacketType();
}
