package kotlinx.coroutines.channels;

import a.a;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ArrayChannel<E> extends AbstractChannel<E> {
    public final ReentrantLock i;
    public Object[] j;
    public int k;
    public final int l;
    public final BufferOverflow m;
    private volatile int size;

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[BufferOverflow.values().length];
            r0[0] = 1;
            r0[2] = 2;
            r0[1] = 3;
        }
    }

    public ArrayChannel(int r2, BufferOverflow r3, Function1 r4) {
        super(r4);
        this.l = r2;
        this.m = r3;
        if (r2 < 1) goto L7;
        this.i = new ReentrantLock();
        int r5 = Math.min(r2, 8);
        Object[] r6 = new Object[r5];
        ArraysKt.l(AbstractChannelKt.f382a, r6, 0, r5);
        this.j = r6;
        this.size = 0;
        return;
    L7:
        throw new IllegalArgumentException(a.f(r2, "ArrayChannel capacity must be at least 1, but ", " was specified").toString());
    }

    public final Symbol A(int r4) {
        if (r4 >= this.l) goto L6;
        this.size = r4 + 1;
        return null;
    L6:
        int r3 = this.m.ordinal();
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L10;
        return null;
    L10:
        if (r3 != 2) goto L13;
        return AbstractChannelKt.b;
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        return AbstractChannelKt.c;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final Object c(Send r2) {
        ReentrantLock r0 = this.i;
        r0.lock();
        Object r1 = super.c(r2);     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final String d() {
        StringBuilder r0 = new StringBuilder("(buffer:capacity=");
        r0.append(this.l);
        r0.append(",size=");
        return a.l(r0, this.size, ')');
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean h() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean i() {
        if (this.size == this.l) goto L5;
    L7:
        return false;
    L5:
        if (this.m != BufferOverflow.b) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public final boolean j() {
        ReentrantLock r0 = this.i;
        r0.lock();
        boolean r1 = super.j();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final Object k(Object r5) {
        ReentrantLock r0 = this.i;
        r0.lock();
        int r1 = this.size;     // Catch: Throwable -> L19
        Closed r2 = f();     // Catch: Throwable -> L19
        if (r2 == null) goto L7;
        r0.unlock();
        return r2;
    L7:
        Symbol r3 = A(r1);     // Catch: Throwable -> L19
        if (r3 == null) goto L11;
        r0.unlock();
        return r3;
    L11:
        if (r1 != 0) goto L27;
    L12:
        ReceiveOrClosed r4 = m();     // Catch: Throwable -> L19
        if (r4 == null) goto L27;
        if ((r4 instanceof Closed) == true) goto L16;
        if (r4.r(r5, null) == null) goto L12;
        boolean r6 = DebugKt.f370a;     // Catch: Throwable -> L19
        this.size = r1;     // Catch: Throwable -> L19
        r0.unlock();
        r4.o(r5);
        return r4.f();
    L16:
        this.size = r1;     // Catch: Throwable -> L19
        r0.unlock();
        return r4;
    L27:
        y(r1, r5);     // Catch: Throwable -> L19
        Symbol r7 = AbstractChannelKt.b;     // Catch: Throwable -> L19
        r0.unlock();
        return r7;
    L19:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean q(Receive r2) {
        ReentrantLock r0 = this.i;
        r0.lock();
        boolean r1 = super.q(r2);     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean r() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean t() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final void u(boolean r10) {
        Function1 r0 = this.c;
        ReentrantLock r1 = this.i;
        r1.lock();
        int r2 = this.size;     // Catch: Throwable -> L10
        UndeliveredElementException r4 = null;
        int r5 = 0;
    L4:
        if (r5 >= r2) goto L13;
        Object r6 = this.j[this.k];     // Catch: Throwable -> L10
        Symbol r7 = AbstractChannelKt.f382a;
        if (r0 == null) goto L12;
        if (r6 == r7) goto L12;
        r4 = OnUndeliveredElementKt.b(r0, r6, r4);     // Catch: Throwable -> L10
    L12:
        Object[] r8 = this.j;     // Catch: Throwable -> L10
        int r9 = this.k;     // Catch: Throwable -> L10
        r8[r9] = r7;     // Catch: Throwable -> L10
        this.k = (r9 + 1) % r8.length;     // Catch: Throwable -> L10
        r5 = r5 + 1;     // Catch: Throwable -> L10
        goto L4
    L13:
        this.size = 0;     // Catch: Throwable -> L10
        r1.unlock();
        super.u(r10);
        if (r4 != null) goto L17;
        return;
    L17:
        throw r4;
    L10:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final Object v() {
        ReentrantLock r1 = this.i;
        r1.lock();
        int r2 = this.size;     // Catch: Throwable -> L11
        Object r3 = AbstractChannelKt.f383d;
        if (r2 != 0) goto L13;
        Closed r9 = f();     // Catch: Throwable -> L11
        if (r9 == null) goto L9;
        r3 = r9;
    L9:
        r1.unlock();
        return r3;
    L13:
        Object[] r4 = this.j;     // Catch: Throwable -> L11
        int r5 = this.k;     // Catch: Throwable -> L11
        Object r6 = r4[r5];     // Catch: Throwable -> L11
        Send r7 = null;
        r4[r5] = null;     // Catch: Throwable -> L11
        this.size = r2 - 1;     // Catch: Throwable -> L11
        boolean r8 = false;
        if (r2 != this.l) goto L23;
        Send r10 = null;
    L16:
        Send r11 = o();     // Catch: Throwable -> L11
        if (r11 == null) goto L22;
        if (r11.N(null) != null) goto L20;
        r11.O();     // Catch: Throwable -> L11
        r10 = r11;
        goto L16
    L20:
        boolean r12 = DebugKt.f370a;     // Catch: Throwable -> L11
        Object r13 = r11.L();     // Catch: Throwable -> L11
        r8 = true;
        r7 = r11;
    L24:
        if (r13 != r3) goto L26;
    L28:
        this.k = (this.k + 1) % this.j.length;     // Catch: Throwable -> L11
        r1.unlock();
        if (r8 == false) goto L32;
        Intrinsics.c(r7);
        r7.K();
    L32:
        return r6;
    L26:
        if ((r13 instanceof Closed) == true) goto L28;
        this.size = r2;     // Catch: Throwable -> L11
        Object[] r14 = this.j;     // Catch: Throwable -> L11
        r14[(this.k + r2) % r14.length] = r13;     // Catch: Throwable -> L11
        goto L28
    L22:
        r7 = r10;
    L23:
        r13 = r3;
    L11:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final Object w(SelectInstance r9) {
        ReentrantLock r0 = this.i;
        r0.lock();
        int r1 = this.size;     // Catch: Throwable -> L11
        Object r2 = AbstractChannelKt.f383d;
        if (r1 != 0) goto L13;
        Object r8 = f();     // Catch: Throwable -> L11
        if (r8 == null) goto L9;
        r2 = r8;
    L9:
        r0.unlock();
        return r2;
    L13:
        Object[] r3 = this.j;     // Catch: Throwable -> L11
        int r4 = this.k;     // Catch: Throwable -> L11
        Object r5 = r3[r4];     // Catch: Throwable -> L11
        Send r6 = null;
        r3[r4] = null;     // Catch: Throwable -> L11
        this.size = r1 - 1;     // Catch: Throwable -> L11
        if (r1 != this.l) goto L34;
    L15:
        AbstractChannel.TryPollDesc r7 = new AbstractChannel.TryPollDesc(this.b);     // Catch: Throwable -> L11
        Object r10 = r9.q(r7);     // Catch: Throwable -> L11
        if (r10 == null) goto L17;
        if (r10 == r2) goto L34;
        if (r10 == AtomicKt.b) goto L15;
        if (r10 != SelectKt.b) goto L30;
        this.size = r1;     // Catch: Throwable -> L11
        this.j[this.k] = r5;     // Catch: Throwable -> L11
        r0.unlock();
        return r10;
    L30:
        if ((r10 instanceof Closed) == false) goto L33;
        r6 = (Send) r10;     // Catch: Throwable -> L11
    L18:
        boolean r11 = true;
    L35:
        if (r10 == r2) goto L40;
        if ((r10 instanceof Closed) == true) goto L40;
        this.size = r1;     // Catch: Throwable -> L11
        Object[] r12 = this.j;     // Catch: Throwable -> L11
        r12[(this.k + r1) % r12.length] = r10;     // Catch: Throwable -> L11
    L44:
        this.k = (this.k + 1) % this.j.length;     // Catch: Throwable -> L11
        r0.unlock();
        if (r11 == false) goto L48;
        Intrinsics.c(r6);
        r6.K();
    L48:
        return r5;
    L40:
        if (r9.h() == true) goto L44;
        this.size = r1;     // Catch: Throwable -> L11
        this.j[this.k] = r5;     // Catch: Throwable -> L11
        Symbol r13 = SelectKt.b;     // Catch: Throwable -> L11
        r0.unlock();
        return r13;
    L33:
        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r10).toString());     // Catch: Throwable -> L11
    L17:
        r6 = (Send) r7.m();     // Catch: Throwable -> L11
        r10 = r6.L();     // Catch: Throwable -> L11
    L34:
        r11 = false;
        r10 = r2;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void y(int r8, Object r9) {
        int r0 = this.l;
        if (r8 >= r0) goto L11;
        Object[] r1 = this.j;
        if (r8 < r1.length) goto L10;
        int r2 = Math.min(r1.length * 2, r0);
        Object[] r3 = new Object[r2];
        int r4 = 0;
    L7:
        if (r4 >= r8) goto L9;
        Object[] r5 = this.j;
        r3[r4] = r5[(this.k + r4) % r5.length];
        r4 = r4 + 1;
        goto L7
    L9:
        Arrays.fill(r3, r8, r2, AbstractChannelKt.f382a);
        this.j = r3;
        this.k = 0;
    L10:
        Object[] r6 = this.j;
        r6[(this.k + r8) % r6.length] = r9;
        return;
    L11:
        boolean r7 = DebugKt.f370a;
        Object[] r10 = this.j;
        int r11 = this.k;
        r10[r11 % r10.length] = null;
        r10[(r8 + r11) % r10.length] = r9;
        this.k = (r11 + 1) % r10.length;
    }
}
