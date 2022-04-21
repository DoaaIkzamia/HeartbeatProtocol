package src.protocol.server.protocols.heartbeat;

import java.util.Date;

//import protocol.server.protocols.heartbeat.HeartbeatProtocolManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerStart implements HeartbeatListener {

    private static final Logger LOGGER = Logger.getLogger(ServerStart.class.getName());

    public static void main(String[] args) {
        HeartbeatProtocolManager heartbeatProtocolManager = new HeartbeatProtocolManager(new ServerStart());
        heartbeatProtocolManager.addHost("Node - A", 4001, new Date().getTime(), "Node - B");
        heartbeatProtocolManager.addHost("Node - B", 4002, new Date().getTime(), "Node - A");
    }

    @Override
    public void onHeartbeat(HeartbeatEvent event) {
        LOGGER.log(Level.INFO, () -> "Received heartbeat from " + event.getSource() + " to " + event.getdestanation() + " at " + event.getBeatTimeStamp());
    }

    @Override
    public void onDeath(HeartbeatEvent event) {
        LOGGER.log(Level.INFO, () -> event.getSource() + " died after " + event.getTimeFromPreviousBeat() + " at " + event.getBeatTimeStamp());
    }

    @Override
    public void onLossCommunication(HeartbeatEvent event) {
        LOGGER.log(Level.INFO, () -> "Communication lost of " + event.getSource() + " in " + event.getTimeFromPreviousBeat() + " at " + event.getBeatTimeStamp());
    }

    @Override
    public void onReacquiredCommunication(HeartbeatEvent event) {
        LOGGER.log(Level.INFO, () -> "Communication reacquired of " + event.getSource() + " in " + event.getTimeFromPreviousBeat() + " at " + event.getBeatTimeStamp());
    }

    @Override
    public void onAcquiredCommunication(HeartbeatEvent event) {
        LOGGER.log(Level.INFO, () -> event.getSource() +" With port "+ event + " connected at " + event.getBeatTimeStamp());
    }
}
