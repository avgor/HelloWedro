import java.time.LocalDate;

/**
 * Created by nastik on 27.02.16.
 */
public class TestPacket {
    public static void main(String[] args) {
        PacketFieldLong devId = new PacketFieldLong();
        System.out.println(devId.toString());
        devId.setValue("123456789012345");
        System.out.println(devId.toString());

        PacketFieldInt devMode = new PacketFieldInt();
        System.out.println(devMode.toString());
        devMode.setValue("1");
        System.out.println(devMode.toString());

        PacketFieldDate devDate = new PacketFieldDate();
        System.out.println(devDate.toString());
        devDate.setValue("20160228");
        System.out.println(devDate.toString());

        PacketFieldTime devTime = new PacketFieldTime();
        System.out.println(devTime.toString());
        devTime.setValue("2359");
        System.out.println(devTime.toString());
        devTime.setValue("000");
        System.out.println(devTime.toString());

        System.out.println("-------------");

        PacketField devId2 = PacketFieldFactory.getField(Long.class, "deviceID", "123456789012345");
        System.out.println(devId2.toString());
        System.out.println(devId2.toStringSQL());

        PacketField devDate2 = PacketFieldFactory.getField(LocalDate.class, "DEVICE_DATE_FIELD", "20160229");
        System.out.println(devDate2.toString());
        System.out.println(devDate2.toStringSQL());

        devDate2 = PacketFieldFactory.getField(LocalDate.class, "DEVICE_DATE_FIELD", "");
        System.out.println(devDate2.toString());
        System.out.println(devDate2.toStringSQL());

        System.out.println("-------------");

        Packet packet;
        try {
            packet = PacketFactory.getPacket("$A,123456789012345,20160229,1631,72,0.1-alpha,0");
            System.out.println(packet.getPacketType());
            System.out.println(packet.getSQLScriptUpdate());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            packet = PacketFactory.getPacket("$A,9999999,,,,,");
            System.out.println(packet.getPacketType());
            System.out.println(packet.getSQLScriptUpdate());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            packet = PacketFactory.getPacket("$A,123123123,,,1,,");
            System.out.println(packet.getPacketType());
            System.out.println(packet.getSQLScriptUpdate());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            packet = PacketFactory.getPacket("$A,,,,1,,");
            System.out.println(packet.getPacketType());
            System.out.println(packet.getSQLScriptUpdate());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //Class<Integer>
         //       c= Integer::valueOf;
        //c.

    }
}
