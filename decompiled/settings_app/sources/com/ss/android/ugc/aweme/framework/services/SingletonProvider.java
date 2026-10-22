package com.ss.android.ugc.aweme.framework.services;

/* JADX INFO: loaded from: classes5.dex */
public class SingletonProvider<T> implements ServiceProvider<T> {
    volatile T service;
    ServiceProvider<T> serviceProvider;

    public SingletonProvider(ServiceProvider r1) {
        this.serviceProvider = r1;
    }

    @Override // com.ss.android.ugc.aweme.framework.services.ServiceProvider
    public synchronized T get() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.service != null) goto L6;
        this.service = this.serviceProvider.get();     // Catch: Throwable -> L9
    L6:
        T r0 = this.service;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }
}
