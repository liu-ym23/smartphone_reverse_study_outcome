package com.bytedance.securityserver.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class NetworkMonitor {
    public static volatile NetworkMonitor f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkTask f83a;
    public final ConnectivityManager b;
    public ConnectivityManager.NetworkCallback c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f84d;
    public final Handler e;

    public interface NetworkTask {
        int a();
    }

    public NetworkMonitor(Context r3, com.bytedance.securityserver.a r4) {
        this.f84d = Executors.newSingleThreadExecutor();
        this.e = new Handler(Looper.getMainLooper());
        this.f83a = r4;
        this.b = (ConnectivityManager) r3.getSystemService("connectivity");
    }

    public final void a() {
        ConnectivityManager r0 = this.b;
        if (this.c == null) goto L22;
        return;
    L22:
        Network r2 = r0.getActiveNetwork();     // Catch: Exception -> L14
        if (r2 == null) goto L20;
        NetworkCapabilities r3 = r0.getNetworkCapabilities(r2);     // Catch: Exception -> L14
        if (r3 == null) goto L20;
        if (r3.hasCapability(12) == false) goto L20;
        this.f84d.submit(new b(1, this));
    L20:
        NetworkRequest r1 = new NetworkRequest.Builder().addCapability(12).build();
        ConnectivityManager.NetworkCallback r4 = new AnonymousClass1(this);
        this.c = r4;
        r0.registerNetworkCallback(r1, r4);
        return;
    L14:
        e = move-exception;
        if (e.getMessage() != null) goto L18;
        String r5 = e.getClass().getSimpleName();
    L19:
        Log.e("SecurityServer-NetworkMonitor", "isNetworkAvailable check failed: " + r5);
        goto L20
    L18:
        r5 = e.getMessage();
        goto L19
    }
}
