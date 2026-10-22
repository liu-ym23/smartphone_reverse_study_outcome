package com.facebook.imagepipeline.memory;

import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s<T> implements c0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<T> f6742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<T> f6743b;

    public s() {
        this.f6742a = new HashSet();
        this.f6743b = new g();
    }

    private T b(@Nullable T r2) {
        if (r2 == null) goto L10;
        monitor-enter(this);
        this.f6742a.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    L10:
        return r2;
    }

    @Override // com.facebook.imagepipeline.memory.c0
    @Nullable
    public T get(int r2) {
        T r3 = this.f6743b.a(r2);
        b(r3);
        return r3;
    }

    @Override // com.facebook.imagepipeline.memory.c0
    @Nullable
    public T pop() {
        T r0 = this.f6743b.f();
        b(r0);
        return r0;
    }

    @Override // com.facebook.imagepipeline.memory.c0
    public void put(T r2) {
        monitor-enter(this);
        boolean r0 = this.f6742a.add(r2);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r0 == false) goto L13;
        this.f6743b.e(a(r2), r2);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
