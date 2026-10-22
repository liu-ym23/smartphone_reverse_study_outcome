package com.obric.oui.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/utils/NetworkUtil;", "", "()V", "isNetworkAvailable", "", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkUtil {
    public static final NetworkUtil INSTANCE = null;

    static {
        INSTANCE = new NetworkUtil();
    }

    private NetworkUtil() {
    }

    @JvmStatic
    public static final boolean isNetworkAvailable(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Object r4 = r3.getSystemService("connectivity");
        if (r4 == null) goto L21;
        ConnectivityManager r5 = (ConnectivityManager) r4;
        Network r0 = r5.getActiveNetwork();
        if (r0 != null) goto L7;
        return false;
    L7:
        NetworkCapabilities r6 = r5.getNetworkCapabilities(r0);
        if (r6 != null) goto L11;
        return false;
    L11:
        if (r6.hasTransport(1) == false) goto L14;
    L19:
        return true;
    L14:
        if (r6.hasTransport(0) == true) goto L19;
        if (r6.hasTransport(3) == true) goto L19;
        return false;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
