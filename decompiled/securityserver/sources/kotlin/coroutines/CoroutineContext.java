package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public interface CoroutineContext {

    @Metadata
    public static final class DefaultImpls {
        public static CoroutineContext a(CoroutineContext r1, CoroutineContext r2) {
            Intrinsics.f(r2, "context");
            if (r2 != EmptyCoroutineContext.b) goto L6;
            return r1;
        L6:
            return (CoroutineContext) r2.H(r1, CoroutineContext$plus$1.b);
        }
    }

    @Metadata
    public interface Element extends CoroutineContext {

        @Metadata
        public static final class DefaultImpls {
            public static Element a(Element r1, Key r2) {
                Intrinsics.f(r2, "key");
                if (Intrinsics.a(r1.getKey(), r2) == true) goto L7;
                return null;
            L7:
                return r1;
            }

            public static CoroutineContext b(Element r1, Key r2) {
                Intrinsics.f(r2, "key");
                if (Intrinsics.a(r1.getKey(), r2) == true) goto L5;
                return r1;
            L5:
                return EmptyCoroutineContext.b;
            }

            public static CoroutineContext c(Element r1, CoroutineContext r2) {
                Intrinsics.f(r2, "context");
                return DefaultImpls.a(r1, r2);
            }
        }

        Key getKey();
    }

    @Metadata
    public interface Key<E extends Element> {
    }

    Object H(Object r1, Function2 r2);

    Element f(Key r1);

    CoroutineContext i(CoroutineContext r1);

    CoroutineContext v(Key r1);
}
