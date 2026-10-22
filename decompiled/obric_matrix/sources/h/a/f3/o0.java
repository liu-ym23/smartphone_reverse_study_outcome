package h.a.f3;

import h.a.t2;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "elements", "", "Lkotlinx/coroutines/ThreadContextElement;", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "values", "[Ljava/lang/Object;", "append", "", "element", "value", "restore", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlin.k0.g f17403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f17404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t2<Object>[] f17405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17406d;

    public o0(kotlin.k0.g r1, int r2) {
        this.f17403a = r1;
        this.f17404b = new Object[r2];
        this.f17405c = new t2[r2];
    }

    public final void a(t2<?> r3, Object r4) {
        Object[] r0 = this.f17404b;
        int r1 = this.f17406d;
        r0[r1] = r4;
        t2<Object>[] r5 = this.f17405c;
        this.f17406d = r1 + 1;
        r5[r1] = r3;
    }

    public final void b(kotlin.k0.g r5) {
        int r0 = this.f17405c.length - 1;
        if (r0 < 0) goto L8;
    L4:
        int r1 = r0 - 1;
        t2<Object> r2 = this.f17405c[r0];
        kotlin.n0.d.o.c(r2);
        r2.Q(r5, this.f17404b[r0]);
        if (r1 < 0) goto L10;
        r0 = r1;
        goto L4
    L10:
        return;
    }
}
