package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
@ThreadSafe
public class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final SparseArray<b<T>> f6722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    b<T> f6723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b<T> f6724c;

    static /* synthetic */ class a {
    }

    static class b<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b<I> f6725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        LinkedList<I> f6727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        b<I> f6728d;

        private b(b<I> r1, int r2, LinkedList<I> r3, b<I> r4) {
            this.f6725a = r1;
            this.f6726b = r2;
            this.f6727c = r3;
            this.f6728d = r4;
        }

        /* synthetic */ b(b r1, int r2, LinkedList r3, b r4, a r5) {
            this(r1, r2, r3, r4);
        }

        public String toString() {
            return "LinkedEntry(key: " + this.f6726b + ")";
        }
    }

    public g() {
        this.f6722a = new SparseArray();
    }

    private void b(b<T> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.f6727c.isEmpty() == false) goto L8;
        d(r2);
        this.f6722a.remove(r2.f6726b);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(b<T> r2) {
        if (this.f6723b != r2) goto L5;
        return;
    L5:
        d(r2);
        b<T> r0 = this.f6723b;
        if (r0 != 0) goto L9;
        this.f6723b = r2;
        this.f6724c = r2;
        return;
    L9:
        r2.f6728d = r0;
        r0.f6725a = r2;
        this.f6723b = r2;
    }

    private synchronized void d(b<T> r4) {
        monitor-enter(this);
        b r0 = (b<T>) r4.f6725a;
        b r1 = (b<T>) r4.f6728d;
        if (r0 == null) goto L6;
        r0.f6728d = r1;     // Catch: Throwable -> L16
    L6:
        if (r1 == null) goto L8;
        r1.f6725a = r0;     // Catch: Throwable -> L16
    L8:
        r4.f6725a = null;     // Catch: Throwable -> L16
        r4.f6728d = null;     // Catch: Throwable -> L16
        if (r4 != this.f6723b) goto L12;
        this.f6723b = r1;     // Catch: Throwable -> L16
    L12:
        if (r4 != this.f6724c) goto L14;
        this.f6724c = r0;     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized T a(int r2) {
        monitor-enter(this);
        b<T> r3 = this.f6722a.get(r2);     // Catch: Throwable -> L11
        if (r3 == null) goto L6;
        T r0 = r3.f6727c.pollFirst();     // Catch: Throwable -> L11
        c(r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L6:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void e(int r8, T r9) {
        monitor-enter(this);
        b<T> r0 = this.f6722a.get(r8);     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        r0 = new b(null, r8, new LinkedList(), null, null);     // Catch: Throwable -> L9
        this.f6722a.put(r8, r0);     // Catch: Throwable -> L9
    L6:
        r0.f6727c.addLast(r9);     // Catch: Throwable -> L9
        c(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized T f() {
        monitor-enter(this);
        b<T> r0 = this.f6724c;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        T r1 = r0.f6727c.pollLast();     // Catch: Throwable -> L11
        b(r0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L6:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }
}
