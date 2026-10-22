package com.bytedance.sync.v2.l;

import com.bytedance.sync.v2.presistence.d.e;
import java.io.ByteArrayInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.w;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f6161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f6162b = null;

    static final class a extends q implements kotlin.n0.c.a<ExecutorService> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f6163f = null;

        static {
            f6163f = new a();
        }

        a() {
            super(0);
        }

        public final ExecutorService a() {
            return Executors.newSingleThreadExecutor();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ExecutorService invoke() {
            return a();
        }
    }

    static {
        f6161a = new l[]{e0.f(new w(e0.d(b.class, "sync-sdk_release"), "CALLBACK_EXECUTORS", "getCALLBACK_EXECUTORS()Ljava/util/concurrent/ExecutorService;"))};
        f6162b = i.b(a.f6163f);
    }

    public static final ExecutorService a() {
        ExecutorService r0 = b();
        o.b(r0, "CALLBACK_EXECUTORS");
        return r0;
    }

    private static final ExecutorService b() {
        h r0 = f6162b;
        l r1 = f6161a[0];
        return (ExecutorService) r0.getValue();
    }

    public static final JSONObject c(com.bytedance.sync.v2.presistence.d.b r4) {
        o.g(r4, "$this$toMonitorExtra");
        JSONObject r0 = new JSONObject();
        r0.put("sync_id", r4.f6217a);
        r0.put("cursor", r4.f6221e);
        r0.put("business", r4.f6218b);
        return r0;
    }

    public static final JSONObject d(e r4) {
        o.g(r4, "$this$toMonitorExtra");
        JSONObject r0 = new JSONObject();
        r0.put("sync_id", r4.f6248a);
        r0.put("cursor", r4.f6251d);
        r0.put("business", r4.f6254g);
        return r0;
    }

    public static final byte[] e(byte[] r2) {
        if (r2 == null) goto L13;
        GZIPInputStream r3 = new GZIPInputStream(new ByteArrayInputStream(r2));
        byte[] r1 = kotlin.m0.a.c(r3);     // Catch: Throwable -> L8
        kotlin.m0.b.a(r3, null);
        return r1;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        kotlin.m0.b.a(r3, th);
        throw th;
    L13:
        return null;
    }
}
