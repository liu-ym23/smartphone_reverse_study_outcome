package h.a.e3;

import kotlin.Metadata;
import kotlin.f0;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<T>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class a<T> implements e<T> {

    /* JADX INFO: renamed from: h.a.e3.a$a, reason: collision with other inner class name */
    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0458a extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f17243f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f17244g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a<T> f17245h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f17246i;

        C0458a(a<T> r1, kotlin.k0.d<? super C0458a> r2) {
            this.f17245h = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17244g = r2;
            this.f17246i |= Integer.MIN_VALUE;
            return this.f17245h.collect(null, this);
        }
    }

    public a() {
    }

    public abstract Object b(f<? super T> r1, kotlin.k0.d<? super f0> r2);

    @Override // h.a.e3.e
    public final Object collect(f<? super T> r5, kotlin.k0.d<? super f0> r6) {
        if ((r6 instanceof C0458a) == false) goto L7;
        C0458a r0 = (C0458a) r6;
        int r1 = r0.f17246i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17246i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f17244g;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f17246i;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        h.a.e3.b0.h r4 = (h.a.e3.b0.h) r0.f17243f;
        kotlin.w.b(r7);     // Catch: Throwable -> L14
    L23:
        r4.releaseIntercepted();
        return f0.f18324a;
    L14:
        th = th;
    L27:
        r4.releaseIntercepted();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.w.b(r7);
        h.a.e3.b0.h r8 = new h.a.e3.b0.h(r5, r0.getContext());
        r0.f17243f = r8;     // Catch: Throwable -> L25
        r0.f17246i = 1;     // Catch: Throwable -> L25
        if (b(r8, r0) != r2) goto L22;
        return r2;
    L22:
        r4 = r8;
    L25:
        th = th;
        r4 = r8;
    L7:
        r0 = new C0458a(this, r6);
        goto L8
    }
}
