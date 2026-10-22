package com.bytedance.securityserver.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class WiFiMonitor {
    public static volatile WiFiMonitor f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WiFiTask f86a;
    public final ConnectivityManager b;
    public ConnectivityManager.NetworkCallback c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f87d;
    public final Handler e;

    /* JADX INFO: renamed from: com.bytedance.securityserver.utils.WiFiMonitor$1, reason: invalid class name */
    class AnonymousClass1 extends ConnectivityManager.NetworkCallback {
        public static final /* synthetic */ int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WiFiMonitor f88a;

        public AnonymousClass1(WiFiMonitor r1) {
            this.f88a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r3) {
            this.f88a.f87d.submit(new b(0, this));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r1) {
        }
    }

    public interface WiFiTask {
        int a();
    }

    public WiFiMonitor(Context r3, androidx.constraintlayout.core.state.a r4) {
        this.f87d = Executors.newSingleThreadExecutor();
        this.e = new Handler(Looper.getMainLooper());
        this.f86a = r4;
        this.b = (ConnectivityManager) r3.getSystemService("connectivity");
    }

    public final void a() {
        if (this.c == null) goto L5;
        return;
    L5:
        NetworkRequest r0 = new NetworkRequest.Builder().addTransportType(1).build();
        AnonymousClass1 r1 = new AnonymousClass1(this);
        this.c = r1;
        this.b.registerNetworkCallback(r0, r1);
    }
}
