package com.bytedance.applog.t;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.i;
import com.obric.matrix.common_api.INetworkApi;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Handler f2389k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bytedance.applog.t.b f2393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f2394j;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f2395f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f2396g;

        a(d r1, int r2) {
            this.f2396g = r1;
            this.f2395f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a(this.f2396g) == null) goto L6;
            d.a(this.f2396g).onFail(this.f2395f);
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f2397f;

        b(d r1) {
            this.f2397f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(this.f2397f).onSuccess();
        }
    }

    static {
        f2389k = new Handler(Looper.getMainLooper());
    }

    public d(String r1, String r2, String r3, com.bytedance.applog.t.b r4, Context r5) {
        this.f2390f = r1;
        this.f2391g = r2;
        this.f2392h = r3;
        this.f2393i = r4;
        this.f2394j = r5;
    }

    static /* synthetic */ com.bytedance.applog.t.b a(d r0) {
        return r0.f2393i;
    }

    private void b(int r3) {
        f2389k.post(new a(this, r3));
    }

    private void c() {
        f2389k.post(new b(this));
    }

    @Override // java.lang.Runnable
    public void run() {
    L8:
        b(1);
        return;
    L3:
        if (i.o(this.f2394j) == true) goto L6;
        b(0);     // Catch: Throwable -> L8
        return;
    L6:
        HashMap r0 = new HashMap();     // Catch: Throwable -> L8
        r0.put(INetworkApi.CONTENT_TYPE, "application/json");     // Catch: Throwable -> L8
        r0.put("X-APIKEY", this.f2391g);     // Catch: Throwable -> L8
        com.bytedance.applog.a.u().a(this.f2390f, this.f2392h.getBytes(), r0);     // Catch: Throwable -> L8
        c();     // Catch: Throwable -> L8
    }
}
