package com.obric.matrix.r.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.provider.Settings;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/common_utils/utils/NetworkUtils;", "", "()V", "TAG", "", "isAirPlaneModeOn", "", "isNetworkAvailable", "isNetworkAvailableByActiveNetwork", "isNetworkConnected", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9941a = null;

    static {
        f9941a = new h();
    }

    private h() {
    }

    public static final boolean a() {
        Context r1 = com.obric.matrix.r.a.c();
        boolean r2 = false;
        if (r1 != null) goto L12;
        return false;
    L12:
        if (Settings.System.getInt(r1.getContentResolver(), "airplane_mode_on", 0) == 0) goto L10;
        r2 = true;
    L10:
        com.obric.matrix.r.c.c.b("NetworkUtils", "isAirPlaneModeOn? " + r2);
        return r2;
    L8:
        e = move-exception;
        com.obric.matrix.r.c.c.g("NetworkUtils", "isAirPlaneModeOn, error", e);
        goto L10
    }

    public static final boolean b() {
        Context r0 = com.obric.matrix.r.a.c();
        if (r0 != null) goto L5;
        return false;
    L5:
        Object r1 = r0.getSystemService("connectivity");
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r2 = (ConnectivityManager) r1;
        Network[] r3 = r2.getAllNetworks();
        kotlin.n0.d.o.e(r3, "connectivityManager.allNetworks");
        int r4 = r3.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L20;
        Network r6 = r3[r5];
        NetworkInfo r7 = r2.getNetworkInfo(r6);
        if (r7 == null) goto L19;
        if (r7.getType() == 17) goto L19;
        if (r7.getState() != NetworkInfo.State.CONNECTED) goto L19;
        NetworkCapabilities r8 = r2.getNetworkCapabilities(r6);
        if (r8 == null) goto L19;
        if (r8.hasCapability(16) == false) goto L19;
        return true;
    L19:
        r5 = r5 + 1;
        goto L6
    L20:
        return false;
    }

    public static final boolean d() {
        Context r0 = com.obric.matrix.r.a.c();
        if (r0 != null) goto L21;
        return false;
    L21:
        Object r1 = r0.getSystemService("connectivity");     // Catch: Exception -> L20
        if (r1 == null) goto L18;
        ConnectivityManager r2 = (ConnectivityManager) r1;     // Catch: Exception -> L20
        Network r3 = r2.getActiveNetwork();     // Catch: Exception -> L20
        if (r3 != null) goto L10;
        return false;
    L10:
        NetworkCapabilities r4 = r2.getNetworkCapabilities(r3);     // Catch: Exception -> L20
        if (r4 != null) goto L13;
        return false;
    L13:
        boolean r5 = r4.hasCapability(12);     // Catch: Exception -> L20
        boolean r6 = r4.hasCapability(16);     // Catch: Exception -> L20
        if (r5 == false) goto L19;
        if (r6 == true) goto L23;
        return false;
    L23:
        return true;
    L19:
        return false;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L20
    L24:
        return false;
    }

    public final boolean c() {
        Context r2 = com.obric.matrix.r.a.c();
        if (r2 != null) goto L5;
        return false;
    L5:
        Object r3 = r2.getSystemService("connectivity");
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r4 = (ConnectivityManager) r3;
        Network r1 = r4.getActiveNetwork();
        if (r1 != null) goto L8;
        return false;
    L8:
        NetworkCapabilities r5 = r4.getNetworkCapabilities(r1);
        if (r5 != null) goto L12;
        return false;
    L12:
        if (r5.hasCapability(12) == true) goto L14;
        return false;
    L14:
        if (r5.hasCapability(16) == false) goto L18;
        return true;
    L18:
        return false;
    }
}
