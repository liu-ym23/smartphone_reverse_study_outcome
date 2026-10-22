package yt;

import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f23339b = null;

    static {
        int r5 = k.f23347c;
        int r10 = k.d;
        f23339b = new e(k.e, k.f23345a, r5, r10);
    }

    @Override // yt.h, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public final void g() {
        super.close();
    }

    @Override // kotlinx.coroutines.z
    public final z limitedParallelism(int r5, String r10) {
        kotlinx.coroutines.internal.f.c(r5);
        if (r5 < k.f23347c) goto L8;
        if (r10 != null) goto L6;
        return this;
    L6:
        return new o(this, r10);
    L8:
        return super.limitedParallelism(r5, r10);
    }

    @Override // kotlinx.coroutines.z
    public final String toString() {
        return "Dispatchers.Default";
    }
}
