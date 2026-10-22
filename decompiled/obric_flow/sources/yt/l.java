package yt;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f23348a = null;

    static {
        f23348a = new l();
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        e.f23339b.f23341a.d(r10, true, false);
    }

    @Override // kotlinx.coroutines.z
    public final void dispatchYield(CoroutineContext r5, Runnable r10) {
        e.f23339b.f23341a.d(r10, true, true);
    }

    @Override // kotlinx.coroutines.z
    public final z limitedParallelism(int r5, String r10) {
        kotlinx.coroutines.internal.f.c(r5);
        if (r5 < k.d) goto L8;
        if (r10 != null) goto L6;
        return this;
    L6:
        return new o(this, r10);
    L8:
        return super.limitedParallelism(r5, r10);
    }

    @Override // kotlinx.coroutines.z
    public final String toString() {
        return "Dispatchers.IO";
    }
}
