package com.obric.oui.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NetworkUtil {
    public static final boolean a(Context r3) {
        Intrinsics.f(r3, "context");
        Object r4 = r3.getSystemService("connectivity");
        if (r4 == null) goto L19;
        ConnectivityManager r5 = (ConnectivityManager) r4;
        Network r0 = r5.getActiveNetwork();
        if (r0 == null) goto L17;
        NetworkCapabilities r6 = r5.getNetworkCapabilities(r0);
        if (r6 != null) goto L9;
        return false;
    L9:
        if (r6.hasTransport(1) == false) goto L12;
    L21:
        return true;
    L12:
        if (r6.hasTransport(0) == true) goto L21;
        if (r6.hasTransport(3) == true) goto L21;
        return false;
    L17:
        return false;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
