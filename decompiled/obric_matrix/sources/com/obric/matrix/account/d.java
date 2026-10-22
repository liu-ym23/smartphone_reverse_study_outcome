package com.obric.matrix.account;

import android.app.PendingIntent;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/account/LoginActivityCallbackHelper;", "", "()V", "TAG", "", "mCallback", "Landroid/app/PendingIntent;", "execCallback", "", "setCallback", "callback", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile PendingIntent f8447b;

    static {
        f8446a = new d();
    }

    private d() {
    }

    public final void a() {
        monitor-enter(this);
        PendingIntent r0 = f8447b;     // Catch: Throwable -> L8 Exception -> L10
        if (r0 == null) goto L6;
        r0.send();     // Catch: Throwable -> L8 Exception -> L10
    L6:
        com.obric.matrix.r.c.c.b("LoginActivityCallbackHelper", "execCallback mCallback = " + f8447b);     // Catch: Throwable -> L8 Exception -> L10
    L12:
        f8447b = null;     // Catch: Throwable -> L8
        f0 r1 = f0.f18324a;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        com.obric.matrix.r.c.c.g("LoginActivityCallbackHelper", "execCallback failed.", e);     // Catch: Throwable -> L8
        goto L12
    }

    public final void b(PendingIntent r3) {
        monitor-enter(this);
        f8447b = r3;     // Catch: Throwable -> L6
        com.obric.matrix.r.c.c.b("LoginActivityCallbackHelper", "setCallback mCallback = " + f8447b);     // Catch: Throwable -> L6
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
