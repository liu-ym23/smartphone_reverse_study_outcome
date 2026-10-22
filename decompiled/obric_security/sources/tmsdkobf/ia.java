package tmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ia {
    public static byte a(Context r3) {
        NetworkInfo r0 = ((ConnectivityManager) r3.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L27
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r0.getState() == NetworkInfo.State.CONNECTING) goto L10;
        if (r0.getState() == NetworkInfo.State.CONNECTED) goto L10;
        return -1;
    L10:
        if (r0.getType() != 1) goto L14;
        return 0;
    L14:
        if (r0.getType() == 0) goto L16;
        return 3;
    L16:
        if (Proxy.getDefaultHost() != null) goto L21;
        if (Proxy.getHost(r3) != null) goto L38;
        return 1;
    L38:
        return 2;
    L21:
        return 2;
    L27:
        th = move-exception;
        String r4 = th.getMessage();
        if (r4 != null) goto L31;
    L33:
        return -3;
    L31:
        if (r4.contains("ACCESS_NETWORK_STATE") == false) goto L33;
        return -2;
    }

    public static boolean b(Context r3) {
        ConnectivityManager r4 = (ConnectivityManager) r3.getSystemService("connectivity");     // Catch: Throwable -> L13
        if (r4 != null) goto L6;
        return false;
    L6:
        NetworkInfo r5 = r4.getActiveNetworkInfo();     // Catch: Throwable -> L13
        if (r5 == null) goto L12;
        if (r5.isConnected() == false) goto L12;
        return true;
    L12:
        return false;
    L13:
        th = move-exception;
        String r6 = th.getMessage();
        if (r6 == null) goto L20;
        if (r6.contains("ACCESS_NETWORK_STATE") == false) goto L20;
        return true;
    L20:
        return false;
    }
}
