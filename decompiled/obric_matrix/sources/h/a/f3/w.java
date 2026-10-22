package h.a.f3;

import h.a.i2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f17427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f17428b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i2 f17429c = null;

    static {
        w r0 = new w();
        f17427a = r0;
        f17428b = g0.e("kotlinx.coroutines.fast.service.loader", true);
        f17429c = r0.a();
    }

    private w() {
    }

    private final i2 a() {
    L26:
        th = move-exception;
        return x.b(th, null, 2, null);
    L4:
        if (f17428b == false) goto L6;
        List<v> r0 = l.f17394a.c();     // Catch: Throwable -> L26
    L7:
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L26
        if (r1.hasNext() == true) goto L10;
        Object r2 = null;
    L19:
        v r3 = (v) r2;     // Catch: Throwable -> L26
        if (r3 != null) goto L22;
        i2 r4 = null;
    L23:
        if (r4 != null) goto L33;
        return x.b(null, null, 3, null);
    L33:
        return r4;
    L22:
        r4 = x.e(r3, r0);     // Catch: Throwable -> L26
        goto L23
    L10:
        r2 = r1.next();     // Catch: Throwable -> L26
        if (r1.hasNext() == false) goto L19;
        int r5 = ((v) r2).getLoadPriority();     // Catch: Throwable -> L26
    L14:
        Object r6 = r1.next();     // Catch: Throwable -> L26
        int r7 = ((v) r6).getLoadPriority();     // Catch: Throwable -> L26
        if (r5 >= r7) goto L18;
        r2 = r6;
        r5 = r7;
    L18:
        if (r1.hasNext() == true) goto L14;
    L6:
        r0 = kotlin.t0.k.z(kotlin.t0.k.c(defpackage.a.b()));     // Catch: Throwable -> L26
        goto L7
    }
}
