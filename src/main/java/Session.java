import java.time.LocalDateTime;

/**
 * Created by AGorbuntsov on 29.02.2016.
 */


public class Session {

    private SessionState sessionState;
    private String sessionId;
    private long deviceID;
    //private LocalDateTime Activity;

    public Session() {
        this.sessionState = SessionState.INIT;
        this.sessionId = "abcdef1234567890";
    }

    public SessionState getSessionState() {
        return sessionState;
    }
    public void setSessionState(SessionState sessionState) {
        this.sessionState = sessionState;
    }

    public long getDeviceID() {
        return deviceID;
    }
    public void setDeviceID(long deviceID) {
        this.deviceID = deviceID;
    }
}
