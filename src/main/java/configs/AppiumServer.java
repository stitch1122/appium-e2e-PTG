package configs;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class AppiumServer {

    private static AppiumDriverLocalService server;

    public static void startServer(){
        if(isPortAvailable(4723)){
            System.out.println("Server started from here!");
        } else {
            System.out.println("Server already running!");
            getServerInstance().stop();
        }
        getServerInstance().start();
        getServerInstance().clearOutPutStreams();
    }

    static AppiumDriverLocalService getServerInstance() {
        if (server == null) {
            setServerInstance();
        }
        return server;
    }

    static void setServerInstance() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
        server = AppiumDriverLocalService.buildService(builder);
    }

    public static boolean isPortAvailable(int port) {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReuseAddress(false);
            serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), port), 1);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    static void stopServer() {
        getServerInstance().stop();
        System.out.println("Appium server stopped!");
    }

    public static void main(String[] args) throws InterruptedException {
        AppiumServer.startServer();
        Thread.sleep(2000);
        AppiumServer.stopServer();
    }
}