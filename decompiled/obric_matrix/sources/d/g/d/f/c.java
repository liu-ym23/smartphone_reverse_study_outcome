package d.g.d.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.Objects;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    static {
    }

    public static final boolean a(Context r3) {
        o.f(r3, "context");
        Object r4 = r3.getSystemService("connectivity");
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r5 = (ConnectivityManager) r4;
        Network r0 = r5.getActiveNetwork();
        if (r0 == null) goto L15;
        o.e(r0, "connectivityManager.activeNetwork ?: return false");
        NetworkCapabilities r6 = r5.getNetworkCapabilities(r0);
        if (r6 == null) goto L16;
        o.e(r6, "connectivityManager.getN…          ?: return false");
        if (r6.hasTransport(1) == false) goto L10;
    L17:
        return true;
    L10:
        if (r6.hasTransport(0) == true) goto L17;
        if (r6.hasTransport(3) == true) goto L17;
        return false;
    L16:
        return false;
    L15:
        return false;
    }
}
