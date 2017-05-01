package br.com.gti.profectus.tools.host;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * HostNameHelper.
 */
public final class HostNameHelper {

    private static final HostNameHelper INSTANCE = new HostNameHelper();

    /**
     * HostNameHelper.
     */
    public static HostNameHelper getInstance() {
        return INSTANCE;
    }

    private HostNameHelper() {
    }

    private String hostname;
    private String sync = "";;

    /**
     * getHostname.
     * @return
     */
    public String getHostname() {
        if (hostname == null) {
            synchronized (sync) {
                if (hostname == null) {
                    hostname = getName();
                }
            }
        }
        return hostname;
    }

    private String getName() {
        String name = null;
        try {
            name = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        String server = System.getProperty("server.name");
        if (server != null) {
            name = server + "@" + name;
        }
        String port = System.getProperty("server.port");
        if (port != null) {
            name = name + ":" + port;
        }
        if (name == null) {
            name = "unknow";
        }
        return name;
    }
}
