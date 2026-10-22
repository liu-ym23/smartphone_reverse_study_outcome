package h.a.f3;

import com.bytedance.common.wschannel.WsConstants;
import h.a.t2;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f17377a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.n0.c.p<Object, kotlin.k0.g.b, Object> f17378b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.n0.c.p<t2<?>, kotlin.k0.g.b, t2<?>> f17379c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.n0.c.p<o0, kotlin.k0.g.b, o0> f17380d = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "", "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.p<Object, kotlin.k0.g.b, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f17381f = null;

        static {
            f17381f = new a();
        }

        a() {
            super(2);
        }

        public final Object a(Object r1, kotlin.k0.g.b r2) {
            if ((r2 instanceof t2) == true) goto L5;
            return r1;
        L5:
            if ((r1 instanceof Integer) == false) goto L7;
            Integer r3 = (Integer) r1;
        L9:
            if (r3 != null) goto L11;
            int r4 = 1;
        L12:
            if (r4 != 0) goto L15;
            return r2;
        L15:
            return Integer.valueOf(r4 + 1);
        L11:
            r4 = r3.intValue();
            goto L12
        L7:
            r3 = null;
            goto L9
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(Object r1, kotlin.k0.g.b r2) {
            return a(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "Lkotlinx/coroutines/ThreadContextElement;", "found", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<t2<?>, kotlin.k0.g.b, t2<?>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f17382f = null;

        static {
            f17382f = new b();
        }

        b() {
            super(2);
        }

        public final t2<?> a(t2<?> r1, kotlin.k0.g.b r2) {
            if (r1 == null) goto L5;
            return r1;
        L5:
            if ((r2 instanceof t2) == true) goto L9;
            return null;
        L9:
            return (t2) r2;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ t2<?> invoke(t2<?> r1, kotlin.k0.g.b r2) {
            return a(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", WsConstants.KEY_CONNECTION_STATE, "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.p<o0, kotlin.k0.g.b, o0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f17383f = null;

        static {
            f17383f = new c();
        }

        c() {
            super(2);
        }

        public final o0 a(o0 r1, kotlin.k0.g.b r2) {
            if ((r2 instanceof t2) == false) goto L5;
            t2<?> r3 = (t2) r2;
            r1.a(r3, r3.d0(r1.f17403a));
        L5:
            return r1;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ o0 invoke(o0 r1, kotlin.k0.g.b r2) {
            o0 r3 = r1;
            a(r3, r2);
            return r3;
        }
    }

    static {
        f17377a = new f0("NO_THREAD_ELEMENTS");
        f17378b = a.f17381f;
        f17379c = b.f17382f;
        f17380d = c.f17383f;
    }

    public static final void a(kotlin.k0.g r2, Object r3) {
        if (r3 != f17377a) goto L6;
        return;
    L6:
        if ((r3 instanceof o0) == false) goto L8;
        ((o0) r3).b(r2);
        return;
    L8:
        Object r0 = r2.fold(null, f17379c);
        Objects.requireNonNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((t2) r0).Q(r2, r3);
    }

    public static final Object b(kotlin.k0.g r2) {
        Object r3 = r2.fold(0, f17378b);
        kotlin.n0.d.o.c(r3);
        return r3;
    }

    public static final Object c(kotlin.k0.g r1, Object r2) {
        if (r2 != null) goto L5;
        r2 = b(r1);
    L5:
        if (r2 != 0) goto L8;
        return f17377a;
    L8:
        if ((r2 instanceof Integer) == false) goto L11;
        return r1.fold(new o0(r1, ((Number) r2).intValue()), f17380d);
    L11:
        return ((t2) r2).d0(r1);
    }
}
