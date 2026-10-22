package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

/* JADX INFO: loaded from: classes2.dex */
public final class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b3 f7146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f7147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Messenger f7148c;

    public a4(Context r2) {
        this.f7146a = null;
        this.f7147b = null;
        this.f7148c = null;
        this.f7147b = r2.getApplicationContext();
        this.f7146a = new b3(this.f7147b);
    }

    public final IBinder a(Intent r2) {
        this.f7146a.w(r2);
        this.f7146a.d(r2);
        Messenger r3 = new Messenger(this.f7146a.s());
        this.f7148c = r3;
        return r3.getBinder();
    }

    public final void b() {
        b3.C();     // Catch: Throwable -> L4
        b3 r0 = this.f7146a;     // Catch: Throwable -> L4
        r0.n = a5.A();     // Catch: Throwable -> L4
        b3 r1 = this.f7146a;     // Catch: Throwable -> L4
        r1.o = a5.f();     // Catch: Throwable -> L4
        this.f7146a.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "onCreate");
    }

    public final int c() {
        b3 r0 = this.f7146a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.v.Q() == true) goto L10;
        return 2;
    L10:
        return 0;
    }

    public final void d() {
        b3 r2 = this.f7146a;     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.s().sendEmptyMessage(11);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "onDestroy");
    }
}
