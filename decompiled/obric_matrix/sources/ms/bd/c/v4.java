package ms.bd.c;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f22527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f22528b;

    public static String a() {
    L27:
        e = move-exception;
        String r0 = "get IpAddress fail:" + e.toString();
        return "";
    L4:
        if (f22527a == true) goto L24;
        if (e4.i() != 1) goto L24;
        f22527a = true;     // Catch: SocketException -> L27
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L27
    L9:
        if (r1.hasMoreElements() == false) goto L24;
        NetworkInterface r2 = r1.nextElement();     // Catch: SocketException -> L27
        Enumeration<InetAddress> r3 = r2.getInetAddresses();     // Catch: SocketException -> L27
    L12:
        if (r3.hasMoreElements() == false) goto L9;
        InetAddress r4 = r3.nextElement();     // Catch: SocketException -> L27
        String r5 = r2.getName();     // Catch: SocketException -> L27
        if (TextUtils.isEmpty(r5) == true) goto L12;
        if (r4.isLoopbackAddress() == true) goto L12;
        if ((r4 instanceof Inet4Address) == false) goto L12;
        if (r5.startsWith("rmnet") == false) goto L12;
        f22528b = r2.getName();     // Catch: SocketException -> L27
        return r2.getName();
    L24:
        if (TextUtils.isEmpty(f22528b) == false) goto L26;
        return "";
    L26:
        return f22528b;
    }
}
