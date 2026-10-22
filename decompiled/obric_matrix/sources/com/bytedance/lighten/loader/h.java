package com.bytedance.lighten.loader;

import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
class h<E> extends LinkedBlockingDeque<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4945f;

    public h(int r1) {
        this.f4945f = r1;
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean offer(E r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (size() != this.f4945f) goto L6;
        removeLast();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        return super.offerFirst(r3);
    }
}
