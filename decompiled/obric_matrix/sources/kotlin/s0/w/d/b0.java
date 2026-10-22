package kotlin.s0.w.d;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<j0, WeakReference<kotlin.s0.w.d.l0.c.s1.a.k>> f18502a = null;

    static {
        f18502a = new ConcurrentHashMap();
    }

    public static final kotlin.s0.w.d.l0.c.s1.a.k a(Class<?> r5) {
        kotlin.n0.d.o.f(r5, "<this>");
        ClassLoader r6 = kotlin.s0.w.d.l0.c.s1.b.d.e(r5);
        j0 r0 = new j0(r6);
        ConcurrentMap<j0, WeakReference<kotlin.s0.w.d.l0.c.s1.a.k>> r1 = f18502a;
        WeakReference<kotlin.s0.w.d.l0.c.s1.a.k> r2 = r1.get(r0);
        if (r2 == null) goto L8;
        kotlin.s0.w.d.l0.c.s1.a.k r3 = r2.get();
        if (r3 == null) goto L7;
        return r3;
    L7:
        r1.remove(r0, r2);
    L8:
        kotlin.s0.w.d.l0.c.s1.a.k r7 = kotlin.s0.w.d.l0.c.s1.a.k.f19093c.a(r6);
    L23:
        ConcurrentMap<j0, WeakReference<kotlin.s0.w.d.l0.c.s1.a.k>> r4 = f18502a;     // Catch: Throwable -> L20
        WeakReference<kotlin.s0.w.d.l0.c.s1.a.k> r8 = r4.putIfAbsent(r0, new WeakReference(r7));     // Catch: Throwable -> L20
        if (r8 == null) goto L12;
        kotlin.s0.w.d.l0.c.s1.a.k r9 = r8.get();     // Catch: Throwable -> L20
        if (r9 != null) goto L16;
        r4.remove(r0, r8);     // Catch: Throwable -> L20
        goto L23
    L16:
        r0.a(null);
        return r9;
    L12:
        r0.a(null);
        return r7;
    L20:
        th = move-exception;
        r0.a(null);
        throw th;
    }
}
