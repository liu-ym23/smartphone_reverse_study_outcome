package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class PlatformImplementations {

    @Metadata
    public static final class ReflectThrowable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f339a = null;

        static {
            Method[] r1 = Throwable.class.getMethods();
            Intrinsics.e(r1, "throwableMethods");
            int r2 = r1.length;
            int r3 = 0;
            int r4 = 0;
        L3:
            Method r5 = null;
            Class<?> r6 = null;
            if (r4 >= r2) goto L14;
            Method r7 = r1[r4];
            if (Intrinsics.a(r7.getName(), "addSuppressed") == false) goto L13;
            Class<?>[] r8 = r7.getParameterTypes();
            Intrinsics.e(r8, "it.parameterTypes");
            if (r8.length != 1) goto L11;
            r6 = r8[0];
        L11:
            if (Intrinsics.a(r6, Throwable.class) == false) goto L13;
            r5 = r7;
        L13:
            r4 = r4 + 1;
        L14:
            f339a = r5;
            int r0 = r1.length;
        L15:
            if (r3 >= r0) goto L27;
            if (Intrinsics.a(r1[r3].getName(), "getSuppressed") == true) goto L20;
            r3 = r3 + 1;
            goto L15
        L20:
            return;
        }
    }

    public void a(Throwable r1, Throwable r2) {
        Intrinsics.f(r1, "cause");
        Intrinsics.f(r2, "exception");
        Method r0 = ReflectThrowable.f339a;
        if (r0 == null) goto L6;
        r0.invoke(r1, new Object[]{r2});
        return;
    }

    public Random b() {
        return new FallbackThreadLocalRandom();
    }
}
