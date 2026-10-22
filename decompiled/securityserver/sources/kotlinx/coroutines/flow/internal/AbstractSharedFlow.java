package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    public AbstractSharedFlowSlot[] b;
    public int c;
    public int e;

    public final AbstractSharedFlowSlot c() {
        monitor-enter(this);
        AbstractSharedFlowSlot[] r0 = this.b;     // Catch: Throwable -> L6
        if (r0 != null) goto L9;
        r0 = f();     // Catch: Throwable -> L6
        this.b = r0;     // Catch: Throwable -> L6
    L11:
        int r1 = this.e;     // Catch: Throwable -> L6
    L12:
        AbstractSharedFlowSlot r2 = r0[r1];     // Catch: Throwable -> L6
        if (r2 != null) goto L16;
        r2 = e();     // Catch: Throwable -> L6
        r0[r1] = r2;     // Catch: Throwable -> L6
    L16:
        r1 = r1 + 1;     // Catch: Throwable -> L6
        if (r1 < r0.length) goto L20;
        r1 = 0;
    L20:
        if (r2.a(this) == false) goto L12;
        this.e = r1;     // Catch: Throwable -> L6
        this.c++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L9:
        if (this.c < r0.length) goto L11;
        Object[] r3 = Arrays.copyOf(r0, r0.length * 2);     // Catch: Throwable -> L6
        Intrinsics.e(r3, "java.util.Arrays.copyOf(this, newSize)");     // Catch: Throwable -> L6
        this.b = (AbstractSharedFlowSlot[]) r3;     // Catch: Throwable -> L6
        r0 = (AbstractSharedFlowSlot[]) r3;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public abstract AbstractSharedFlowSlot e();

    public abstract AbstractSharedFlowSlot[] f();

    public final void g(AbstractSharedFlowSlot r4) {
        monitor-enter(this);
        int r0 = this.c - 1;     // Catch: Throwable -> L6
        this.c = r0;     // Catch: Throwable -> L6
        int r1 = 0;
        if (r0 != 0) goto L8;
        this.e = 0;     // Catch: Throwable -> L6
    L8:
        if (r4 == null) goto L19;
        Continuation[] r5 = r4.b(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        int r3 = r5.length;
    L12:
        if (r1 >= r3) goto L17;
        Continuation r2 = r5[r1];
        if (r2 == null) goto L16;
        r2.k(Unit.f330a);
    L16:
        r1 = r1 + 1;
        goto L12
    L17:
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
