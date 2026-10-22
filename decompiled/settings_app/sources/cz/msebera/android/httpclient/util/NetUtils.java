package cz.msebera.android.httpclient.util;

import com.android.settingslib.accessibility.AccessibilityUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public final class NetUtils {
    public NetUtils() {
    }

    public static void formatAddress(StringBuilder r1, SocketAddress r2) {
        Args.notNull(r1, "Buffer");
        Args.notNull(r2, "Socket address");
        if ((r2 instanceof InetSocketAddress) == false) goto L8;
        InetSocketAddress r3 = (InetSocketAddress) r2;
        InetAddress r0 = r3.getAddress();
        Object r4 = r0;
        if (r0 == null) goto L7;
        r4 = r0.getHostAddress();
    L7:
        r1.append(r4).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r3.getPort());
        return;
    L8:
        r1.append(r2);
    }
}
