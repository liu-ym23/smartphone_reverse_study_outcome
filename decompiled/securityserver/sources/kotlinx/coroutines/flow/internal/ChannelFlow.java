package kotlinx.coroutines.flow.internal;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public abstract class ChannelFlow<T> implements FusibleFlow<T> {
    public final CoroutineContext b;
    public final int c;
    public final BufferOverflow e;

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[BufferOverflow.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
        }
    }

    public ChannelFlow(CoroutineContext r1, int r2, BufferOverflow r3) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
        boolean r0 = DebugKt.f370a;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector r3, Continuation r4) {
        ChannelFlow$collect$2 r0 = new ChannelFlow$collect$2(this, r3, null);
        ScopeCoroutine r2 = new ScopeCoroutine(r4, r4.getContext());
        Object r5 = UndispatchedKt.b(r2, r2, r0);
        if (r5 != CoroutineSingletons.b) goto L6;
        return r5;
    L6:
        return Unit.f330a;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow b(CoroutineContext r5, int r6, BufferOverflow r7) {
        boolean r0 = DebugKt.f370a;
        CoroutineContext r1 = this.b;
        CoroutineContext r8 = r5.i(r1);
        BufferOverflow r2 = BufferOverflow.b;
        BufferOverflow r3 = this.e;
        int r4 = this.c;
        if (r7 != r2) goto L21;
        if (r4 == (-3)) goto L19;
        if (r6 != (-3)) goto L11;
    L9:
        r6 = r4;
        goto L19
    L11:
        if (r4 == (-2)) goto L19;
        if (r6 == (-2)) goto L9;
        r6 = r6 + r4;
        if (r6 >= 0) goto L19;
        r6 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L19:
        r7 = r3;
    L21:
        if (Intrinsics.a(r8, r1) == false) goto L26;
        if (r6 != r4) goto L26;
        if (r7 != r3) goto L26;
        return this;
    L26:
        return e(r8, r6, r7);
    }

    public String c() {
        return null;
    }

    public abstract Object d(ProducerScope r1, Continuation r2);

    public abstract ChannelFlow e(CoroutineContext r1, int r2, BufferOverflow r3);

    public ReceiveChannel f(CoroutineScope r6) {
        int r1 = this.c;
        if (r1 != (-3)) goto L5;
        r1 = -2;
    L5:
        CoroutineStart r0 = CoroutineStart.e;
        Function2 r2 = new ChannelFlow$collectToFun$1(this, null);
        AbstractChannel r3 = ChannelKt.a(r1, this.e, 4);
        ProducerCoroutine r7 = new ProducerCoroutine(CoroutineContextKt.a(r6, this.b), r3);
        r7.y0(r0, r7, r2);
        return r7;
    }

    public String toString() {
        ArrayList r0 = new ArrayList(4);
        String r1 = c();
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        EmptyCoroutineContext r2 = EmptyCoroutineContext.b;
        CoroutineContext r3 = this.b;
        if (r3 == r2) goto L8;
        r0.add("context=" + r3);
    L8:
        int r4 = this.c;
        if (r4 == (-3)) goto L11;
        r0.add("capacity=" + r4);
    L11:
        BufferOverflow r5 = BufferOverflow.b;
        BufferOverflow r6 = this.e;
        if (r6 == r5) goto L15;
        r0.add("onBufferOverflow=" + r6);
    L15:
        return getClass().getSimpleName() + '[' + CollectionsKt.i(r0, ", ", null, null, null, 62) + ']';
    }
}
