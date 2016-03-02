import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

/**
 * Created by AGorbuntsov on 29.02.2016.
 */
public class PacketFieldFactory {
    public static PacketField getField(Class fieldType, String name, String value) {

        PacketField newField;

        if (fieldType.equals(Integer.class)) {
            newField =  new PacketFieldInt();
        }
        else if (fieldType.equals(Long.class)) {
            newField =  new PacketFieldLong();
        }
        else if (fieldType.equals(LocalDate.class)) {
            newField =  new PacketFieldDate();
        }
        else if (fieldType.equals(LocalTime.class)) {
            newField =  new PacketFieldTime();
        }
        else if (fieldType.equals(String.class)) {
            newField =  new PacketFieldString();
        }
        else {
            return null;
        }

        newField.setName(name);
        newField.setValue(value);

        return newField;
    }
}
