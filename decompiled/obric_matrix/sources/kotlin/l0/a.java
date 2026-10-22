package kotlin.l0;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.i0.i;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class a {

    /* JADX INFO: renamed from: kotlin.l0.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class C0476a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f18421a = null;

        static {
            Method[] r1 = Throwable.class.getMethods();
            o.e(r1, "throwableMethods");
            int r2 = r1.length;
            int r3 = 0;
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L13;
            Method r5 = r1[r4];
            if (o.a(r5.getName(), "addSuppressed") == false) goto L9;
            Class<?>[] r6 = r5.getParameterTypes();
            o.e(r6, "it.parameterTypes");
            if (o.a(i.T(r6), Throwable.class) == false) goto L9;
            boolean r7 = true;
        L10:
            if (r7 == true) goto L14;
            r4 = r4 + 1;
        L14:
            f18421a = r5;
            int r0 = r1.length;
        L15:
            if (r3 >= r0) goto L25;
            if (o.a(r1[r3].getName(), "getSuppressed") == true) goto L20;
            r3 = r3 + 1;
            goto L15
        L20:
            return;
        L25:
            return;
        L9:
            r7 = false;
            goto L10
        L13:
            r5 = null;
            goto L14
        }
    }

    public a() {
    }

    public void a(Throwable r3, Throwable r4) {
        o.f(r3, "cause");
        o.f(r4, "exception");
        Method r2 = C0476a.f18421a;
        if (r2 == null) goto L6;
        r2.invoke(r3, new Object[]{r4});
        return;
    }

    public kotlin.q0.c b() {
        return new kotlin.q0.b();
    }
}
