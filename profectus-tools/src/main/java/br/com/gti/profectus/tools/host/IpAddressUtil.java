/*package br.com.gti.profectus.tools.host;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IpAddressUtil {

    public static InetAddress getIpServer(boolean preferIpv4, boolean preferIPv6) {

        try {
            Enumeration<?> en = NetworkInterface.getNetworkInterfaces();

            while (en.hasMoreElements()) {
                NetworkInterface i = (NetworkInterface) en.nextElement();
                for (Enumeration<?> en2 = i.getInetAddresses(); en2.hasMoreElements();) {
                    InetAddress addr = (InetAddress) en2.nextElement();
                    if (!addr.isLoopbackAddress()) {
                        if (addr instanceof Inet4Address) {
                            if (preferIPv6) {
                                continue;
                            }
                            return addr;
                        }
                        if (addr instanceof Inet6Address) {
                            if (preferIpv4) {
                                continue;
                            }
                            return addr;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            log.error("IpAddressUtil.getIpServer: ", e);
        }

        return null;
    }

    public static String getIpClient(HttpServletRequest request) {

        String ipClient = "";
        try {

            ipClient = request.getHeader("x-forwarded-for");
            if (ipClient == null) {
                ipClient = request.getRemoteAddr();
            }

        } catch (Exception e) {
            log.error("IpAddressUtil.getIpClient: ", e);
        }

        return ipClient;

    }
}
*/