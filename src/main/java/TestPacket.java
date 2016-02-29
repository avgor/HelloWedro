/**
 * Created by nastik on 27.02.16.
 */
public class TestPacket {
    public static void main(String[] args) {
        PacketFieldLong devId = new PacketFieldLong().setValue("123456789012345");
        System.out.println(devId.toString());

        PacketFieldInt devMode = new PacketFieldInt().setValue("1");
        System.out.println(devMode.toString());

        PacketFieldDate devDate = new PacketFieldDate().setValue("20160228");
        System.out.println(devDate.toString());

        PacketFieldTime devTime = new PacketFieldTime().setValue("000");
        System.out.println(devTime.toString());
        devTime.setValue("2359");
        System.out.println(devTime.toString());

    }
}
