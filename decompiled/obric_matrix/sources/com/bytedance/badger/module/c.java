package com.bytedance.badger.module;

import com.bytedance.badger.f.e;
import java.util.concurrent.CountDownLatch;
import kotlin.n0.d.d0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
final class c implements com.bytedance.badger.f.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d0 f2631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f2632b;

    c(d0 r1, CountDownLatch r2) {
        this.f2631a = r1;
        this.f2632b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.badger.f.d
    public final void a() {
        d0 r0 = this.f2631a;
        String r1 = e.a();     // Catch: Throwable -> L5
        o.b(r1, "DeviceFp1.GetDeviceIdByAsk()");     // Catch: Throwable -> L5
        this.f2632b.countDown();
        T r2 = r1;
    L8:
        r0.f18431f = r2;
        return;
    L5:
        th = move-exception;
        com.bytedance.badger.d.c("DeviceFpProvider", "GetDeviceIdByAsk failed", th);     // Catch: Throwable -> L10
        this.f2632b.countDown();
        r2 = "";
    L10:
        th = move-exception;
        this.f2632b.countDown();
        throw th;
    }
}
