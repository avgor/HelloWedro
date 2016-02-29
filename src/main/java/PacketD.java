/**
 * Created by AGorbuntsov on 29.02.2016.
 */

public class PacketD extends AbstractPacket {
    final private String packetType = "D";
    int mode;

    public PacketD(String msg) {
        //System.out.println("Constructor D");
    }

    @Override
    public String getPacketType() {
        return this.packetType;
    }
}
