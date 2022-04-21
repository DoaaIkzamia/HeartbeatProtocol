package src.protocol.server.protocols.heartbeat;

public class HeartbeatEvent  {

    private String source;
    private int timeElapsedPreviousBeat;
    private long timeStamp;
    private String destanation;
   

    HeartbeatEvent(String source, int timeElapsedPreviousBeat, long timeStamp, String destination) {
        this.source = source;
        this.timeElapsedPreviousBeat = timeElapsedPreviousBeat;
        this.timeStamp = timeStamp;
        this.destanation = destanation;
        
    }

    public String getdestanation() {
    	return destanation;
    }

    public String getSource() {
        return source;
    }

    public int getTimeFromPreviousBeat() {
        return timeElapsedPreviousBeat;
    }

    public long getBeatTimeStamp() {
        return timeStamp;
    }
}
