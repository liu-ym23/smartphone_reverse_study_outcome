package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlinx.coroutines.internal.ArrayQueue;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class EventLoop extends CoroutineDispatcher {
    public long e;
    public boolean f;
    public ArrayQueue i;

    public final void m() {
        long r0 = this.e - 4294967296L;
        this.e = r0;
        if (r0 <= 0) goto L5;
        return;
    L5:
        boolean r1 = DebugKt.f370a;
        if (this.f == false) goto L9;
        shutdown();
        return;
    }

    public final void n(DispatchedTask r12) {
        ArrayQueue r0 = this.i;
        if (r0 != null) goto L6;
        r0 = new ArrayQueue();
        r0.f405a = new Object[16];
        this.i = r0;
    L6:
        Object[] r1 = r0.f405a;
        int r11 = r0.c;
        r1[r11] = r12;
        int r13 = (r11 + 1) & (r1.length - 1);
        r0.c = r13;
        int r4 = r0.b;
        if (r13 != r4) goto L10;
        int r14 = r1.length;
        Object[] r15 = new Object[r14 << 1];
        ArraysKt.i(r1, r15, 0, r4, 0, 10);
        Object[] r5 = r0.f405a;
        int r2 = r5.length;
        int r9 = r0.b;
        ArraysKt.i(r5, r15, r2 - r9, 0, r9, 4);
        r0.f405a = r15;
        r0.b = 0;
        r0.c = r14;
        return;
    }

    public final void s(boolean r5) {
        long r0 = this.e;
        if (r5 == false) goto L5;
        long r2 = 4294967296L;
    L6:
        this.e = r2 + r0;
        if (r5 == true) goto L10;
        this.f = true;
        return;
    L10:
        return;
    L5:
        r2 = 1;
        goto L6
    }

    public void shutdown() {
    }

    public final boolean u() {
        if (this.e < 4294967296L) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean w() {
        ArrayQueue r6 = this.i;
        if (r6 == null) goto L17;
        int r1 = r6.b;
        Object r4 = null;
        if (r1 == r6.c) goto L10;
        Object[] r2 = r6.f405a;
        Object r5 = r2[r1];
        r2[r1] = null;
        r6.b = (r1 + 1) & (r2.length - 1);
        if (r5 == null) goto L16;
        r4 = r5;
        goto L10
    L16:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L10:
        DispatchedTask r7 = (DispatchedTask) r4;
        if (r7 == null) goto L14;
        r7.run();
        return true;
    L14:
        return false;
    L17:
        return false;
    }
}
