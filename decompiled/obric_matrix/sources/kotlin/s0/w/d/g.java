package kotlin.s0.w.d;

import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static kotlin.s0.w.d.m0.b<String, Object> f18549a;

    static {
        kotlin.s0.w.d.m0.b<String, Object> r0 = kotlin.s0.w.d.m0.b.b();
        kotlin.n0.d.o.e(r0, "empty<String, Any>()");
        f18549a = r0;
    }

    public static final <T> h<T> a(Class<T> r9) {
        kotlin.n0.d.o.f(r9, "jClass");
        String r0 = r9.getName();
        Object r1 = f18549a.c(r0);
        Class<T> r3 = null;
        if ((r1 instanceof WeakReference) == false) goto L10;
        h<T> r2 = (h) ((WeakReference) r1).get();
        if (r2 == null) goto L8;
        r3 = r2.e();
    L8:
        if (kotlin.n0.d.o.a(r3, r9) == false) goto L24;
        return r2;
    L24:
        h<T> r4 = new h(r9);
        kotlin.s0.w.d.m0.b<String, Object> r10 = f18549a.f(r0, new WeakReference(r4));
        String r5 = "K_CLASS_CACHE.plus(name, WeakReference(newKClass))";
    L22:
        kotlin.n0.d.o.e(r10, r5);
        f18549a = r10;
        return r4;
    L10:
        if (r1 == null) goto L24;
        WeakReference[] r6 = (WeakReference[]) r1;
        int r7 = r6.length;
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L21;
        h<T> r11 = (h) r6[r8].get();
        if (r11 == null) goto L16;
        Class<T> r12 = r11.e();
    L18:
        if (kotlin.n0.d.o.a(r12, r9) == true) goto L19;
        r8 = r8 + 1;
        goto L12
    L19:
        return r11;
    L16:
        r12 = null;
        goto L18
    L21:
        int r13 = ((Object[]) r1).length;
        WeakReference[] r14 = new WeakReference[r13 + 1];
        System.arraycopy(r1, 0, r14, 0, r13);
        r4 = new h(r9);
        r14[r13] = new WeakReference(r4);
        r10 = f18549a.f(r0, r14);
        r5 = "K_CLASS_CACHE.plus(name, newArray)";
        goto L22
    }
}
