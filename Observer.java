package src.protocol.server.protocols.heartbeat;

public interface Observer<T, D> {

    void update(T t, D d);
}
