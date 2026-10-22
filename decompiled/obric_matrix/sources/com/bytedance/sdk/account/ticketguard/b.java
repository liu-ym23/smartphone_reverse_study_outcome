package com.bytedance.sdk.account.ticketguard;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile AtomicBoolean f5770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f5771b = null;

    static {
        f5771b = new b();
        f5770a = new AtomicBoolean(false);
    }

    private b() {
    }

    public final void a() {
        Class.forName("com.bytedance.sdk.account.ticketguard.AccountTicketGuardHelper").getDeclaredMethod("onAccountSettingsUpdate", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.b.s.a.a0.a.b("AccountTicketGuardManag", "onAccountSettingsUpdate: fail for exception:" + Log.getStackTraceString(e));
    }

    public final void b(Context r7, l<? super Boolean, f0> r8) {
        o.g(r7, "context");
        Class.forName("com.bytedance.sdk.account.ticketguard.AccountTicketGuardHelper").getDeclaredMethod("initTicketGuard", new Class[]{Context.class, l.class}).invoke(null, new Object[]{r7, r8});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.b.s.a.a0.a.b("AccountTicketGuardManag", "AccountTicketGuardManager.tryInit: fail for exception:" + Log.getStackTraceString(e));
        if (r8 == null) goto L12;
        f0 r6 = r8.invoke(Boolean.FALSE);
        return;
    }

    public final void c() {
        if (f5770a.compareAndSet(false, true) == false) goto L11;
        Class.forName("com.bytedance.sdk.account.ticketguard.AccountTicketGuardHelper").getDeclaredMethod("initTicketInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.b.s.a.a0.a.b("AccountTicketGuardManag", "tryInitTicketInstance: fail for exception:" + Log.getStackTraceString(e));
        return;
    }
}
