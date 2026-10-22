package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class r0 {
    public static final String a(Object r0) {
        return r0.getClass().getSimpleName();
    }

    public static final String b(Object r0) {
        return Integer.toHexString(System.identityHashCode(r0));
    }

    public static final String c(kotlin.k0.d<?> r3) {
        if ((r3 instanceof h.a.f3.i) == false) goto L16;
        return r3.toString();
    L16:
        kotlin.v.a r1 = kotlin.v.f21457g;     // Catch: Throwable -> L8
        Object r2 = r3 + '@' + b(r3);     // Catch: Throwable -> L8
        kotlin.v.b(r2);     // Catch: Throwable -> L8
    L11:
        if (kotlin.v.d(r2) == null) goto L15;
        r2 = r3.getClass().getName() + '@' + b(r3);
    L15:
        return (String) r2;
    L8:
        th = move-exception;
        kotlin.v.a r4 = kotlin.v.f21457g;
        r2 = kotlin.w.a(th);
        kotlin.v.b(r2);
        goto L11
    }
}
