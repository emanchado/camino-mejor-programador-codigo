package server;

public interface App {
    void start(int port);

    void stop() throws Exception;
}