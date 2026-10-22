package d.b.b.o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static int a(Context r4) {
        ConnectivityManager r1 = (ConnectivityManager) r4.getSystemService("connectivity");     // Catch: Throwable -> L15
        NetworkInfo r2 = null;
        if (ContextCompat.checkSelfPermission(r4, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L6;
        r2 = r1.getActiveNetworkInfo();     // Catch: Throwable -> L15
    L6:
        if (r2 == null) goto L14;
        if (r2.isAvailable() == false) goto L14;
        if (r2.getType() != 0) goto L14;
        return ((TelephonyManager) r4.getSystemService("phone")).getNetworkType();
    L14:
        return -10000;
    }
}
