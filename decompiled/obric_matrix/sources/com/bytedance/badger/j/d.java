package com.bytedance.badger.j;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
final class d implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f2612f = null;

    static {
        f2612f = new d();
    }

    d() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r2) {
        Thread r1 = new Thread(r2, "BadgerReportThread");
        r1.setDaemon(true);
        return r1;
    }
}
