package com.obric.matrix.opush.d;

import android.content.Intent;
import com.obric.matrix.opush_api.c;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/opush/base/PushImplHelper;", "", "()V", "mPushClickListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/opush_api/IPushClickListener;", "mPushInterceptor", "Lcom/obric/matrix/opush_api/IPushInterceptor;", "mPushShowListener", "Lcom/obric/matrix/opush_api/IPushShowListener;", "onMessageIntercept", "", "messgae", "Lcom/obric/matrix/opush_api/Message;", "onNotificaitonIntercept", "notification", "Lcom/obric/matrix/opush_api/Notification;", "onPushClick", "", "msgId", "", "pkgName", "intent", "Landroid/content/Intent;", "onPushShow", "registerPushClickListener", "iPushClickListener", "registerPushInterceptor", "iPushInterceptor", "registerPushShowListener", "iPushShowListener", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.obric.matrix.opush_api.b> f9248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f9249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.obric.matrix.opush_api.a> f9250c;

    public a() {
        this.f9248a = new CopyOnWriteArrayList();
        this.f9249b = new CopyOnWriteArrayList();
        this.f9250c = new CopyOnWriteArrayList();
    }

    public final void a(String r5, String r6, Intent r7) {
        o.f(r5, "msgId");
        o.f(r6, "pkgName");
        Iterator<T> r4 = this.f9250c.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        ((com.obric.matrix.opush_api.a) r4.next()).a(r5, r6, r7);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.g("business handle push click has throw , throw = " + th);
        goto L4
    }

    public final void b(String r5, String r6) {
        o.f(r5, "msgId");
        o.f(r6, "pkgName");
        Iterator<T> r4 = this.f9249b.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        ((c) r4.next()).a(r5, r6);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.g("business handle push show has throw , throw = " + th);
        goto L4
    }

    public final void c(com.obric.matrix.opush_api.a r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.f9250c.add(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final void d(com.obric.matrix.opush_api.b r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.f9248a.add(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final void e(c r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.f9249b.add(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
