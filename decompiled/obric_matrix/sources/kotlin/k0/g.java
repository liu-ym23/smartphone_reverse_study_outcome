package kotlin.k0;

import kotlin.Metadata;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¨\u0006\u0013"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface g {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: kotlin.k0.g$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0475a extends q implements p<g, b, g> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0475a f18398f = null;

            static {
                f18398f = new C0475a();
            }

            C0475a() {
                super(2);
            }

            public final g a(g r3, b r4) {
                o.f(r3, "acc");
                o.f(r4, "element");
                g r2 = r3.minusKey(r4.getKey());
                h r5 = h.f18399f;
                if (r2 == r5) goto L15;
                e.b r0 = e.f18396a;
                e r1 = (e) r2.get(r0);
                if (r1 != null) goto L9;
                kotlin.k0.c r6 = new kotlin.k0.c(r2, r4);
            L13:
                return r6;
            L9:
                g r7 = r2.minusKey(r0);
                if (r7 == r5) goto L14;
                r6 = new kotlin.k0.c(new kotlin.k0.c(r7, r4), r1);
                goto L13
            L14:
                return new kotlin.k0.c(r4, r1);
            L15:
                return r4;
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ g invoke(g r1, b r2) {
                return a(r1, r2);
            }
        }

        public static g a(g r1, g r2) {
            o.f(r2, "context");
            if (r2 != h.f18399f) goto L6;
            return r1;
        L6:
            return (g) r2.fold(r1, C0475a.f18398f);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b extends g {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a {
            public static <R> R a(b r1, R r2, p<? super R, ? super b, ? extends R> r3) {
                o.f(r3, "operation");
                return r3.invoke(r2, r1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b r1, c<E> r2) {
                o.f(r2, "key");
                if (o.a(r1.getKey(), r2) == false) goto L5;
                o.d(r1, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return r1;
            L5:
                return null;
            }

            public static g c(b r1, c<?> r2) {
                o.f(r2, "key");
                if (o.a(r1.getKey(), r2) == true) goto L5;
                return r1;
            L5:
                return h.f18399f;
            }

            public static g d(b r1, g r2) {
                o.f(r2, "context");
                return a.a(r1, r2);
            }
        }

        @Override // kotlin.k0.g
        <E extends b> E get(c<E> r1);

        c<?> getKey();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface c<E extends b> {
    }

    <R> R fold(R r1, p<? super R, ? super b, ? extends R> r2);

    <E extends b> E get(c<E> r1);

    g minusKey(c<?> r1);

    g plus(g r1);
}
