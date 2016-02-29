/**
 * Created by AGorbuntsov on 29.02.2016.
 */
public class PacketFactory {
    public static Packet getPacket(String msg) throws PacketException {

        if (msg.startsWith("$A,")) {
            return new PacketA(msg);
        }
        else if (msg.startsWith("$D,")) {
            return new PacketD(msg);
        }

        throw new PacketException("Неизвестный тип пакета");

    }
}
