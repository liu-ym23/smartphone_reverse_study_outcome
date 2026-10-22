package com.obric.matrix.push.m;

import android.content.Intent;
import com.obric.matrix.push_api.c;
import com.obric.matrix.push_api.d;
import com.obric.matrix.push_api.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/push/base/PushImplHelper;", "", "()V", "mPushClickListener", "", "Lcom/obric/matrix/push_api/IPushClickListener;", "mPushInterceptor", "Lcom/obric/matrix/push_api/IPushInterceptor;", "mPushShowListener", "Lcom/obric/matrix/push_api/IPushShowListener;", "onMessageIntercept", "", "messgae", "Lcom/obric/matrix/push_api/Message;", "onNotificaitonIntercept", "notification", "Lcom/obric/matrix/push_api/Notification;", "onPushClick", "", "msgId", "", "pkgName", "intent", "Landroid/content/Intent;", "onPushShow", "registerPushClickListener", "iPushClickListener", "registerPushInterceptor", "iPushInterceptor", "registerPushShowListener", "iPushShowListener", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.matrix.push_api.b> f9630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f9631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.obric.matrix.push_api.a> f9632c;

    public a() {
        this.f9630a = new ArrayList();
        this.f9631b = new ArrayList();
        this.f9632c = new ArrayList();
    }

    public final boolean a(d r6) {
        o.f(r6, "messgae");
        Iterator<T> r5 = this.f9630a.iterator();
    L3:
        boolean r1 = false;
    L5:
        if (r5.hasNext() == false) goto L13;
        if (((com.obric.matrix.push_api.b) r5.next()).b(r6) == true) goto L10;
        if (r1 == false) goto L3;
    L10:
        r1 = true;
    L11:
        th = move-exception;
        com.obric.matrix.push.n.c.c.h("business handle push intercept has throw , throw = " + th);
        goto L5
    L13:
        return r1;
    }

    public final boolean b(e r6) {
        o.f(r6, "notification");
        Iterator<T> r5 = this.f9630a.iterator();
    L3:
        boolean r1 = false;
    L5:
        if (r5.hasNext() == false) goto L13;
        if (((com.obric.matrix.push_api.b) r5.next()).a(r6) == true) goto L10;
        if (r1 == false) goto L3;
    L10:
        r1 = true;
    L11:
        th = move-exception;
        com.obric.matrix.push.n.c.c.h("business handle push intercept has throw , throw = " + th);
        goto L5
    L13:
        return r1;
    }

    public final void c(String r4, String r5, Intent r6) {
        o.f(r4, "msgId");
        o.f(r5, "pkgName");
        Iterator<T> r3 = this.f9632c.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        ((com.obric.matrix.push_api.a) r3.next()).a(r4, r5, r6);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.obric.matrix.push.n.c.c.h("business handle push click has throw , throw = " + th);
        goto L4
    }

    public final void d(String r4, String r5) {
        o.f(r4, "msgId");
        o.f(r5, "pkgName");
        Iterator<T> r3 = this.f9631b.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        ((c) r3.next()).a(r4, r5);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.obric.matrix.push.n.c.c.h("business handle push show has throw , throw = " + th);
        goto L4
    }

    public final void e(com.obric.matrix.push_api.a r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.f9632c.add(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final void f(com.obric.matrix.push_api.b r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.f9630a.add(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final void g(c r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.f9631b.add(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
