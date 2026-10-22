package h.a.e3.b0;

import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.q;
import kotlin.n0.d.j0;
import kotlin.n0.d.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\">\u0010\u0000\u001a,\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"emitFun", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/coroutines/Continuation;", "", "getEmitFun$annotations", "()V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q<h.a.e3.f<Object>, Object, kotlin.k0.d<? super f0>, Object> f17279a = null;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class a extends m implements q<h.a.e3.f<? super Object>, Object, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f17280f = null;

        static {
            f17280f = new a();
        }

        a() {
            super(3, h.a.e3.f.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ Object f(Object r1, Object r2, Object r3) {
            return m((h.a.e3.f) r1, r2, (kotlin.k0.d) r3);
        }

        public final Object m(h.a.e3.f<Object> r1, Object r2, kotlin.k0.d<? super f0> r3) {
            return r1.emit(r2, r3);
        }
    }

    static {
        a r0 = a.f17280f;
        j0.e(r0, 3);
        f17279a = r0;
    }

    public static final /* synthetic */ q a() {
        return f17279a;
    }
}
