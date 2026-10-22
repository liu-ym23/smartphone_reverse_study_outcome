package h.a.d3;

import h.a.f3.p0;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0014¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class q<E> extends a<E> {
    public q(kotlin.n0.c.l<? super E, f0> r1) {
        super(r1);
    }

    @Override // h.a.d3.a
    protected final boolean I() {
        return true;
    }

    @Override // h.a.d3.a
    protected final boolean J() {
        return true;
    }

    @Override // h.a.d3.a
    protected void M(Object r6, m<?> r7) {
        p0 r0 = null;
        if (r6 != null) goto L6;
    L27:
        if (r0 != null) goto L29;
        return;
    L29:
        throw r0;
    L6:
        if ((r6 instanceof ArrayList) == true) goto L14;
        y r8 = (y) r6;
        if ((r8 instanceof c.a) == false) goto L13;
        kotlin.n0.c.l<E, f0> r5 = this.f17212f;
        if (r5 == null) goto L27;
        r0 = h.a.f3.z.c(r5, ((c.a) r8).f17214i, null);
        goto L27
    L13:
        r8.E(r7);
        goto L27
    L14:
        Objects.requireNonNull(r6, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r9 = (ArrayList) r6;
        int r1 = r9.size() - 1;
        if (r1 < 0) goto L27;
        p0 r2 = null;
    L17:
        int r3 = r1 - 1;
        y r4 = (y) r9.get(r1);
        if ((r4 instanceof c.a) == false) goto L23;
        kotlin.n0.c.l<E, f0> r10 = this.f17212f;
        if (r10 != null) goto L22;
        r2 = null;
    L24:
        if (r3 < 0) goto L25;
        r1 = r3;
        goto L17
    L25:
        r0 = r2;
        goto L27
    L22:
        r2 = h.a.f3.z.c(r10, ((c.a) r4).f17214i, r2);
        goto L24
    L23:
        r4.E(r7);
        goto L24
    }

    @Override // h.a.d3.c
    protected final boolean u() {
        return false;
    }

    @Override // h.a.d3.c
    protected final boolean v() {
        return false;
    }

    @Override // h.a.d3.c
    protected Object x(E r4) {
    L2:
        Object r0 = super.x(r4);
        h.a.f3.f0 r1 = b.f17205b;
        if (r0 == r1) goto L4;
        if (r0 != b.f17206c) goto L14;
        w<?> r2 = z(r4);
        if (r2 == null) goto L9;
        if ((r2 instanceof m) == false) goto L2;
        return r2;
    L9:
        return r1;
    L14:
        if ((r0 instanceof m) == false) goto L17;
        return r0;
    L17:
        throw new IllegalStateException(kotlin.n0.d.o.m("Invalid offerInternal result ", r0).toString());
    L4:
        return r1;
    }
}
