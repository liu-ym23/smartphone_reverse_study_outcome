package com.bytedance.apm.g0.g;

import com.bytedance.apm.trace.model.cross.NativeSpan;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm.g0.j.a f1579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1581c;

    public synchronized void a(String r6, ArrayList<NativeSpan> r7) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f1581c == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (this.f1580b == false) goto L21;
        boolean r0 = true;
        Iterator<NativeSpan> r8 = r7.iterator();     // Catch: Throwable -> L23
    L9:
        if (r8.hasNext() == false) goto L19;
        NativeSpan r1 = r8.next();     // Catch: Throwable -> L23
        if (r1 == null) goto L9;
        c r2 = r1.parseToSpan(this.f1579a);     // Catch: Throwable -> L23
        if (r0 == false) goto L17;
        r2.a(Long.parseLong(r6));     // Catch: Throwable -> L23
    L17:
        r2.c(r1.getStartTime(), r1.getFinishTime());     // Catch: Throwable -> L23
        r0 = false;
        goto L9
    L19:
        monitor-exit(this);
    }

    public synchronized void b(String r6, ArrayList<NativeSpan> r7) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f1581c == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (this.f1580b == false) goto L21;
        boolean r0 = true;
        Iterator<NativeSpan> r8 = r7.iterator();     // Catch: Throwable -> L23
    L9:
        if (r8.hasNext() == false) goto L19;
        NativeSpan r1 = r8.next();     // Catch: Throwable -> L23
        if (r1 == null) goto L9;
        c r2 = r1.parseToSpan(this.f1579a);     // Catch: Throwable -> L23
        if (r0 == false) goto L17;
        r2.b(Long.parseLong(r6));     // Catch: Throwable -> L23
    L17:
        r2.c(r1.getStartTime(), r1.getFinishTime());     // Catch: Throwable -> L23
        r0 = false;
        goto L9
    L19:
        monitor-exit(this);
    }
}
