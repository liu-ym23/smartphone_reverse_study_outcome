package h.a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a_\u0010\u0006\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u0002H\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\n2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aU\u0010\u0011\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00032'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0013\u001a]\u0010\u0011\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0014\u001a\u00020\u00152'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0016\u0010\u0013\u001aJ\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00032'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aR\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0014\u001a\u00020\u00152'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\u000fH\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0013\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", LocationMonitorConst.TIMEOUT, "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class y2 {

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {100}, m = "withTimeoutOrNull")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a<T> extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f17591f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f17592g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f17593h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f17594i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f17595j;

        a(kotlin.k0.d<? super a> r1) {
            super(r1);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17594i = r3;
            this.f17595j |= Integer.MIN_VALUE;
            return y2.c(0, null, this);
        }
    }

    public static final w2 a(long r3, x1 r5) {
        return new w2("Timed out waiting for " + r3 + " ms", r5);
    }

    private static final <U, T extends U> Object b(x2<U, ? super T> r4, kotlin.n0.c.p<? super m0, ? super kotlin.k0.d<? super T>, ? extends Object> r5) {
        b2.f(r4, v0.b(r4.f17362h.getContext()).M(r4.f17586i, r4, r4.getContext()));
        return h.a.g3.b.c(r4, r4, r5);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, h.a.x2] */
    public static final <T> Object c(long r7, kotlin.n0.c.p<? super m0, ? super kotlin.k0.d<? super T>, ? extends Object> r9, kotlin.k0.d<? super T> r10) {
        if ((r10 instanceof a) == false) goto L7;
        a r0 = (a) r10;
        int r1 = r0.f17595j;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17595j = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f17594i;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f17595j;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        long r8 = r0.f17591f;
        kotlin.n0.d.d0 r12 = (kotlin.n0.d.d0) r0.f17593h;
        kotlin.n0.c.p r13 = (kotlin.n0.c.p) r0.f17592g;
        kotlin.w.b(r11);     // Catch: w2 -> L14
        return r11;
    L14:
        e = e;
    L32:
        if (e.f17577f != r12.f18431f) goto L34;
        return null;
    L34:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.w.b(r11);
        if (r7 > 0) goto L21;
        return null;
    L21:
        kotlin.n0.d.d0 r14 = new kotlin.n0.d.d0();
        r0.f17592g = r9;     // Catch: w2 -> L29
        r0.f17593h = r14;     // Catch: w2 -> L29
        r0.f17591f = r7;     // Catch: w2 -> L29
        r0.f17595j = 1;     // Catch: w2 -> L29
        ?? r4 = (T) new x2(r7, r0);
        r14.f18431f = r4;     // Catch: w2 -> L29
        Object r15 = b(r4, r9);     // Catch: w2 -> L29
        if (r15 != kotlin.k0.i.b.c()) goto L25;
        kotlin.k0.j.a.h.c(r0);     // Catch: w2 -> L29
    L25:
        if (r15 != r2) goto L28;
        return r2;
    L28:
        return r15;
    L29:
        e = e;
        r12 = r14;
    L7:
        r0 = new a(r10);
        goto L8
    }
}
