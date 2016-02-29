/**
 * Created by AGorbuntsov on 29.02.2016.
 */
public abstract class AbstractPacket implements Packet {

    final private String packetType = "";

    public boolean checkControlSum(String msg) {
        //todo
        if (msg != null && msg.length() > 3) {
            return true;
        }
        return false;
    }

    public String getSQLScriptUpdate() {
        return "";
    }

    public String getPacketType() {
        return this.packetType;
    }
}