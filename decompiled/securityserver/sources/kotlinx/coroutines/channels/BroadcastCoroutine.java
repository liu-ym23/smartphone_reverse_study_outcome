package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    @Override // kotlinx.coroutines.channels.SendChannel
    public final void E(Function1 r1) {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object I(Object r1, Continuation r2) {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean J() {
        throw null;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void P(CancellationException r1) {
        JobSupport.t0(this, r1);
        throw null;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void a(CancellationException r3) {
        if (r3 != null) goto L6;
        r3 = new JobCancellationException(R(), null, this);
    L6:
        JobSupport.t0(this, r3);
        throw null;
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public final SendChannel getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void v0(Throwable r1, boolean r2) {
        throw null;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void w0(Object r1) {
        Unit r2 = (Unit) r1;
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean z(Throwable r1) {
        throw null;
    }
}
