package tmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import tmsdk.common.TMSDKContext;
import tmsdk.common.TMServiceFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f302a;

    public static boolean a() {
        if (vc.a() >= 11) goto L6;
        return true;
    L6:
        if (f302a >= 1) goto L9;
        f302a = TMSDKContext.getApplicaionContext().getApplicationInfo().targetSdkVersion;
    L9:
        if (f302a >= 10) goto L11;
        return true;
    L11:
        return false;
    }

    public static NetworkInfo b() {
        return TMServiceFactory.getSystemInfoService().getActiveNetworkInfo();
    L4:
        return null;
    }

    public static boolean c() {
        ConnectivityManager r1 = a(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L16
        if (r1 == null) goto L15;
        NetworkInfo[] r2 = r1.getAllNetworkInfo();     // Catch: Throwable -> L16
        if (r2 == null) goto L15;
        int r3 = 0;
    L9:
        if (r3 >= r2.length) goto L15;
        if (r2[r3].getState() == NetworkInfo.State.CONNECTED) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    public static boolean d() {
        NetworkInfo r0 = b();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isConnected();
    }

    public static ConnectivityManager a(Context r1) {
        return (ConnectivityManager) r1.getSystemService("connectivity");
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean b(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getNetworkInfo(1);     // Catch: Exception -> L10
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isConnected() == false) goto L9;
        return true;
    L9:
        return false;
    }
}
