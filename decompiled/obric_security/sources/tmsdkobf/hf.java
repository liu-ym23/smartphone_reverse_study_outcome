package tmsdkobf;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class hf {
    public static boolean a() {
        Enumeration<NetworkInterface> r0 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L18
        if (r0 == null) goto L16;
        Iterator r1 = Collections.list(r0).iterator();     // Catch: Throwable -> L18
    L6:
        if (r1.hasNext() == false) goto L31;
        NetworkInterface r2 = (NetworkInterface) r1.next();     // Catch: Throwable -> L18
        if (r2.isUp() == false) goto L6;
        if (r2.getInterfaceAddresses().size() == 0) goto L6;
        if (r2.getName().matches("tun\\d+") == false) goto L6;
        return true;
    L31:
        return false;
    L16:
        return false;
    L30:
        return false;
    }
}
