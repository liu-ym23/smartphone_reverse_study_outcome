package com.ss.ttuploader.net;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p000j.a0;
import p000j.d0;
import p000j.e;
import p000j.e0;
import p000j.y;

/* JADX INFO: loaded from: classes2.dex */
public class TTHTTPNetwork extends TTVNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final y JSON = null;
    private static a0 mClient;
    private e mCall;

    static {
        JSON = y.d("application/json");
    }

    public TTHTTPNetwork() {
    }

    @Override // com.ss.ttuploader.net.TTVNetClient
    public void cancel() {
        e r0 = this.mCall;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.g() == true) goto L9;
        this.mCall.cancel();
        return;
    }

    @Override // com.ss.ttuploader.net.TTVNetClient
    public void startTask(String r6, Map<String, String> r7, final TTVNetClient.CompletionListener r8) {
        monitor-enter(TTHTTPNetwork.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mClient != null) goto L7;
        a0.b r1 = new a0().v();     // Catch: Throwable -> L16
        TimeUnit r2 = TimeUnit.SECONDS;     // Catch: Throwable -> L16
        r1.d(10, r2);     // Catch: Throwable -> L16
        r1.s(10, r2);     // Catch: Throwable -> L16
        r1.n(10, r2);     // Catch: Throwable -> L16
        mClient = r1.c();     // Catch: Throwable -> L16
    L7:
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L16
        d0.a r0 = new d0.a();
        r0.k(r6);
        if (r7 == null) goto L14;
        Iterator<String> r9 = r7.keySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        String r3 = r9.next();
        r0.d(r3, r7.get(r3));
    L14:
        d0 r10 = r0.b();
        e r11 = mClient.w(r10);
        this.mCall = r11;
        r11.s(new AnonymousClass1(this, r8));
    }

    @Override // com.ss.ttuploader.net.TTVNetClient
    public void startTask(String r6, Map<String, String> r7, JSONObject r8, int r9, final TTVNetClient.CompletionListener r10) {
        monitor-enter(TTHTTPNetwork.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (mClient != null) goto L7;
        a0.b r1 = new a0().v();     // Catch: Throwable -> L21
        TimeUnit r2 = TimeUnit.SECONDS;     // Catch: Throwable -> L21
        r1.d(10, r2);     // Catch: Throwable -> L21
        r1.s(10, r2);     // Catch: Throwable -> L21
        r1.n(10, r2);     // Catch: Throwable -> L21
        mClient = r1.c();     // Catch: Throwable -> L21
    L7:
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L21
        d0.a r0 = new d0.a();
        r0.k(r6);
        if (r7 == null) goto L17;
        if (r7.size() <= 0) goto L17;
        Iterator<String> r11 = r7.keySet().iterator();
    L14:
        if (r11.hasNext() == false) goto L17;
        String r3 = r11.next();
        r0.a(r3, r7.get(r3));
    L17:
        if (r9 != 1) goto L19;
        r0.g(e0.c(JSON, String.valueOf(r8)));
    L19:
        e r12 = mClient.w(r0.b());
        this.mCall = r12;
        r12.s(new AnonymousClass2(this, r10));
    }
}
