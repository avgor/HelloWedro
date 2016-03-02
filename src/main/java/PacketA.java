import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by AGorbuntsov on 29.02.2016.
 */
public class PacketA extends AbstractPacket {
    final private String packetType = "A";
    //0,  1,  2,    3,    4,           5,       6
    //$A, ID, date, time, workingTime, version, checksum
    public static final String ID_FIELD = "DeviceID";
    public static final String DEVICE_DATE_FIELD = "deviceDate";    //Системная дата утр-ва
    public static final String DEVICE_TIME_FIELD = "deviceTime";    //Системное время утр-ва
    public static final String UPDATE_TIME_TIMESTAMP_FIELD = "timeUpdatedTimestamp";    //метка времени получения системного времени утройства
    public static final String UPDATE_DATA_TIMESTAMP_FIELD = "updatedTimestamp";    //метка времени получения пакета данных
    public static final String WORKING_TIME_FIELD = "workingTime";  // Время работы системы (uptime)
    public static final String VERSION_FIELD = "version";   // Версия прошивки

//    private PacketFieldLong id;
//    private PacketFieldDate devDate;
//    private PacketFieldTime devTime;
//    private PacketFieldInt devUptime;
//    private PacketFieldString devVersion;

    private PacketField id;
    private PacketField devDate;
    private PacketField devTime;
    private PacketField devUptime;
    private PacketField devVersion;


    public PacketA(String msg) throws PacketException {
        //0, 1, 2,   3,   4,          5,      6
        //$A,ID,date,time,workingTime,version,checksum
        String[] parts = msg.split(",", -1);
        if (parts.length == 7 && checkControlSum(msg)) {
//            this.id = new PacketFieldLong().setName(ID_FIELD).setValue(parts[1]);
//            this.devDate = new PacketFieldDate().setName(DEVICE_DATE_FIELD).setValue(parts[2]);
//            this.devTime = new PacketFieldTime().setName(DEVICE_TIME_FIELD).setValue(parts[3]);
//            this.devUptime = new PacketFieldInt().setName(WORKING_TIME_FIELD).setValue(parts[4]);
//            this.devVersion = new PacketFieldString().setName(VERSION_FIELD).setValue(parts[5]);
            this.id      = PacketFieldFactory.getField( Long.class      , ID_FIELD,             parts[1] );
            this.devDate = PacketFieldFactory.getField( LocalDate.class , DEVICE_DATE_FIELD,    parts[2] );
            this.devTime = PacketFieldFactory.getField( LocalTime.class , DEVICE_TIME_FIELD,    parts[3] );
            this.devTime = PacketFieldFactory.getField( Integer.class   , WORKING_TIME_FIELD,   parts[4] );
            this.devTime = PacketFieldFactory.getField( String.class    , VERSION_FIELD,        parts[5] );
        }
        else {
            throw new PacketException("Битый пакет 'А'-типа");
        }

    }

    @Override
    public String getPacketType() {
        return this.packetType;
    }

    @Override
    public String getSQLScriptUpdate() {

        if ( this.id == null || this.id.isNull() ) {
            return "";
        }

        PacketField fieldList[] = { this.devDate, this.devTime, this.devUptime, this.devVersion };

        StringBuilder queryFields = new StringBuilder();

        boolean isFirst = true;
        for (PacketField pf: fieldList ) {
            if ( pf==null /*|| pf.isNull()*/ ) { continue; }
            String s = pf.toStringSQL();
            if ( s != null ) {
                if ( isFirst ) {
                    queryFields.append("SET ");
                    isFirst=false;
                }
                else { queryFields.append("\n,"); }

                queryFields.append(s);
            }
        }

        if ( queryFields.length() > 0 ) {
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Device\n")
                    .append(queryFields)
                    .append("\nWHERE ")
                    .append(this.id.toStringSQL())
                    ;
            return String.valueOf(query);
        }
        else { return ""; }
    }


}
