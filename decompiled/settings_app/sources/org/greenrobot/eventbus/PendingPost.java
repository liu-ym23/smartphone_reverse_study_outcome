package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class PendingPost {
    private static final List<PendingPost> pendingPostPool = null;
    Object event;
    PendingPost next;
    Subscription subscription;

    static {
        pendingPostPool = new ArrayList();
    }

    private PendingPost(Object r1, Subscription r2) {
        this.event = r1;
        this.subscription = r2;
    }

    static PendingPost obtainPendingPost(Subscription r2, Object r3) {
        List<PendingPost> r0 = pendingPostPool;
        monitor-enter(r0);
        int r1 = r0.size();     // Catch: Throwable -> L12
        if (r1 <= 0) goto L9;
        PendingPost r4 = r0.remove(r1 - 1);     // Catch: Throwable -> L12
        r4.event = r3;     // Catch: Throwable -> L12
        r4.subscription = r2;     // Catch: Throwable -> L12
        r4.next = null;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return new PendingPost(r3, r2);
    L12:
        th = move-exception;
        throw th;
    }

    static void releasePendingPost(PendingPost r3) {
        r3.event = null;
        r3.subscription = null;
        r3.next = null;
        List<PendingPost> r0 = pendingPostPool;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r0.size() >= 10000) goto L7;
        r0.add(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }
}
