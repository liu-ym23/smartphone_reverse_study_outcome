package cz.msebera.android.httpclient.util;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class ExceptionUtils {
    private static final Method INIT_CAUSE_METHOD = null;

    static {
        INIT_CAUSE_METHOD = getInitCauseMethod();
    }

    private static Method getInitCauseMethod() {
        return Throwable.class.getMethod("initCause", new Class[]{Throwable.class});
    L5:
        return null;
    }

    public static void initCause(Throwable r3, Throwable r4) {
        Method r0 = INIT_CAUSE_METHOD;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.invoke(r3, new Object[]{r4});     // Catch: Exception -> L7
        return;
    }

    private ExceptionUtils() {
    }
}
