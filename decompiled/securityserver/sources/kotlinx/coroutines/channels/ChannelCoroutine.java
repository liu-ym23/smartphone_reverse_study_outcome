package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    public final Channel f;

    public ChannelCoroutine(CoroutineContext r2, AbstractChannel r3) {
        super(r2, true);
        this.f = r3;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void E(Function1 r1) {
        this.f.E(r1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object G(Continuation r1) {
        return this.f.G(r1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object I(Object r1, Continuation r2) {
        return this.f.I(r1, r2);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean J() {
        return this.f.J();
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void P(CancellationException r2) {
        CancellationException r3 = JobSupport.t0(this, r2);
        this.f.a(r3);
        O(r3);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void a(CancellationException r3) {
        if (this.f.j() == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        r3 = new JobCancellationException(R(), null, this);
    L8:
        P(r3);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        return this.f.iterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean j() {
        return this.f.j();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 l() {
        return this.f.l();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 n() {
        return this.f.n();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object poll() {
        return this.f.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object s(Continuation r1) {
        return this.f.s(r1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean z(Throwable r1) {
        return this.f.z(r1);
    }
}
