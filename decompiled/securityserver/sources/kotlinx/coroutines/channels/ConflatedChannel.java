package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ConflatedChannel<E> extends AbstractChannel<E> {
    public final ReentrantLock i;
    public Object j;

    public ConflatedChannel(Function1 r1) {
        super(r1);
        this.i = new ReentrantLock();
        this.j = AbstractChannelKt.f382a;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final String d() {
        return "(value=" + this.j + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean h() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean i() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object k(Object r4) {
        ReentrantLock r0 = this.i;
        r0.lock();
        Closed r1 = f();     // Catch: Throwable -> L21
        if (r1 == null) goto L8;
        r0.unlock();
        return r1;
    L8:
        if (this.j != AbstractChannelKt.f382a) goto L23;
    L9:
        ReceiveOrClosed r2 = m();     // Catch: Throwable -> L21
        if (r2 == null) goto L23;
        if ((r2 instanceof Closed) == true) goto L13;
        if (r2.r(r4, null) == null) goto L9;
        boolean r3 = DebugKt.f370a;     // Catch: Throwable -> L21
        r0.unlock();
        r2.o(r4);
        return r2.f();
    L13:
        r0.unlock();
        return r2;
    L23:
        UndeliveredElementException r5 = y(r4);     // Catch: Throwable -> L21
        if (r5 != null) goto L28;
        Symbol r6 = AbstractChannelKt.b;     // Catch: Throwable -> L21
        r0.unlock();
        return r6;
    L28:
        throw r5;     // Catch: Throwable -> L21
    L21:
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
        if (this.j != AbstractChannelKt.f382a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void u(boolean r3) {
        ReentrantLock r0 = this.i;
        r0.lock();
        UndeliveredElementException r1 = y(AbstractChannelKt.f382a);     // Catch: Throwable -> L8
        r0.unlock();
        super.u(r3);
        if (r1 != null) goto L7;
        return;
    L7:
        throw r1;
    L8:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final Object v() {
        ReentrantLock r0 = this.i;
        r0.lock();
        Object r1 = this.j;     // Catch: Throwable -> L11
        Symbol r2 = AbstractChannelKt.f382a;     // Catch: Throwable -> L11
        if (r1 != r2) goto L13;
        Object r3 = f();     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = AbstractChannelKt.f383d;     // Catch: Throwable -> L11
    L9:
        r0.unlock();
        return r3;
    L13:
        this.j = r2;     // Catch: Throwable -> L11
        r0.unlock();
        return r1;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final Object w(SelectInstance r4) {
        ReentrantLock r0 = this.i;
        r0.lock();
        Object r1 = this.j;     // Catch: Throwable -> L11
        Symbol r2 = AbstractChannelKt.f382a;     // Catch: Throwable -> L11
        if (r1 != r2) goto L14;
        Object r3 = f();     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = AbstractChannelKt.f383d;     // Catch: Throwable -> L11
    L9:
        r0.unlock();
        return r3;
    L14:
        if (r4.h() == true) goto L18;
        Symbol r5 = SelectKt.b;     // Catch: Throwable -> L11
        r0.unlock();
        return r5;
    L18:
        Object r6 = this.j;     // Catch: Throwable -> L11
        this.j = r2;     // Catch: Throwable -> L11
        r0.unlock();
        return r6;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final UndeliveredElementException y(Object r4) {
        Object r0 = this.j;
        UndeliveredElementException r2 = null;
        if (r0 == AbstractChannelKt.f382a) goto L8;
        Function1 r1 = this.c;
        if (r1 == null) goto L8;
        r2 = OnUndeliveredElementKt.b(r1, r0, null);
    L8:
        this.j = r4;
        return r2;
    }
}
