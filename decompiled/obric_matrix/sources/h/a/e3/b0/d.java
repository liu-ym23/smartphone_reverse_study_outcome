package h.a.e3.b0;

import h.a.d3.r;
import h.a.d3.t;
import h.a.d3.v;
import h.a.m0;
import h.a.n0;
import h.a.o0;
import h.a.q0;
import h.a.r0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001f\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\fH¤@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH$J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H\u0016J&\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u001c\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R9\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "additionalToStringProps", "", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class d<T> implements Object<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kotlin.k0.g f17258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h.a.d3.e f17260h;

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f17261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f17262g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ h.a.e3.f<T> f17263h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d<T> f17264i;

        /* JADX WARN: Multi-variable type inference failed */
        a(h.a.e3.f<? super T> r1, d<T> r2, kotlin.k0.d<? super a> r3) {
            this.f17263h = r1;
            this.f17264i = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r3, kotlin.k0.d<?> r4) {
            a r0 = new a(this.f17263h, this.f17264i, r4);
            r0.f17262g = r3;
            return r0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((a) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f17261f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r5);
        L12:
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r5);
            m0 r6 = (m0) this.f17262g;
            h.a.e3.f<T> r2 = this.f17263h;
            v<T> r7 = this.f17264i.g(r6);
            this.f17261f = 1;
            if (h.a.e3.g.e(r2, r7, this) != r0) goto L12;
            return r0;
        }
    }

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "it", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends l implements p<t<? super T>, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f17265f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f17266g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d<T> f17267h;

        b(d<T> r1, kotlin.k0.d<? super b> r2) {
            this.f17267h = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
            b r0 = new b(this.f17267h, r3);
            r0.f17266g = r2;
            return r0;
        }

        public final Object invoke(t<? super T> r1, kotlin.k0.d<? super f0> r2) {
            return ((b) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(Object r1, kotlin.k0.d<? super f0> r2) {
            return invoke((t) r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f17265f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r4);
        L12:
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r4);
            t<? super T> r5 = (t) this.f17266g;
            d<T> r2 = this.f17267h;
            this.f17265f = 1;
            if (r2.d(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public d(kotlin.k0.g r1, int r2, h.a.d3.e r3) {
        this.f17258f = r1;
        this.f17259g = r2;
        this.f17260h = r3;
        if (q0.a() == true) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    static /* synthetic */ Object c(d r2, h.a.e3.f r3, kotlin.k0.d r4) {
        Object r5 = n0.e(new a(r3, r2, null), r4);
        if (r5 != kotlin.k0.i.b.c()) goto L6;
        return r5;
    L6:
        return f0.f18324a;
    }

    protected String b() {
        return null;
    }

    public Object collect(h.a.e3.f<? super T> r1, kotlin.k0.d<? super f0> r2) {
        return c(this, r1, r2);
    }

    protected abstract Object d(t<? super T> r1, kotlin.k0.d<? super f0> r2);

    public final p<t<? super T>, kotlin.k0.d<? super f0>, Object> e() {
        return new b(this, null);
    }

    public final int f() {
        int r1 = this.f17259g;
        if (r1 != (-3)) goto L6;
        return -2;
    L6:
        return r1;
    }

    public v<T> g(m0 r10) {
        return r.c(r10, this.f17258f, f(), this.f17260h, o0.f17547h, null, e(), 16, null);
    }

    @Override // java.lang.Object
    public String toString() {
        ArrayList r0 = new ArrayList(4);
        String r1 = b();
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        kotlin.k0.g r2 = this.f17258f;
        if (r2 == kotlin.k0.h.f18399f) goto L9;
        r0.add(o.m("context=", r2));
    L9:
        int r3 = this.f17259g;
        if (r3 == (-3)) goto L12;
        r0.add(o.m("capacity=", Integer.valueOf(r3)));
    L12:
        h.a.d3.e r4 = this.f17260h;
        if (r4 == h.a.d3.e.f17221f) goto L16;
        r0.add(o.m("onBufferOverflow=", r4));
    L16:
        return r0.a(this) + '[' + kotlin.i0.r.Z(r0, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
