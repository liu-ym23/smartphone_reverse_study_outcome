package h.a.e3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R:\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class z<T> implements f<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f<T> f17335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.n0.c.p<f<? super T>, kotlin.k0.d<? super f0>, Object> f17336g;

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "onSubscription")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f17337f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f17338g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f17339h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ z<T> f17340i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f17341j;

        a(z<T> r1, kotlin.k0.d<? super a> r2) {
            this.f17340i = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17339h = r2;
            this.f17341j |= Integer.MIN_VALUE;
            return this.f17340i.b(this);
        }
    }

    public final Object b(kotlin.k0.d<? super f0> r8) {
        if ((r8 instanceof a) == false) goto L7;
        a r0 = (a) r8;
        int r1 = r0.f17341j;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17341j = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f17339h;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f17341j;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        kotlin.w.b(r9);
    L31:
        return f0.f18324a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        h.a.e3.b0.h r7 = (h.a.e3.b0.h) r0.f17338g;
        z<T> r4 = (z) r0.f17337f;
        kotlin.w.b(r9);     // Catch: Throwable -> L18
    L25:
        r7.releaseIntercepted();
        f<T> r10 = r4.f17335f;
        if ((r10 instanceof z) == false) goto L33;
        r0.f17337f = null;
        r0.f17338g = null;
        r0.f17341j = 2;
        if (((z) r10).b(r0) != r2) goto L31;
        return r2;
    L33:
        return f0.f18324a;
    L18:
        Throwable th = th;
    L36:
        r7.releaseIntercepted();
        throw th;
    L20:
        kotlin.w.b(r9);
        h.a.e3.b0.h r11 = new h.a.e3.b0.h(this.f17335f, r0.getContext());
        kotlin.n0.c.p<f<? super T>, kotlin.k0.d<? super f0>, Object> r5 = this.f17336g;     // Catch: Throwable -> L34
        r0.f17337f = this;     // Catch: Throwable -> L34
        r0.f17338g = r11;     // Catch: Throwable -> L34
        r0.f17341j = 1;     // Catch: Throwable -> L34
        if (r5.invoke(r11, r0) != r2) goto L24;
        return r2;
    L24:
        r4 = this;
        r7 = r11;
    L34:
        th = move-exception;
        th = th;
        r7 = r11;
    L7:
        r0 = new a(this, r8);
        goto L8
    }

    @Override // h.a.e3.f
    public Object emit(T r1, kotlin.k0.d<? super f0> r2) {
        return this.f17335f.emit(r1, r2);
    }
}
