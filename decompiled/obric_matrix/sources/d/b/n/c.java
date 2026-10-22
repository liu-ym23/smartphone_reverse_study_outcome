package d.b.n;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class c {
    static {
    }

    public static String a(Context r7) {
        if (Build.VERSION.SDK_INT >= 23) goto L38;
        return "NOT_SUPPORTED";
    L38:
        ConnectivityManager r8 = (ConnectivityManager) r7.getSystemService("connectivity");     // Catch: Exception -> L35
        LinkProperties r9 = r8.getLinkProperties(r8.getActiveNetwork());     // Catch: Exception -> L35
        if (r9 != null) goto L10;
        return "EmptyLp";
    L10:
        Class<?> r0 = Class.forName("android.net.LinkProperties");     // Catch: Exception -> L35
        boolean r2 = false;
        Method r1 = r0.getDeclaredMethod("hasIpv4Address", new Class[0]);     // Catch: Exception -> L35
        Method r3 = r0.getDeclaredMethod("hasIpv4DefaultRoute", new Class[0]);     // Catch: Exception -> L35
        Method r4 = r0.getDeclaredMethod("hasGlobalIpv6Address", new Class[0]);     // Catch: Exception -> L35
        Method r5 = r0.getDeclaredMethod("hasIpv6DefaultRoute", new Class[0]);     // Catch: Exception -> L35
        r1.setAccessible(true);     // Catch: Exception -> L35
        r3.setAccessible(true);     // Catch: Exception -> L35
        r4.setAccessible(true);     // Catch: Exception -> L35
        r5.setAccessible(true);     // Catch: Exception -> L35
        if (((Boolean) r1.invoke(r9, new Object[0])).booleanValue() == true) goto L13;
    L15:
        boolean r6 = false;
    L17:
        if (((Boolean) r4.invoke(r9, new Object[0])).booleanValue() == false) goto L21;
        if (((Boolean) r5.invoke(r9, new Object[0])).booleanValue() == false) goto L21;
        r2 = true;
    L21:
        if (r6 == false) goto L25;
        if (r2 == false) goto L25;
        return "Ipv4Ipv6";
    L25:
        if (r6 == false) goto L29;
        if (r2 == true) goto L29;
        return "Ipv4Only";
    L29:
        if (r6 == true) goto L33;
        if (r2 == false) goto L40;
        return "Ipv6Only";
    L40:
        return "NoV4V6";
    L33:
        return "NoV4V6";
    L13:
        if (((Boolean) r3.invoke(r9, new Object[0])).booleanValue() == false) goto L15;
        r6 = true;
    L35:
        e = move-exception;
        e.printStackTrace();
        return "UNKNOWN";
    }
}
